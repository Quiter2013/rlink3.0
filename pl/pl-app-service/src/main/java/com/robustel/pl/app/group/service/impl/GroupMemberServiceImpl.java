package com.robustel.pl.app.group.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.pl.app.group.entity.GroupMember;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustel.pl.app.group.dao.GroupInfoMapper;
import com.robustel.pl.app.group.dao.GroupMemberMapper;
import com.robustel.pl.app.group.service.GroupMemberService;
import com.robustel.pl.app.group.vo.GroupInfoDatagridVo;
import com.robustel.pl.app.group.vo.GroupMemberVo;
import com.robustel.pl.app.group.vo.GroupsAndMembersVo;
import com.robustel.pl.app.group.vo.ResponseGroupInfoVo;
import com.robustel.pl.app.user.vo.PlUserVo;

/**
 * 方法间调用的业务方法接口的实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-06-15
 */
@Service
public class GroupMemberServiceImpl extends BaseServiceImpl<GroupMemberMapper,GroupMember> implements GroupMemberService {

    @Autowired
    private GroupInfoMapper groupInfoMapper;

    @Override
    public List<GroupMemberVo> queryGroups2User(String rootGroupId, String userId) {
        List<GroupMemberVo> results = new ArrayList<GroupMemberVo>();
        List<GroupMemberVo> gms = mapper.queryGroups2User(rootGroupId, userId);
        if (gms != null) {
            for (GroupMemberVo gm : gms) {
                boolean isAdmin = false;
                if (StringUtils.equals(gm.getUserId(), gm.getSuperAdminId())) {
                    isAdmin = true;
                }
                gm.setAdmin(isAdmin);
                results.add(gm);
            }
        }
        return results;
    }

    @Override
    public List<GroupsAndMembersVo> queryUserManageGroupAndMembers(String userId) {
        List<GroupsAndMembersVo> datas = new ArrayList<GroupsAndMembersVo>();
        // 获取用户能管理的组列表
        List<GroupInfoDatagridVo> groups = groupInfoMapper.queryManagerGroupInfo(userId);
        for (GroupInfoDatagridVo gi : groups) {
            // 获取该组的组员列表
            String groupId = gi.getGroupId();
            List<PlUserVo> nodes = mapper.queryMembersByGroupId(groupId);
            GroupsAndMembersVo gamv = new GroupsAndMembersVo();
            gamv.setGroupInfo(gi);
            gamv.setNodes(nodes);
            datas.add(gamv);
        }
        return datas;
    }

    @Override
    public List<ResponseGroupInfoVo> queryRootGroupsByUserId(String userId) {
        List<ResponseGroupInfoVo> list = null;
        if (StringUtils.isNotBlank(userId)) {
            list = mapper.queryRootGroupsByUserId(userId);
        }
        return list;
    }

}
