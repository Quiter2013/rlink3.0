package com.robustel.pl.app.management.controller;

import com.robustel.common.web.controller.BaseController;
import com.robustel.pl.app.management.entity.App;
import com.robustel.pl.app.management.facade.AppMangeFacade;
import com.robustel.pl.app.management.service.AppManageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HanZhijun
 * @version 1.0.0
 * @Desc 业务处理接口实现类
 * @since 2017-02-22
 */
@RestController
@RequestMapping("/appManage")
public class AppManageController extends BaseController<AppManageService,App> implements AppMangeFacade {
    @Override
    public String queryAppIdByAppCode(String appCode) {
        return null;
    }
}