package com.robustel.pl.app.role.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 角色功能实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
@Data
@Table(name = "tbs_pl_role_fun")
public class RoleFun implements Serializable{
    /** 角色权限ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String rfId;

    /** 角色ID */
    private String roleId;

    /** 应用功能ID */
    private String funId;

    /** 数据权限Id */
    private String dataPrivilegeId;

    /** 关联时间 */
    private Long createTime;

    /** 创建人ID */
    private String createrId;

    /** 创建人 */
    private String creater;

    /** 修改时间 */
    private Long updateTime;

    /** 修改人 */
    private String updater;
}