package com.robustel.gateway.web;

import com.robustel.common.web.vo.RtPageResponse;
import com.robustel.common.web.vo.RtResponse;
import com.robustel.gateway.entity.RouteInfo;
import com.robustel.gateway.event.RefreshRouteService;
import com.robustel.gateway.service.RouteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gateway")
public class ApiGatewayController {

    @Autowired
    RefreshRouteService refreshRouteService;
    @Autowired
    RouteInfoService routeInfoService;

    @RequestMapping(value = "/routes/refresh",method=RequestMethod.POST)
    public  RtResponse<RouteInfo> refreshRoute(){
        refreshRouteService.refreshRoute();
        return RtResponse.success();
    }

    @RequestMapping(value = "/routes",method = RequestMethod.GET)
    public RtPageResponse<List<RouteInfo>> queryRouteList(@RequestParam(value = "keyword",required = false)String keyword,
                                                    @RequestParam(value ="pageNum",required = false)Integer pageNum,
                                                    @RequestParam(value ="pageSize",required = false)Integer pageSize){
        List<RouteInfo> routeInfos = routeInfoService.queryRoutes(keyword, pageNum, pageSize);
        RtPageResponse<List<RouteInfo>> result = new RtPageResponse<>(routeInfos, 0, "success");
        return result;
    }

    @RequestMapping(value="/routes",method = RequestMethod.POST)
    public RtResponse<RouteInfo> saveRoute(@RequestBody RouteInfo route){
        RouteInfo routeInfo = null;
        try {
            String id = route.getId();
            routeInfoService.insert(route);
            routeInfo = routeInfoService.selectById(id);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            return RtResponse.fail(500,"主键重复");
        }
        return RtResponse.success(routeInfo);
    }

    @RequestMapping(value="/routes",method = RequestMethod.PUT)
    public RtResponse<RouteInfo> modifyRoute(@RequestBody RouteInfo route){
        routeInfoService.updateById(route);
        return RtResponse.success();
    }

    @RequestMapping(value = "/routes",method= RequestMethod.DELETE)
    public RtResponse<RouteInfo>  removeRoute(@RequestParam String id){
        routeInfoService.deleteById(id);
        return RtResponse.success();
    }


}