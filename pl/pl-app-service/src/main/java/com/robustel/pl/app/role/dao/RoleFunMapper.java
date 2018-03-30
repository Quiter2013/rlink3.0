package com.robustel.pl.app.role.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.role.entity.RoleFun;
import com.robustel.pl.app.role.vo.RoleFunVo;

/**
 * @Desc 角色功能实体操作类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
public interface RoleFunMapper {
    int deleteByPrimaryKey(String rfId);

    int insert(RoleFun record);

    int insertSelective(RoleFun record);

    RoleFun selectByPrimaryKey(String rfId);

    int updateByPrimaryKeySelective(RoleFun record);

    int updateByPrimaryKey(RoleFun record);

    /**
     * 获取指定角色的功能列表
     * 
     * @param roleId 必填
     * @param funName 可以为空
     * @return
     */
    List<RoleFunVo> getFunsByRoleId(@Param("roleId") String roleId, @Param("funName") String funName);

    /**
     * 获取指定角色在某个菜单下的功能列表
     * 
     * @param roleId 必填
     * @param menuId 必填
     * @return
     */
    List<Map<String, Object>> getFunsByRoleIdAndMenuId(@Param("roleId") String roleId, @Param("menuId") String menuId);

    /**
     * 批量插入
     * 
     * @param list
     * @return
     */
    int batchInsert(List<RoleFun> list);

    /**
     * 根据角色ID删除已分配到的功能列表
     * @param roleId
     * @return
     */
    int delFunListByRoleId(@Param("roleId") String roleId);

    /**
     * 批量删除角色功能
     * 
     * @param rfIds
     * @return
     */
    int batchDelByPrimarykeys(@Param("rfIds") List<String> rfIds);

    /**
     * 批量删除某角色ID集合里面的角色关联
     * @param roleIds
     * @return
     */
    int batchDelByRoleIds(@Param("roleIds") Set<String> roleIds);
}