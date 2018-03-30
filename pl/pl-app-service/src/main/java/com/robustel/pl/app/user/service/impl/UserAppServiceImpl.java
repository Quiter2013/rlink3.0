package com.robustel.pl.app.user.service.impl;

import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.pl.app.management.vo.AppUserVo;
import com.robustel.pl.app.user.dao.UserAppMapper;
import com.robustel.pl.app.user.entity.UserApp;
import com.robustel.pl.app.user.service.UserAppService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 14:14 2018/3/28
 * Modified By:
 */
@Service
public class UserAppServiceImpl extends BaseServiceImpl<UserAppMapper,UserApp> implements UserAppService{
    @Override
    public List<AppUserVo> apps2User(String userId) {
        return mapper.apps2User(userId);
    }

    @Override
    public UserApp queryByUserIdAndAppId(String userId, String appId) {
        return mapper.queryByUserIdAndAppId(userId,appId);
    }

    @Override
    public UserApp queryDefaultAppByUserId(String userId, String pid) {
        return mapper.queryDefaultAppByUserId(userId,pid);
    }

    @Override
    public int updateIsDefaultByUserId(String userId) {
        return mapper.updateIsDefaultByUserId(userId);
    }

    @Override
    public int deleteByUserId(String userId) {
        return mapper.deleteByUserId(userId);
    }
}
