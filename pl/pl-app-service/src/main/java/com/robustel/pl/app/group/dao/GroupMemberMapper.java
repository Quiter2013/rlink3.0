package com.robustel.pl.app.group.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.group.entity.GroupMember;
import com.robustel.pl.app.group.vo.GroupMemberVo;
import com.robustel.pl.app.group.vo.ResponseGroupInfoVo;
import com.robustel.pl.app.user.vo.PlUserVo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 组成员操作接口类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-27
 */
public interface GroupMemberMapper extends Mapper<GroupMember> {
    /**
     * 在某个组内，删除指定用户
     * @param keys 主键数组
     * @return
     */
    int deleteByKeys(@Param("keys") String[] keys);

    /**
     * 删除指定组的所有成员
     * @param groupId
     * @return
     */
    int deleteByGroupId(String groupId);



    /**
     * 查询某个组内的所有人员
     * @param groupId 必填
     * @param keyword 模糊查询的值
     * @return
     */
    List<GroupMemberVo> queryUsersInGroup(@Param("groupId") String groupId, @Param("keyword") String keyword);

    /**
     * 查询某个应用下,不在某个组内的所有人员（MYSQL差运算）
     * @param appId 应用ID 
     * @param groupId 组ID
     * @return
     */
    List<PlUserVo> queryUsersNotInGroup(@Param("appId") String appId, @Param("groupId") String groupId);

    /**
     * 查询某个应用下,在根组内不在某个组内的所有人员（MYSQL差运算）
     * 
     * @param appId 应用ID 
     * @param groupId 组ID
     * @param rootGroupId 根组
     * @return
     */
    List<PlUserVo> queryUsersInRootGroupNotInGroup(@Param("appId") String appId, @Param("groupId") String groupId,
                                                   @Param("rootGroupId") String rootGroupId);

    /**
     * 查询某用户在指定应用下的所有根组列表
     * @param params userId、appId不能为空
     * @return
     */
    List<ResponseGroupInfoVo> queryRootGroupByUserAndAppId(Map<String, Object> params);

    /**
     * 获取某用户所在的组列表
     * @param userId
     * @return
     */
    List<ResponseGroupInfoVo> queryGroupVo2User(@Param("userId") String userId);

    /**
     * 获取某个分组的组员列表
     * @param groupId
     * @return
     */
    List<PlUserVo> queryMembersByGroupId(@Param("groupId") String groupId);

    /**
     * 根据组ID、用户ID获取组和用户关联关系
     * 
     * @param groupId
     * @param userId
     * @return
     */
    GroupMember selectByGroupIdAndUserId(@Param("groupId") String groupId, @Param("userId") String userId);

    /**
     * 获取某用户在指定根组下的所有组及管理员ID
     * 
     * @param rootGroupId
     * @param userId
     * @return
     */
    List<GroupMemberVo> queryGroups2User(@Param("rootGroupId") String rootGroupId, @Param("userId") String userId);

    /**
     * 取消用户userId关联的组织信息
     * 
     * @param userId
     */
    void deleteByUserId(@Param("userId") String userId);

    /**
     * 根据用户ID获取用户所在的所有根组列表
     * 
     * @param userId
     * @return
     */
    List<ResponseGroupInfoVo> queryRootGroupsByUserId(String userId);
}