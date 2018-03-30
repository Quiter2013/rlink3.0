package com.robustel.pl.app.role.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 组角色实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
@Data
@Table(name = "tbs_pl_group_role")
public class GroupRole implements Serializable{
    /** 组角色ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String groupRoleId;

    /** 组ID */
    private String groupId;

    /** 角色ID */
    private String roleId;

    /** 关联时间 */
    private Long createTime;

    /** 操作人 */
    private String createrId;

    /** 操作人名称 */
    private String createrName;

    /** 修改时间 */
    private Long updateTime;

    /** 修改人 */
    private String updater;
}