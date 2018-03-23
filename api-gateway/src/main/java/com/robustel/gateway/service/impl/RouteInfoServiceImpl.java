package com.robustel.gateway.service.impl;

import com.github.pagehelper.PageHelper;
import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.gateway.dao.RouteInfoMapper;
import com.robustel.gateway.entity.RouteInfo;
import com.robustel.gateway.service.RouteInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 15:53 2018/3/20
 * Modified By:
 */
@Service
public class RouteInfoServiceImpl extends BaseServiceImpl<RouteInfoMapper,RouteInfo> implements RouteInfoService{
    @Override
    public List<RouteInfo> queryAllActiveRoutes() {
        return mapper.queryAllActiveRoutes();
    }

    @Override
    public List<RouteInfo> queryRoutes(String keyword, Integer pageNum, Integer pageSize) {
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        return mapper.queryRoutes(keyword);
    }
}
