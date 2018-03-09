package com.robustel.pl.app.user.service;

import java.util.List;

import com.robustel.common.core.service.BaseService;
import com.robustel.pl.app.user.entity.UserInfo;

/**
 * @Desc 用户方法间调用的服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-29
 */
public interface UserService extends BaseService<UserInfo>{

    List<UserInfo> queryUserByCompanyId(String companyId);

    List<UserInfo> queryUserByIds(List<String> userIds);

    /**
     * 获取RLink3.0的用户数，由于代理商是单独部署，所以只需查询数据库里面的user总数即可
     * @return
     */
    int queryRLinkUserCount();

    int batchInsert(List<String> names);
}
