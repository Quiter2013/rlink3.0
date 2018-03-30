package com.robustel.pl.app.user.controller;

import com.robustel.common.web.controller.BaseController;
import com.robustel.common.web.vo.RtResponse;
import com.robustel.pl.app.user.entity.UserInfo;
import com.robustel.pl.app.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 11:41 2018/2/24
 * Modified By:
 */
@Api(tags = {"用户管理"})
@RestController
@RequestMapping("/user")
public class UserInfoController extends BaseController<UserInfoService,UserInfo>{

    @ApiOperation(value="删除用户",notes="根据用户ID删除用户")
    public RtResponse<UserInfo> deleteByPrimaryKey(String userId) {
        service.deleteById(userId);
        return null;
    }

    @ApiOperation(value="添加用户",notes="新增用户信息")
    public RtResponse<UserInfo> addUser(@RequestBody UserInfo userInfo) {
        service.insert(userInfo);
        UserInfo user = service.selectOne(userInfo);
        RtResponse response = new RtResponse();
        response.setData(user);
        response.setCode(0);
        return response;
    }

    @PreAuthorize("hasAuthority('user:find')")
    @ApiOperation(value="查询用户信息",notes="根据用户Id查询用户信息")
    public RtResponse<UserInfo> selectByPrimaryKey(@PathVariable("userId") String userId) {
        UserInfo user = service.selectById(userId);
        RtResponse response = new RtResponse();
        response.setData(user);
        response.setCode(0);
        return response;
    }

    @ApiOperation(value="修改用户信息",notes="更新用户信息")
    public RtResponse<UserInfo> updateByPrimaryKeySelective(UserInfo userInfo) {
        return null;
    }
}
