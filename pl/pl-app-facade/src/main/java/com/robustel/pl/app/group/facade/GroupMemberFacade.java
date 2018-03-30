package com.robustel.pl.app.group.facade;

import com.robustel.pl.app.group.entity.GroupMember;
import com.robustel.pl.app.group.vo.GroupMemberParam;
import com.robustel.pl.app.group.vo.GroupMemberVo;

import java.util.List;

/**
 * @Desc 组员业务操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
public interface GroupMemberFacade {

     List<GroupMember> queryUserListByCompanyId(String companyId);

     List<GroupMemberVo> queryGroups2User2(GroupMemberParam vo);
}
