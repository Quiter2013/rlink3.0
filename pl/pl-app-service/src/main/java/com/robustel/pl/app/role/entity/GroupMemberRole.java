package com.robustel.pl.app.role.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 组成员角色实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
@Data
@Table(name = "tbs_pl_group_member_role")
public class GroupMemberRole implements Serializable{
    /** 组员角色ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String memberRoleId;

    /** 角色ID */
    private String roleId;

    /** 主键，不参与业务 */
    private String memberId;

    /** 关联时间 */
    private Long createTime;

    /** 创建人ID */
    private String createrId;

    /** 创建人名称 */
    private String createrName;

    /** 修改时间 */
    private Long updateTime;

    /** 修改人 */
    private String updater;
}