package com.robustel.auth.security.userdetails;

import com.robustel.auth.common.entity.Permission;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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
    private String authoritiesByUseridQuery = "select t2.user_name,t4.authorities from tbs_pl_user_role t1,tbs_pl_user_base_info t2,tbs_pl_role_fun t3,tbs_pl_fun_info t4\n" +
            "where t2.user_id=:userid and t1.user_id=t2.user_id and t3.role_id=t1.role_id and t3.fun_id=t4.fun_id ";
    private String groupAuthoritiesByUseridQuery = "select g.id, g.group_name, ga.authority from groups g, group_members gm, group_authorities ga where gm.userid =:userid and g.id = ga.group_id and g.id = gm.group_id";
    private String usersByUsernameQuery = "select user_name,login_pwd,user_id from tbs_pl_user_base_info where state in ('1','3') and (login_account=:username or email=:username)";
    private String rolePrefix = "";
    private boolean usernameBasedPrimaryKey = true;
    private boolean enableAuthorities = true;
    private boolean enableGroups;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    protected MessageSourceAccessor getMessages() {
        return this.messages;
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
        Map<String,Object> args = new HashMap<>();
        args.put("username",username);
        return namedParameterJdbcTemplate.query(this.usersByUsernameQuery, args,new RowMapper<UserDetails>() {
            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String userid = rs.getString(3);
                return buildCustomUserDetails(username,password,userid,null);
            }
        });
    }

    protected List<GrantedAuthority> loadUserAuthorities(String userid) {
        Map<String,Object> params = new HashMap<>();
        params.put("userid",userid);
        return namedParameterJdbcTemplate.query(this.authoritiesByUseridQuery, params, new RowMapper<GrantedAuthority>() {
            public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                String roleName = getRolePrefix() + rs.getString(2);
                return new SimpleGrantedAuthority(roleName);
            }
        });
    }
    public List<Permission> loadUserPermission(String userid){
        List<GrantedAuthority> authorities = loadUserAuthorities(userid);
        Set<Permission> permSet = new HashSet<Permission>();
        for(GrantedAuthority authority : authorities){
            String perms = authority.getAuthority();
            if(StringUtils.isEmpty(perms)) continue;
            String[] permArray = perms.split(",");
            for (String perm : permArray) {
                Permission permission = new Permission();
                permission.setPermission(perm);
                permSet.add(permission);
            }
        }
        return new ArrayList<>(permSet);

    }

    protected List<GrantedAuthority> loadGroupAuthorities(String userid) {
        Map<String,Object> params = new HashMap<>();
        params.put("userid",userid);
        return namedParameterJdbcTemplate.query(this.groupAuthoritiesByUseridQuery, params, new RowMapper<GrantedAuthority>() {
            public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                String roleName = getRolePrefix() + rs.getString(3);
                return new SimpleGrantedAuthority(roleName);
            }
        });
    }


    public void setAuthoritiesByUseridQuery(String queryString) {
        this.authoritiesByUseridQuery = queryString;
    }

    protected String getAuthoritiesByUseridQuery() {
        return this.authoritiesByUseridQuery;
    }

    public void setGroupAuthoritiesByUseridQuery(String queryString) {
        this.groupAuthoritiesByUseridQuery = queryString;
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
