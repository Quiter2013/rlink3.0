package com.robustel.gateway.config;

import com.robustel.gateway.service.RouteInfoService;
import com.robustel.gateway.zuul.CustomRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomZuulConfig {

    @Autowired
    ZuulProperties zuulProperties;
    @Autowired
    ServerProperties server;
    @Autowired
    RouteInfoService routeInfoService;

    @Bean
    public CustomRouteLocator routeLocator() {
        CustomRouteLocator routeLocator = new CustomRouteLocator(this.server.getServletPrefix(), this.zuulProperties);
        routeLocator.setRouteInfoService(routeInfoService);
        return routeLocator;
    }

}