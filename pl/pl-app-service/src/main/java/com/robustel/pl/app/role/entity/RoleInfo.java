package com.robustel.pl.app.role.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 角色实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
@Data
@Table(name = "tbs_pl_role_info")
public class RoleInfo implements Serializable {
    /** 角色ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String roleId;

    /** 角色名称 */
    private String roleName;

    /** 角色名称多语言Code */
    private String roleNameKeyCode;

    /** 角色描述 */
    private String roleDesc;

    /** 角色描述多语言Code */
    private String roleDescKeyCode;

    /** 范围类型: 0用户,1组 */
    private String scopeType;

    /** 应用ID */
    private String appId;

    /** 所属组织ID */
    private String belongOrdId;

    /** 创建人ID */
    private String createrId;

    /** 创建人 */
    private String creater;

    /** 创建时间 */
    private Long createTime;

    /** 修改时间 */
    private Long updateTime;

    /** 修改人 */
    private String updater;
}