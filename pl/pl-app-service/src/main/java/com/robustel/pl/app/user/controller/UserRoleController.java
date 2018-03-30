package com.robustel.pl.app.user.controller;

import com.robustel.common.web.controller.BaseController;
import com.robustel.pl.app.user.entity.UserRole;
import com.robustel.pl.app.user.service.UserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc 用户角色服务接口实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-29
 */
@RestController
@RequestMapping("/userRole")
public class UserRoleController extends BaseController<UserRoleService,UserRole> {
    /**
     * 代理商系统角色创建人ID
     */
    private static final String AGENT_CREATER_ID = "Agent";
    /**
     * 终端客户系统角色创建人ID
     */
    private static final String CLIENT_CREATER_ID = "Client";


}
