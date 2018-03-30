package com.robustel.pl.app.menu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.menu.entity.MenuFun;
import com.robustel.pl.app.menu.vo.MenuFunVo;

/**
 * @Desc 菜单功能实体操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-27
 */
public interface MenuFunMapper {
    int deleteByPrimaryKey(String menuFunId);

    int insert(MenuFun record);

    int insertSelective(MenuFun record);

    MenuFun selectByPrimaryKey(String menuFunId);

    int updateByPrimaryKeySelective(MenuFun record);

    int updateByPrimaryKey(MenuFun record);

    /**
     * 根据菜单ID获取功能列表
     * @param menuId
     * @param keyword 模糊查询字段，可根据功能名、功能编码模糊查询
     * @return
     */
    List<Map<String, Object>> queryFunByMenuId(@Param("menuId") String menuId, @Param("keyword") String keyword);

    /**
     * 根据应用ID获取菜单挂载的功能列表
     * @param appId 应用ID
     * @return
     */
    List<MenuFunVo> queryFunByAppId(@Param("appId") String appId);

    /**
     * 将功能挂载到菜单
     * @param records
     * @return
     */
    int mount(@Param("records") List<MenuFun> records);

    /**
     * 获取某用户在某应用下可访问的菜单
     * 
     * @param userId
     * @param appId
     * @return
     */
    List<MenuFunVo> queryMenu2User(@Param("userId") String userId, @Param("appId") String appId);

    /**
     * 根据菜单ID删除已挂载的功能列表
     * @param menuId
     * @return
     */
    int delFunsByMenuId(@Param("menuId") String menuId);

    /**
     * 获取某用户在应用下分配到的功能列表（及其挂载的菜单ID）
     * 
     * @param userId
     * @param appId
     * @return
     */
    List<MenuFunVo> queryFuns2User(@Param("userId") String userId, @Param("appId") String appId);
}