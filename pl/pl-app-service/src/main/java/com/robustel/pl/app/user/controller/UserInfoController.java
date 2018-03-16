package com.robustel.pl.app.user.controller;

import com.robustel.common.web.vo.RtResponse;
import com.robustel.pl.app.user.entity.UserInfo;
import com.robustel.pl.app.user.facade.UserInfoFacade;
import com.robustel.pl.app.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 11:41 2018/2/24
 * Modified By:
 */
@Api(tags = {"用户管理"})
@Controller
public class UserInfoController implements UserInfoFacade{
    @Autowired
    private UserService userService;

    @ApiOperation(value="删除用户",notes="根据用户ID删除用户")
    @Override
    public RtResponse<UserInfo> deleteByPrimaryKey(String userId) {
        userService.deleteById(userId);
        return null;
    }

    @ApiOperation(value="添加用户",notes="新增用户信息")
    @Override
    public RtResponse<UserInfo> addUser(@RequestBody UserInfo userInfo) {
        userService.insert(userInfo);
        UserInfo user = userService.selectOne(userInfo);
        RtResponse response = new RtResponse();
        response.setData(user);
        response.setCode(0);
        return response;
    }

    @PreAuthorize("hasAuthority('user:find')")
    @ApiOperation(value="查询用户信息",notes="根据用户Id查询用户信息")
    @Override
    public RtResponse<UserInfo> selectByPrimaryKey(@PathVariable("userId") String userId) {
        UserInfo user = userService.selectById(userId);
        RtResponse response = new RtResponse();
        response.setData(user);
        response.setCode(0);
        return response;
    }

    @ApiOperation(value="修改用户信息",notes="更新用户信息")
    @Override
    public RtResponse<UserInfo> updateByPrimaryKeySelective(UserInfo userInfo) {
        return null;
    }
}
