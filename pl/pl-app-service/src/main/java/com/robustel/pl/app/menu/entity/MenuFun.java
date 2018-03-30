package com.robustel.pl.app.menu.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 菜单功能实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-27
 */
@Data
@Table(name = "tbs_pl_menu_fun")
public class MenuFun  implements Serializable{
    /** 菜单功能ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String menuFunId;

    /** 菜单ID */
    private String menuId;

    /** 系统功能ID */
    private String funId;

    /** 关联时间 */
    private Long createTime;

    /** 操作人 */
    private String createrId;
}