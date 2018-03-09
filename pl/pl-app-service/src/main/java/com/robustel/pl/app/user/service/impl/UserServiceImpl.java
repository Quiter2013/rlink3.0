package com.robustel.pl.app.user.service.impl;

import com.robustel.common.core.exception.BizException;
import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.pl.app.user.dao.UserInfoMapper;
import com.robustel.pl.app.user.entity.UserInfo;
import com.robustel.pl.app.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Desc 用户方法间调用的服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-29
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserInfoMapper,UserInfo> implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public List<UserInfo> queryUserByCompanyId(String companyId) {
        return mapper.queryUserByCompanyId(companyId);
    }

    @Override
    public List<UserInfo> queryUserByIds(List<String> userIds) {
        return mapper.queryUserByIds(userIds);
    }

    @Override
    public int queryRLinkUserCount() {
        return mapper.selectCount(null);
    }

    @Override
    //@Transactional
    public int batchInsert(List<String> names) {
        int count =0;
        for(String name : names){
            UserInfo user = new UserInfo();
            user.setUserName("zhangshang"+count);
            user.setLoginAccount("123");
            user.setEmail("12334");
            user.setCreateTime(1536370717815L);
            user.setCreater("gaolinlou");
            user.setLoginPwd("123");
            mapper.insert(user);
            count ++;
            if(count >2){
                //throw new BizException("Error");
            }

        }
        return count;
    }
}
