package com.robustel.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: gaolinlou
 * @Description: 服务注册发现中心
 * @Date: Created in 18:04 2018/2/7
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicaton {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicaton.class,args);
    }
}
