package com.robustel.pl.app.menu.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppMenuVo implements Serializable{
    /** 菜单ID */
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

    /** 模糊查询字段，可根据菜单名、菜单编码进行模糊查询 */
    private String keyword;
}
