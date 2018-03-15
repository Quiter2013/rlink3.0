package com.robustel.auth.client.config;

import com.robustel.auth.client.interceptor.OAuth2FeignRequestInterceptor;
import com.robustel.auth.client.properties.AuthenticationProperties;
import com.robustel.auth.common.properties.OAuth2ClientProperties;
import com.robustel.auth.common.properties.SecurityProperties;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private ResourceServerProperties resource;

    @Autowired
    private SecurityProperties securityProperties;


    @Autowired(required = false)
    private AuthenticationProperties authenticationProperties;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        String [] permitURL = new String[]{};
        if(authenticationProperties != null){
            permitURL = authenticationProperties.getPermitURL();
        }
        http.csrf().disable()
                .requestMatchers().antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(permitURL).permitAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        OAuth2ClientProperties client = securityProperties.getOauth2().getClient();
        CustomRemoteTokenServices resourceServerTokenServices = new CustomRemoteTokenServices();
        resourceServerTokenServices.setCheckTokenEndpointUrl(client.getCheckTokenEndpointUrl());
        resourceServerTokenServices.setClientId(client.getClientId());
        resourceServerTokenServices.setClientSecret(client.getClientSecret());
        resourceServerTokenServices.setLoadBalancerClient(loadBalancerClient);
        resources.tokenServices(resourceServerTokenServices);
    }

    @Bean
    public RequestInterceptor oauth2FeignRquestInterceptor(){
        return new OAuth2FeignRequestInterceptor();
    }

}
