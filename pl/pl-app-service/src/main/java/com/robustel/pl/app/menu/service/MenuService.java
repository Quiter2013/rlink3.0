package com.robustel.pl.app.menu.service;

import java.util.List;

import com.robustel.pl.app.menu.entity.AppMenu;
import com.robustel.pl.app.menu.vo.MenuFunVo;

/**
 * @Desc 方法间调用的菜单服务方法
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-28
 */
public interface MenuService {

    /**
     * 获取某应用下的所有菜单
     * @param appId
     * @return
     */
    List<AppMenu> queryMenu2App(String appId);

    /**
     * 获取当前登录人可访问的菜单列表
     * 
     * @param userId
     * @param appId
     * @return
     */
    List<MenuFunVo> queryMenu2Loginer(String userId, String appId);
}
