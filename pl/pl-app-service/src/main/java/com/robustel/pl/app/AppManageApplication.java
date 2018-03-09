package com.robustel.pl.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: gaolinlou
 * @Description:
 * @Date: Created in 19:26 2018/2/7
 * @Modified By:
 */
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.robustel"})
@MapperScan(basePackages = {"com.robustel.pl.*.*.dao"})
public class AppManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppManageApplication.class,args);
    }

}
