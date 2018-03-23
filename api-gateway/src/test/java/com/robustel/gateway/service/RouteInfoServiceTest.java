package com.robustel.gateway.service;

import com.robustel.gateway.entity.RouteInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 17:19 2018/3/20
 * Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RouteInfoServiceTest {
    @Autowired
    private RouteInfoService routeInfoService;

    @Test
    public void testQueryAllActiveRoutes(){
        List<RouteInfo> routeInfos = routeInfoService.queryAllActiveRoutes();
        Assert.assertNotNull(routeInfos);
    }

    @Test
    public void testQueryRoutes(){
        List<RouteInfo> pp = routeInfoService.queryRoutes("pp", 1, 1);
        Assert.assertEquals(pp.size(),1);
    }
}
