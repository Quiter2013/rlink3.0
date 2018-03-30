package com.robustel.pl.app.group.vo;

import lombok.Data;

/**
 * @Desc 组角色展示VO
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-09
 */
@Data
public class GroupRoleVo{
    /** 组角色ID */
    private String groupRoleId;

    /** 组ID */
    private String groupId;

    /** 角色ID */
    private String roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色描述 */
    private String roleDesc;
}
