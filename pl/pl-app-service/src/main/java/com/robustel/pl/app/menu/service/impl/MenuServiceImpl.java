package com.robustel.pl.app.menu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustel.pl.app.menu.dao.AppMenuMapper;
import com.robustel.pl.app.menu.dao.MenuFunMapper;
import com.robustel.pl.app.menu.entity.AppMenu;
import com.robustel.pl.app.menu.service.MenuService;
import com.robustel.pl.app.menu.vo.MenuFunVo;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
    private Logger logger = Logger.getLogger(MenuServiceImpl.class);
    @Autowired
    AppMenuMapper appMenuMapper;
    @Autowired
    MenuFunMapper menuFunMapper;

    @Override
    public List<AppMenu> queryMenu2App(String appId) {
        List<AppMenu> menuList = new ArrayList<AppMenu>();
        if (StringUtils.isNotBlank(appId)) {
            logger.info(String.format("正在获取应用ID为%s下的所有菜单列表", appId));
            menuList = appMenuMapper.queryMenuList2App(appId, null);
        } else {
            logger.info("appId为空");
        }
        return menuList;
    }

    @Override
    public List<MenuFunVo> queryMenu2Loginer(String userId, String appId) {
        List<MenuFunVo> menus = new ArrayList<MenuFunVo>();
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(appId)) {
            logger.info("获取当前登录人可访问的菜单列表");
            menus = menuFunMapper.queryMenu2User(userId, appId);
        } else {
            logger.info("userId或rootGroupId为空");
        }
        return menus;
    }

}
