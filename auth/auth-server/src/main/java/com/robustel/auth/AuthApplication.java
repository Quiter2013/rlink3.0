package com.robustel.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 19:19 2018/3/5
 * Modified By:
 */
//@EnableFeignClients
//@EnableDiscoveryClient
@SpringBootApplication
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class,args);
    }
}
