package com.robustel.link.device.control.controller;

import com.robustel.common.web.vo.RtResponse;
import com.robustel.pl.app.user.entity.UserInfo;
import com.robustel.pl.app.user.facade.UserInfoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 18:59 2018/2/23
 * Modified By:
 */
@RestController
@RequestMapping(value="/device/control")
public class HelloController {

    @Autowired
    private UserInfoFacade userInfoFacade;

    @PreAuthorize("hasAuthority('editSysRole')")
    @GetMapping(value="/user/{userId}")
    @ResponseBody
    public String getUserName(@PathVariable("userId" ) String userId){
       RtResponse<UserInfo> user = userInfoFacade.selectByPrimaryKey(userId);
       return user.getData().getUserName();
    }

    @PostMapping(value="/user")
    public String saveUser(@RequestBody UserInfo user){
        RtResponse<UserInfo> userInfoRtResponse = userInfoFacade.addUser(user);
        return userInfoRtResponse.getData().getUserName();
    }
}
