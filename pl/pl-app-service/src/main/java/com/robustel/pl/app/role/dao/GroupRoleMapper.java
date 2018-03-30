package com.robustel.pl.app.role.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.group.vo.GroupRoleVo;
import com.robustel.pl.app.role.entity.GroupRole;

/**
 * @Desc 组角色实体操作类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
public interface GroupRoleMapper {
    /**
     * 根据主键删除记录
     * 
     * @param groupRoleId
     * @return
     */
    int deleteByPrimaryKey(String groupRoleId);

    /**
     * 新增记录（全字段）
     * 
     * @param record
     * @return
     */
    int insert(GroupRole record);

    /**
     * 新增记录（可选字段）
     * 
     * @param record
     * @return
     */
    int insertSelective(GroupRole record);

    /**
     * 根据主键查询记录
     * 
     * @param groupRoleId
     * @return
     */
    GroupRole selectByPrimaryKey(String groupRoleId);

    /**
     * 根据主键更新记录（可选字段）
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(GroupRole record);

    /**
     * 根据主键更新记录（全字段）
     * 
     * @param record
     * @return
     */
    int updateByPrimaryKey(GroupRole record);

    /**
     * 根据组ID获取旗下所有角色列表[带角色信息查询]
     * 
     * @param groupId
     * @param roleName
     * @return
     */
    List<GroupRoleVo> getRolesByGroupId(@Param("groupId") String groupId, @Param("roleName") String roleName);

    /**
     * 根据组ID获取该组可以分配的角色列表
     * @param groupId
     * @return
     */
    List<GroupRoleVo> getRolesNotInGroup(@Param("groupId") String groupId, @Param("appId") String appId);

    /**
     * 根据角色ID获取该角色的所有分组列表
     * 
     * @param roleId
     * @return
     */
    List<Map<String, Object>> getGroupsByRoleId(@Param("roleId") String roleId, @Param("groupName") String groupName);
}