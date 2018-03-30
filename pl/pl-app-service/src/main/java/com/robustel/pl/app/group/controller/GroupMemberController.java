package com.robustel.pl.app.group.controller;

import com.robustel.common.web.controller.BaseController;
import com.robustel.pl.app.group.entity.GroupMember;
import com.robustel.pl.app.group.facade.GroupMemberFacade;
import com.robustel.pl.app.group.service.GroupMemberService;
import com.robustel.pl.app.group.vo.GroupMemberParam;
import com.robustel.pl.app.group.vo.GroupMemberVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desc 组员业务实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
@Api(tags = {"组织成员管理"})
@RestController
@RequestMapping("/groupMember")
public class GroupMemberController extends BaseController<GroupMemberService,GroupMember>implements GroupMemberFacade {

    @Override
    public List<GroupMember> queryUserListByCompanyId(String companyId) {
        return null;
    }

    @Override
    public List<GroupMemberVo> queryGroups2User2(GroupMemberParam vo) {
        return null;
    }
}
