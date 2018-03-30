package com.robustel.pl.app.role.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Desc 角色菜单实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
@Data
@Table(name = "tbs_pl_role_menu")
public class RoleMenu {
    /** 角色菜单ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String roleMenuId;

    /** 角色ID */
    private String roleId;

    /** 菜单ID */
    private String menuId;

    /** 关联时间 */
    private Long createTime;

    /** 关联人ID */
    private String createrId;

    /** 关联人名称 */
    private String createrName;

    /** 更新人ID */
    private String updaterId;

    /** 更新人名称 */
    private String updaterName;

    /** 更新时间 */
    private Long updateTime;
}