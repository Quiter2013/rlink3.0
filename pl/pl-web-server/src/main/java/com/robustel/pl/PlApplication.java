package com.robustel.pl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 17:59 2018/2/28
 * Modified By:
 */

@EnableSwagger2
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class PlApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlApplication.class,args);
    }
}
