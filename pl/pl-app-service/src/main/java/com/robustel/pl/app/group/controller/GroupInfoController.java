package com.robustel.pl.app.group.controller;

import com.robustel.common.web.controller.BaseController;
import com.robustel.pl.app.group.entity.GroupInfo;
import com.robustel.pl.app.group.facade.GroupInfoFacade;
import com.robustel.pl.app.group.service.GroupInfoService;

import java.util.List;

/**
 * @Desc 组业务实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-27
 */
public class GroupInfoController extends BaseController<GroupInfoService,GroupInfo> implements GroupInfoFacade {

    @Override
    public List<GroupInfo> findRootUsers() {
        return null;
    }
}