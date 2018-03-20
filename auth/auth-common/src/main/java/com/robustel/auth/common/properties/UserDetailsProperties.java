package com.robustel.auth.common.properties;

import lombok.Data;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 16:12 2018/3/19
 * Modified By:
 */
@Data
public class UserDetailsProperties {
    private String rolesByUseridQuery = "select distinct r.role_name_key_code from tbs_pl_user_role ur,tbs_pl_role_info r where ur.user_id=:userid and ur.ROLE_ID=r.ROLE_ID and r.role_name_key_code is not null";
    private String groupRolesByUseridQuery = "select distinct ga.authority from groups g, group_members gm, group_authorities ga where gm.userid =:userid and g.id = ga.group_id and g.id = gm.group_id";
    private String usersByUsernameQuery = "select user_name,login_pwd,user_id from tbs_pl_user_base_info where state in ('1','3') and (login_account=:username or email=:username)";
    private String authoritiesByUseridQuery = "select distinct f.authorities from tbs_pl_user_role ur,tbs_pl_role_fun rf,tbs_pl_fun_info f where ur.user_id=:userid and ur.role_id=rf.role_id and rf.fun_id=f.fun_id and f.authorities is not null";
    private String rolePrefix = "ROLE_";
    private boolean enableAuthorities = true;
    private boolean enableGroups = false;
}
