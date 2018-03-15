package com.robustel.auth.client.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 18:08 2018/3/12
 * Modified By:
 */
@Configuration
@ComponentScan({"com.robustel.auth.client","com.robustel.auth.common"})
public class AuthAutoConfiguration {
}
