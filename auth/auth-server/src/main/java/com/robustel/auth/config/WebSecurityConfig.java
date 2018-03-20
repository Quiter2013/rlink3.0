package com.robustel.auth.config;

import com.robustel.auth.common.properties.SecurityProperties;
import com.robustel.auth.common.properties.UserDetailsProperties;
import com.robustel.auth.security.userdetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 16:28 2018/3/7
 * Modified By:
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        UserDetailsProperties userDetailsProperties = securityProperties.getUserDetails();
        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
        customUserDetailsService.setUsersByUsernameQuery(userDetailsProperties.getUsersByUsernameQuery());
        customUserDetailsService.setAuthoritiesByUseridQuery(userDetailsProperties.getAuthoritiesByUseridQuery());
        customUserDetailsService.setRolesByUseridQuery(userDetailsProperties.getRolesByUseridQuery());
        customUserDetailsService.setGroupRolesByUseridQuery(userDetailsProperties.getGroupRolesByUseridQuery());
        customUserDetailsService.setRolePrefix(userDetailsProperties.getRolePrefix());
        customUserDetailsService.setEnableAuthorities(userDetailsProperties.isEnableAuthorities());
        customUserDetailsService.setEnableGroups(userDetailsProperties.isEnableGroups());
        customUserDetailsService.setNamedParameterJdbcTemplate(namedParameterJdbcTemplate);
        return customUserDetailsService;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService()).passwordEncoder(new Md5PasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().and().csrf().disable().authorizeRequests()
                //页面请求处理
                .and() .authorizeRequests()
                .antMatchers(
                        "/**/login" ,"/login", "/hello" ,
                        "/**/oauth/authorize","/oauth/authorize",
                        "/**/oauth/token","/oauth/token" ,
                        "/**/getUserFromToken" ,"/getUserFromToken"
                ).permitAll()
                .anyRequest().authenticated()
                .and().logout().permitAll();
    }

}
