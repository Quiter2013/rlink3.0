package com.robustel.pl.app.user.service;

import com.robustel.pl.app.user.entity.UserInfo;
import com.robustel.pl.app.user.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 18:02 2018/2/26
 * Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServicelTest {

    @Autowired
    private UserInfoService userService;


    @Test
    public void testInsert(){
        UserInfo user = new UserInfo();
        user.setUserName("zhangshang-1");
        user.setLoginAccount("123");
        user.setEmail("12334");
        user.setCreateTime(1536370717815L);
        user.setCreater("gaolinlou");
        user.setLoginPwd("123");
        userService.insert(user);
    }
}