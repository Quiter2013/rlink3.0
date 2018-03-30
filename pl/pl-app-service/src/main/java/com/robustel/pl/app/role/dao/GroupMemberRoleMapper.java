package com.robustel.pl.app.role.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.role.entity.GroupMemberRole;

/**
 * @Desc 组成员角色实体操作类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
public interface GroupMemberRoleMapper {
	/**
	 * 根据主键删除记录
	 * 
	 * @param memberRoleId
	 * @return
	 */
	int deleteByPrimaryKey(String memberRoleId);

	/**
	 * 新增记录（全字段）
	 * 
	 * @param record
	 * @return
	 */
	int insert(GroupMemberRole record);

	/**
	 * 新增记录（可选字段）
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(GroupMemberRole record);

	/**
	 * 根据主键查询记录
	 * 
	 * @param memberRoleId
	 * @return
	 */
	GroupMemberRole selectByPrimaryKey(String memberRoleId);

	/**
	 * 根据主键更新记录（可选字段）
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(GroupMemberRole record);

	/**
	 * 根据主键更新记录（全字段）
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(GroupMemberRole record);
	
	/**
	 * 获取某角色ID的用户列表
	 * 
	 * @param roleId
	 * @param userName
	 * @return
	 */
	List<Map<String, Object>> getMembersByRoleId(@Param("roleId") String roleId,
                                                 @Param("userName") String userName);
}