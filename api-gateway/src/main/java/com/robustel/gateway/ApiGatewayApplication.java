package com.robustel.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: gaolinlou
 * @Description:
 * @Date: Created in 18:11 2018/2/7
 * @Modified By:
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.robustel.gateway.dao"})
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class,args);
    }
}
