package com.robustel.pl.app;

import com.robustel.auth.client.annotation.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: gaolinlou
 * @Description:
 * @Date: Created in 19:26 2018/2/7
 * @Modified By:
 */
@EnableCaching
@EnableCircuitBreaker
@EnableAuthClient
@EnableDiscoveryClient
@SpringBootApplication//(scanBasePackages = {"com.robustel"})
@MapperScan(basePackages = {"com.robustel.pl.*.*.dao"})
public class AppManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppManageApplication.class, args);
    }


}
