package com.robustel.pl.app.menu.vo;

import com.robustel.pl.app.menu.entity.AppMenu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuAndFunListResVo implements Serializable{
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

    /** 菜单及其功能列表 */
    private List<MenuFunVo> funList;

    public MenuAndFunListResVo() {

    }

    public MenuAndFunListResVo(AppMenu menu) {
        this.appId = menu.getAppId();
        this.menuId = menu.getMenuId();
        this.menuName = menu.getMenuName();
        this.menuNameLanguageKey = menu.getMenuNameLanguageKey();
        this.menuType = menu.getMenuType();
        this.menuCode = menu.getMenuCode();
        this.menuDesc = menu.getMenuDesc();
        this.creater = menu.getCreater();
        this.createrId = menu.getCreaterId();
        this.createTime = menu.getCreateTime();
        this.expandIcon = menu.getExpandIcon();
        this.foldIcon = menu.getFoldIcon();
        this.loadParam = menu.getLoadParam();
        this.loadRes = menu.getLoadRes();
        this.openCloseState = menu.getOpenCloseState();
        this.parentId = menu.getParentId();
        this.showOrder = menu.getShowOrder();
        this.showWay = menu.getShowWay();
    }
}
