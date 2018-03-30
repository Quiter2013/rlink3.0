package com.robustel.pl.app.management.service.impl;

import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.pl.app.group.dao.GroupMemberMapper;
import com.robustel.pl.app.group.vo.ResponseGroupInfoVo;
import com.robustel.pl.app.management.dao.AppMapper;
import com.robustel.pl.app.management.entity.App;
import com.robustel.pl.app.management.service.AppManageService;
import com.robustel.pl.app.management.vo.App2LoginerVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class AppManageServiceImpl extends BaseServiceImpl<AppMapper,App> implements AppManageService {

    @Autowired
    private GroupMemberMapper groupMemberMapper;

    @Override
    public List<App2LoginerVo> queryApps2User(String userId) {
        List<App2LoginerVo> apps = null;
        // 1）获取某用户可访问的应用列表
        Map<String, Object> params = new HashMap<String, Object>();
        // 只获取上线的应用
        params.put("isOnline", "1");
        params.put("userId", userId);
        List<Map<String, Object>> appMaps = mapper.queryAppList2User(params);
        if (appMaps != null && !appMaps.isEmpty()) {
            apps = new ArrayList<App2LoginerVo>();
            // 2）遍历应用列表，根据应用获取用户所属根组列表;
            for (Map<String, Object> temp : appMaps) {
                App2LoginerVo appVo = new App2LoginerVo();
                String appId = (String) temp.get("APP_ID");
                String appName = (String) temp.get("APP_NAME");
                String appCode = (String) temp.get("APP_CODE");
                String isDefault = (String) temp.get("IS_DEFAULT");

                appVo.setAppId(appId);
                appVo.setAppName(appName);
                appVo.setAppCode(appCode);
                appVo.setIsDefault(isDefault);

                // 获取用户在某应用下的根组列表
                params.put("appId", appId);
                List<ResponseGroupInfoVo> rootGroups = groupMemberMapper.queryRootGroupByUserAndAppId(params);
                appVo.setRootGroups(rootGroups);

                apps.add(appVo);
            }
        } else {
            log.info("该用户没有可访问的应用记录");
        }

        return apps;
    }

}
