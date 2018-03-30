package com.robustel.pl.app.management.service;

import com.robustel.common.core.service.BaseService;
import com.robustel.pl.app.management.entity.App;
import com.robustel.pl.app.management.vo.App2LoginerVo;

import java.util.List;

public interface AppManageService extends BaseService<App>{

    /**
     * 获取某用户可访问的应用及其根组列表，步骤:<br>
     * 1）获取某用户可访问的应用列表;<br>
     * 2）遍历应用列表，根据应用获取用户所属根组列表;<br>
     * 3）组装vo并返回。
     * 
     * @param userId
     * @return
     */
    List<App2LoginerVo> queryApps2User(String userId);
}
