package com.robustel.pl.app.menu.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 菜单实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
@Data
@Table(name = "tbs_pl_app_menu")
public class AppMenu implements Serializable{
    /** 菜单ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String menuId;

    /** 应用ID */
    private String appId;

    /** 菜单名称 */
    private String menuName;

    /**
     * 菜单名称多语言Key
     */
    private String menuNameLanguageKey;

    /** 菜单代码 */
    private String menuCode;

    /** 菜单类型：0功能菜单,1模块菜单 */
    private String menuType;

    /** 菜单描述 */
    private String menuDesc;

    /** 加载资源 */
    private String loadRes;

    /** 加载参数 */
    private String loadParam;

    /** 展现方式 */
    private String showWay;

    /** 显示排序 */
    private Integer showOrder;

    /** 上级菜单 */
    private String parentId;

    /** 默认0,0收拢,1展开 */
    private String openCloseState;

    /** 展开时图片 */
    private String expandIcon;

    /** 收拢时图片 */
    private String foldIcon;

    /** 创建时间 */
    private long createTime;

    /** 创建人名称 */
    private String creater;

    /** 创建人ID */
    private String createrId;
}