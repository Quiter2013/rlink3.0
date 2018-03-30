package com.robustel.pl.app.user.service.impl;

import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.pl.app.user.dao.UserInfoMapper;
import com.robustel.pl.app.user.entity.UserInfo;
import com.robustel.pl.app.user.service.UserInfoService;
import com.robustel.pl.app.user.vo.ParamUserVo;
import com.robustel.pl.app.user.vo.PlUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc 用户方法间调用的服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-29
 */
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper,UserInfo> implements UserInfoService {
    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public int changePassword(String oldPassword, String newPassword, String userId) {
        return 0;
    }

    @Override
    public Long verifyUnique(String loginAccount, String userId) {
        return null;
    }

    @Override
    public UserInfo login(String loginAccount, String password) {
        return null;
    }

    @Override
    public List<UserInfo> queryList2RLink(ParamUserVo vo) {
        return null;
    }

    @Override
    public List<PlUserVo> queryUserList2Pl(ParamUserVo vo) {
        return null;
    }

    @Override
    public UserInfo queryUserInfoByLoginAccountOrUserName(String loginAccount, String userName) {
        return null;
    }

    @Override
    public List<UserInfo> queryUserByCompanyId(String companyId) {
        return mapper.queryUserByCompanyId(companyId);
    }

    @Override
    public List<UserInfo> queryUserByIds(List<String> userIds) {
        return mapper.queryUserByIds(userIds);
    }

}
