package com.robustel.pl.app.role.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.role.entity.RoleMenu;

/**
 * @Desc 角色菜单实体操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
public interface RoleMenuMapper {
    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);
    
    int deleteByPrimaryKey(String roleMenuId);
    
    RoleMenu selectByPrimaryKey(String roleMenuId);
    
    int updateByPrimaryKeySelective(RoleMenu record);
    
    int updateByPrimaryKey(RoleMenu record);;
    
    /**
     * 根据用户ID和根组ID查找权限下的所有菜单
     * 
     * @param userId 用户ID不能为空
     * @param rootGroupId 根组ID不能为空
     * @return
     */
    List<Map<String, Object>> getMenuListByUserIdAndRootGroupId(@Param("userId") String userId,
                                                                @Param("rootGroupId") String rootGroupId);
    
    /**
     * 获取某角色的菜单列表
     * 
     * @param roleId 角色ID 不能为空
     * @param menuName 菜单名称[用于模糊查询]
     * @return
     */
    List<Map<String, Object>> getMenusByRoleId(@Param("roleId") String roleId,
                                               @Param("menuName") String menuName);
}