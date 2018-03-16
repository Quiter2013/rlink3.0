package com.robustel.link.device.control;

import com.robustel.auth.client.annotation.EnableAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 19:08 2018/2/23
 * Modified By:
 */
@EnableAuthClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = {"com.robustel"})
@SpringBootApplication
@EnableDiscoveryClient
public class DeviceControlApp {
    public static void main(String[] args) {
        SpringApplication.run(DeviceControlApp.class,args);
    }
}
