package com.robustel.gateway.dao;

import com.robustel.gateway.entity.RouteInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RouteInfoMapper extends Mapper<RouteInfo> {
    List<RouteInfo> queryAllActiveRoutes();
    List<RouteInfo> queryRoutes(@Param("keyword") String keyword);
}