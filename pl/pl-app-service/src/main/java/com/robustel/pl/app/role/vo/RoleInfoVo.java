package com.robustel.pl.app.role.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleInfoVo implements Serializable {

    /** 角色ID */
    private String roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色描述 */
    private String roleDesc;

    /** 范围类型: 0用户,1组 */
    private String scopeType;

    /** 应用ID */
    private String appId;

    /** 模糊查询字段 */
    private String keyword;

    /** 所属组织ID */
    private String belongOrdId;

    /** 创建人ID */
    private String createrId;
}
