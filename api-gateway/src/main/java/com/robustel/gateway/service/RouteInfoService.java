package com.robustel.gateway.service;

import com.robustel.common.core.service.BaseService;
import com.robustel.gateway.entity.RouteInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RouteInfoService extends BaseService<RouteInfo> {
    /**
     * 查询所有激活的路由规则
     * @return
     */
    List<RouteInfo> queryAllActiveRoutes();

    /**
     * 通过关键字分页查询路由规则
     * @param keyword
     * @return
     */
    List<RouteInfo> queryRoutes(String keyword,Integer pageNum,Integer pageSize);

}