package com.robustel.pl.app.user.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleVo implements Serializable{
    /** 用户角色ID */
    private String userRoleId;

    /** 用户ID */
    private String userId;

    /** 角色ID */
    private String roleId;

    /** 关联时间 */
    private Long operateTime;

    /** 关联人ID */
    private String operaterId;

    /** 关联人名称 */
    private String operaterName;

    /** 应用ID */
    private String appId;

    /** 应用名 */
    private String appName;

    /** 角色名称 */
    private String roleName;

    /** 角色名称多语言Code */
    private String roleNameKeyCode;

    /** 角色描述 */
    private String roleDesc;

    /** 角色描述多语言Code */
    private String roleDescKeyCode;
}
