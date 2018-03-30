package com.robustel.pl.app.menu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.menu.entity.AppMenu;
import com.robustel.pl.app.menu.vo.AppMenuVo;

/**
 * @Desc 菜单表操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
public interface AppMenuMapper {
    /**
     * 根据主键删除记录
     * @param menuId 菜单ID
     * @return
     */
    int deleteByPrimaryKey(String menuId);

    /**
     * 新增记录（全字段）
     * @param record
     * @return
     */
    int insert(AppMenu record);

    /**
     * 批量插入
     * @param menus
     * @return
     */
    long batchInsert(@Param("menus") List<AppMenu> menus);

    /**
     * 新增记录（可选字段）
     * @param record
     * @return
     */
    int insertSelective(AppMenu record);

    /**
     * 根据主键获取记录
     * @param menuId
     * @return
     */
    AppMenu selectByPrimaryKey(String menuId);

    /**
     * 更新记录（可选字段）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AppMenu record);

    /**
     * 更新记录（全部字段）
     * @param record
     * @return
     */
    int updateByPrimaryKey(AppMenu record);

    /**
     * 查询某应用的指定父菜单下菜单列表
     * 注：不会加载没有启用的菜单
     * [采用懒加载方式提高系统响应速度，从而提高用户体验度]
     * 
     * @param appId 应用ID
     * @param parentId 父菜单（如果没有父菜单，则parentId为0）
     * @return
     */
    List<AppMenu> queryMenuList2App(@Param("appId") String appId, @Param("parentId") String parentId);

    /**
     * 此方法面向菜单管理列表，提供模糊查询、精确查询等
     * 注：默认加载所有菜单
     * 
     * @param menu
     * @return
     */
    List<AppMenu> queryMenuList2MenuManage(AppMenuVo menu);

    /**
     * 获取某用户在指定根组下的所有权限菜单
     * 
     * @param userId
     * @param rootGroupId
     * @return
     */
    List<AppMenu> queryMenuList2Loginer(@Param("userId") String userId, @Param("rootGroupId") String rootGroupId);
}