package com.robustel.pl.app.user.service.impl;

import com.netflix.discovery.converters.Auto;
import com.robustel.pl.app.user.entity.UserInfo;
import com.robustel.pl.app.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 18:02 2018/2/26
 * Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testBatchInsert(){
        List<String> names = new ArrayList<String>();
        names.add("zhangshang");
        names.add("zhangshang");
        names.add("zhangshang");
        userService.batchInsert(names);
    }

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