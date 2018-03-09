package com.robustel.auth.security.userdetails;

import com.robustel.auth.common.entity.Permission;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 14:40 2018/3/7
 * Modified By:
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {
    protected final Log logger = LogFactory.getLog(this.getClass());

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();
    private String authoritiesByUsernameQuery = "select t2.user_name,t4.fun_code from tbs_pl_user_role t1,tbs_pl_user_base_info t2,tbs_pl_role_fun t3,tbs_pl_fun_info t4\n" +
            "where t2.user_id=? and t1.user_id=t2.user_id and t3.role_id=t1.role_id and t3.fun_id=t4.fun_id ";
    private String groupAuthoritiesByUsernameQuery = "select g.id, g.group_name, ga.authority from groups g, group_members gm, group_authorities ga where gm.username = ? and g.id = ga.group_id and g.id = gm.group_id";
    private String usersByUsernameQuery = "select user_name,login_pwd,user_id from tbs_pl_user_base_info where state in ('1','3') and (login_account=? or email=?)";

    private String  permissionByUseridQuery = "";
    private String rolePrefix = "";
    private boolean usernameBasedPrimaryKey = true;
    private boolean enableAuthorities = true;
    private boolean enableGroups;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    protected MessageSourceAccessor getMessages() {
        return this.messages;
    }

    protected void addCustomAuthorities(String username, List<GrantedAuthority> authorities) {
    }

    public String getUsersByUsernameQuery() {
        return this.usersByUsernameQuery;
    }


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetails> users = this.loadUsersByUsername(username);
        if (users.size() == 0) {
            this.logger.debug("Query returned no results for user '" + username + "'");
            throw new UsernameNotFoundException(this.messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found"));
        } else {
            CustomUserDetails user = (CustomUserDetails)users.get(0);
            Set<GrantedAuthority> dbAuthsSet = new HashSet();
            if (this.enableAuthorities) {
                dbAuthsSet.addAll(this.loadUserAuthorities(user.getUserId()));
            }

            if (this.enableGroups) {
                dbAuthsSet.addAll(this.loadGroupAuthorities(user.getUserId()));
            }

            List<GrantedAuthority> dbAuths = new ArrayList(dbAuthsSet);
            this.addCustomAuthorities(user.getUsername(), dbAuths);
            if (dbAuths.size() == 0) {
                this.logger.debug("User '" + username + "' has no authorities and will be treated as 'not found'");
                throw new UsernameNotFoundException(this.messages.getMessage("JdbcDaoImpl.noAuthority", new Object[]{username}, "User {0} has no GrantedAuthority"));
            } else {
                user.setAuthorities(dbAuths);
                return user;
            }
        }
    }

    protected List<UserDetails> loadUsersByUsername(String username) {
        String[] args = (this.usersByUsernameQuery+"").split("\\?");
        for (int i = 0; i < args.length; i++) {
            args[i] = username;
        }
        return this.getJdbcTemplate().query(this.usersByUsernameQuery, args, new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String userid = rs.getString(3);
                return buildCustomUserDetails(username,password,userid,null);
            }
        });
    }

    protected List<GrantedAuthority> loadUserAuthorities(String userId) {
        return this.getJdbcTemplate().query(this.authoritiesByUsernameQuery, new String[]{userId}, new RowMapper<GrantedAuthority>() {
            public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                String roleName = getRolePrefix() + rs.getString(2);
                return new SimpleGrantedAuthority(roleName);
            }
        });
    }
    public List<Permission> loadUserPermission(String userId){
        return this.getJdbcTemplate().query("", new String[]{userId}, new RowMapper<Permission>() {
            @Override
            public Permission mapRow(ResultSet resultSet, int i) throws SQLException {
                String id = resultSet.getString(1);
                String permission = resultSet.getString(2);
                String description = resultSet.getString(3);
                Permission permit  = new Permission();
                permit.setId(id);
                permit.setPermission(permission);
                permit.setDescription(description);
                return permit;
            }
        });
    }

    protected List<GrantedAuthority> loadGroupAuthorities(String userId) {
        return this.getJdbcTemplate().query(this.groupAuthoritiesByUsernameQuery, new String[]{userId}, new RowMapper<GrantedAuthority>() {
            public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                String roleName = getRolePrefix() + rs.getString(3);
                return new SimpleGrantedAuthority(roleName);
            }
        });
    }


    public void setAuthoritiesByUsernameQuery(String queryString) {
        this.authoritiesByUsernameQuery = queryString;
    }

    protected String getAuthoritiesByUsernameQuery() {
        return this.authoritiesByUsernameQuery;
    }

    public void setGroupAuthoritiesByUsernameQuery(String queryString) {
        this.groupAuthoritiesByUsernameQuery = queryString;
    }

    public void setRolePrefix(String rolePrefix) {
        this.rolePrefix = rolePrefix;
    }

    protected String getRolePrefix() {
        return this.rolePrefix;
    }

    public void setUsernameBasedPrimaryKey(boolean usernameBasedPrimaryKey) {
        this.usernameBasedPrimaryKey = usernameBasedPrimaryKey;
    }

    protected boolean isUsernameBasedPrimaryKey() {
        return this.usernameBasedPrimaryKey;
    }

    public void setUsersByUsernameQuery(String usersByUsernameQueryString) {
        this.usersByUsernameQuery = usersByUsernameQueryString;
    }

    protected boolean getEnableAuthorities() {
        return this.enableAuthorities;
    }

    public void setEnableAuthorities(boolean enableAuthorities) {
        this.enableAuthorities = enableAuthorities;
    }

    protected boolean getEnableGroups() {
        return this.enableGroups;
    }

    public void setEnableGroups(boolean enableGroups) {
        this.enableGroups = enableGroups;
    }

    public void setMessageSource(MessageSource messageSource) {
        Assert.notNull(messageSource, "messageSource cannot be null");
        this.messages = new MessageSourceAccessor(messageSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }

    private CustomUserDetails buildCustomUserDetails(String username, String password, String userId,Collection<? extends GrantedAuthority> authorities) {
        CustomUserDetails customUserDetails = new CustomUserDetails.CustomUserDetailsBuilder()
                .withUserId(userId)
                .withPassword(password)
                .withUsername(username)
                .withAuthorities(authorities)
                .build();
        return customUserDetails;
    }
}
