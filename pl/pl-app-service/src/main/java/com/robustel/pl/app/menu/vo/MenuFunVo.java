package com.robustel.pl.app.menu.vo;

import com.robustel.pl.app.menu.entity.AppMenu;
import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 权限分配时菜单功能展示类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-28
 */
@Data
public class MenuFunVo implements Serializable {
    /** 功能ID */
    private String funId;

    /** 功能模块ID */
    private String modelId;

    /** 功能名称 */
    private String funName;

    /** 功能代码 */
    private String funCode;

    /** 执行函数 */
    private String executeMethod;

    /** 参数 */
    private String param;

    /** 多语言KEY */
    private String keyCode;

    /** 扩展字段1 */
    private String extend1;

    /** 扩展字段2 */
    private String extend2;

    /** 备注 */
    private String remark;

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 请求方式:1POST,2GET,3PUT，默认为1
     */
    private Character requestType;

    /**
     * 是否验证登录: 0否,1是，默认为1
     */
    private Character isValidLogin;

    /**
     * 菜单ID
     */
    private String menuId;

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

    /** 展开时图片 */
    private String expandIcon;

    /** 收拢时图片 */
    private String foldIcon;

    public AppMenu menuFunVo2Entity() {
        AppMenu menu = new AppMenu();
        menu.setMenuId(menuId);
        menu.setMenuCode(menuCode);
        menu.setMenuDesc(menuDesc);
        menu.setMenuName(menuName);
        menu.setMenuType(menuType);
        menu.setMenuNameLanguageKey(menuNameLanguageKey);
        menu.setExpandIcon(expandIcon);
        menu.setFoldIcon(foldIcon);
        menu.setLoadParam(loadParam);
        menu.setLoadRes(loadRes);
        menu.setParentId(parentId);
        return menu;
    }
}
