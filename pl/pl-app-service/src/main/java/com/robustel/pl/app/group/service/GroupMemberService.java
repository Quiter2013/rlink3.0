package com.robustel.pl.app.group.service;

import java.util.List;

import com.robustel.common.core.service.BaseService;
import com.robustel.pl.app.group.entity.GroupMember;
import com.robustel.pl.app.group.vo.GroupMemberVo;
import com.robustel.pl.app.group.vo.GroupsAndMembersVo;
import com.robustel.pl.app.group.vo.ResponseGroupInfoVo;

/**
 * 方法间调用的业务方法接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-06-15
 */
public interface GroupMemberService extends BaseService<GroupMember> {

    /**
     * 获取某用户在指定根组下的所有组及是否管理员
     * 
     * @param rootGroupId
     * @param userId
     * @return
     */
    List<GroupMemberVo> queryGroups2User(String rootGroupId, String userId);

    /**
     * 获取某用户管理的组、子组及组员列表
     * 
     * @param userId
     * @return
     */
    List<GroupsAndMembersVo> queryUserManageGroupAndMembers(String userId);

    /**
     * 根据用户ID获取用户所在的所有根组列表
     * 
     * @param userId
     * @return
     */
    List<ResponseGroupInfoVo> queryRootGroupsByUserId(String userId);
}
