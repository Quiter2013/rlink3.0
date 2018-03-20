package com.robustel.auth.security.userdetails;

import com.robustel.auth.security.authority.CustomSimpleGrantedAuthority;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
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
@Data
public class CustomUserDetailsService implements UserDetailsService {
    protected final Log logger = LogFactory.getLog(this.getClass());
    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    private String rolesByUseridQuery = "select distinct r.role_name_key_code from tbs_pl_user_role ur,tbs_pl_role_info r where ur.user_id=:userid and ur.ROLE_ID=r.ROLE_ID and r.role_name_key_code is not null";
    private String groupRolesByUseridQuery = "select distinct ga.authority from groups g, group_members gm, group_authorities ga where gm.userid =:userid and g.id = ga.group_id and g.id = gm.group_id";
    private String usersByUsernameQuery = "select user_name,login_pwd,user_id from tbs_pl_user_base_info where state in ('1','3') and (login_account=:username or email=:username)";
    private String authoritiesByUseridQuery = "select distinct f.authorities from tbs_pl_user_role ur,tbs_pl_role_fun rf,tbs_pl_fun_info f where ur.user_id=:userid and ur.role_id=rf.role_id and rf.fun_id=f.fun_id and f.authorities is not null";

    private String rolePrefix = "ROLE_";
    private boolean enableAuthorities = true;
    private boolean enableGroups;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Cacheable(value="user",key="#username")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetails> users = this.loadUsersByUsername(username);
        if (users.size() == 0) {
            this.logger.debug("Query returned no results for user '" + username + "'");
            throw new UsernameNotFoundException(this.messages.getMessage("JdbcDaoImpl.notFound", new Object[]{username}, "Username {0} not found"));
        } else {
            CustomUserDetails user = (CustomUserDetails)users.get(0);
            Set<GrantedAuthority> dbAuthsSet = new HashSet();
            if (this.enableAuthorities) {
                dbAuthsSet.addAll(this.loadUserRoles(user.getUserId()));
            }

            if (this.enableGroups) {
                dbAuthsSet.addAll(this.loadGroupRoles(user.getUserId()));
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

    protected List<GrantedAuthority> loadUserRoles(String userid) {
        Map<String,Object> params = new HashMap<>();
        params.put("userid",userid);
        return namedParameterJdbcTemplate.query(this.rolesByUseridQuery, params, new RowMapper<GrantedAuthority>() {
            public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                String roleName = getRolePrefix() + rs.getString(1);
                return new CustomSimpleGrantedAuthority(roleName);
            }
        });
    }

    public List<GrantedAuthority> loadUserAuthorities(String userid) {
        Map<String,Object> params = new HashMap<>();
        params.put("userid",userid);
        return namedParameterJdbcTemplate.query(this.authoritiesByUseridQuery, params, new RowMapper<GrantedAuthority>() {
            public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                String authority = rs.getString(1);
                return new CustomSimpleGrantedAuthority(authority);
            }
        });
    }

    protected List<GrantedAuthority> loadGroupRoles(String userid) {
        Map<String,Object> params = new HashMap<>();
        params.put("userid",userid);
        return namedParameterJdbcTemplate.query(this.groupRolesByUseridQuery, params, new RowMapper<GrantedAuthority>() {
            public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
                String roleName = getRolePrefix() + rs.getString(1);
                return new CustomSimpleGrantedAuthority(roleName);
            }
        });
    }

     public void setMessageSource(MessageSource messageSource) {
        Assert.notNull(messageSource, "messageSource cannot be null");
        this.messages = new MessageSourceAccessor(messageSource);
    }

    public boolean isEnableAuthorities() {
        return enableAuthorities;
    }

    public boolean isEnableGroups() {
        return enableGroups;
    }

    public CustomUserDetails buildCustomUserDetails(String username, String password, String userId, Collection<? extends GrantedAuthority> authorities) {
        CustomUserDetails customUserDetails = new CustomUserDetails.CustomUserDetailsBuilder()
                .withUserId(userId)
                .withPassword(password)
                .withUsername(username)
                .withAuthorities(authorities)
                .build();
        return customUserDetails;
    }
}
