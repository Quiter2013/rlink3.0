package com.robustel.pl.app.group.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.group.entity.GroupInfo;
import com.robustel.pl.app.group.vo.ClientVo;
import com.robustel.pl.app.group.vo.GroupInfoDatagridVo;
import com.robustel.pl.app.group.vo.ReqGroupInfoVo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 组信息实体操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-27
 */
public interface GroupInfoMapper extends Mapper<GroupInfo> {
    /**
     * 根据主键删除记录
     * @param groupId 组ID
     * @return
     */
    int deleteByPrimaryKey(String groupId);

    /**
     * 新增记录（全字段）
     * @param record
     * @return
     */
    int insert(GroupInfo record);

    /**
     * 新增记录（可选字段）
     * @param record
     * @return
     */
    int insertSelective(GroupInfo record);

    /**
     * 根据主键获取记录
     * @param menuId
     * @return
     */
    GroupInfo selectByPrimaryKey(String groupId);

    /**
     * 更新记录（可选字段）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(GroupInfo record);

    /**
     * 更新记录（全部字段）
     * @param record
     * @return
     */
    int updateByPrimaryKey(GroupInfo record);

    /**
     * 删除GROUP_FULL_ID字段中含有指定组ID的组，即：删除某组下的子组和孙子组
     * @param groupId
     * @return
     */
    int deleteByGroupFullId(String groupId);

    /**
     * 获取条件查询的组列表(用于datagrid)
     * @param ReqGroupInfoVo record
     * @return
     */
    List<GroupInfoDatagridVo> queryList2GroupManage(ReqGroupInfoVo record);

    /**
     * 获取某应用的根组列表信息<br>
     * @param appId 
     * @return
     */
    List<GroupInfoDatagridVo> queryRootGroupList(@Param("appId") String appId);

    /**
     * 获取某根组的所有分组信息(包括根组)
     * @param rootGroupId 根组ID
     * @return
     */
    List<GroupInfoDatagridVo> queryGroupTreeDataByRootGroupId(@Param("rootGroupId") String rootGroupId);

    /**
     * 获取某根组下的所有分组列表（包含根组）
     * 
     * @param rootGroupId 根组ID
     * @param keyword 关键字查询
     * @return
     */
    List<GroupInfoDatagridVo> qeuryGroups2Loginer(@Param("rootGroupId") String rootGroupId,
                                                  @Param("keyword") String keyword);

    /**
     * 获取某邀请对象添加的客户信息
     * 
     * @param objectId
     * @return
     */
    GroupInfo selectByCreaterId(@Param("objectId") String objectId);

    /**
     * 获取当前登录人在某应用下归属的组织列表
     * @param userId
     * @param appId
     * @return
     */
    List<GroupInfoDatagridVo> queryCurrentUserGroupInfo(@Param("userId") String userId, @Param("appId") String appId);

    /**
     * 获取终端客户列表
     * @param record
     * @return
     */
    List<ClientVo> queryClientList(ReqGroupInfoVo record);

    /**
     * 判断组名是否存在
     * @param groupName 不能为空
     * @param groupId 可以为空（修改时的判断不能为空）
     * @return
     */
    GroupInfo judgeExistsByGroupNameAndGroupId(@Param("groupName") String groupName, @Param("groupId") String groupId);

    /**
     * 判断组名是否存在，用于验证唯一性，如果不存在，返回0
     * @param groupName
     * @return
     */
    int validateUnique(@Param("groupName") String groupName);

    /**
     * 获取用户管理的组及其子组列表
     * 
     * @param userId
     * @return
     */
    List<GroupInfoDatagridVo> queryManagerGroupInfo(@Param("userId") String userId);

	List<GroupInfo> findRootUsers();
}