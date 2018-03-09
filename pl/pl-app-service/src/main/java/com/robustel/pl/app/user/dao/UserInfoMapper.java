package com.robustel.pl.app.user.dao;

import com.robustel.pl.app.user.entity.UserInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Desc 用户基本信息表操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
public interface UserInfoMapper extends Mapper<UserInfo>{

    List<UserInfo> queryUserByCompanyId(String companyId);

    List<UserInfo> queryUserByIds(List<String> userIds);
}