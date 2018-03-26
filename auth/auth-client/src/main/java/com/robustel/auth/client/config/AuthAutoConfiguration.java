package com.robustel.auth.client.config;

import com.robustel.auth.client.interceptor.OAuth2FeignRequestInterceptor;
import com.robustel.auth.client.rpc.RestTemplateService;
import com.robustel.auth.client.security.token.CustomRemoteTokenServices;
import com.robustel.auth.common.properties.OAuth2ClientProperties;
import com.robustel.auth.common.properties.SecurityProperties;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
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
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public CustomRemoteTokenServices customRemoteTokenServices(){
        CustomRemoteTokenServices resourceServerTokenServices = new CustomRemoteTokenServices();
        resourceServerTokenServices.setRestTemplateService(restTemplateService());
        return resourceServerTokenServices;
    }

    @Bean
    public RestTemplateService restTemplateService() {
        OAuth2ClientProperties client = securityProperties.getOauth2().getClient();
        RestTemplateService restTemplateService = new RestTemplateService();
        restTemplateService.setCheckTokenEndpointUrl(client.getCheckTokenEndpointUrl());
        restTemplateService.setClientId(client.getClientId());
        restTemplateService.setClientSecret(client.getClientSecret());
        restTemplateService.setLoadBalancerClient(loadBalancerClient);
        restTemplateService.setAuthServiceName(client.getAuthServiceId());
        return restTemplateService;
    }

    @Bean
    public RequestInterceptor oauth2FeignRquestInterceptor(){
        return new OAuth2FeignRequestInterceptor();
    }
}
