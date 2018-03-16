package com.robustel.common.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author: gaolinlou
 * @Description: 数据源配置，可以动态刷新数据源的配置，无需重启
 * @Date: Created in 11:20 2018/2/9
 * @Modified By:
 */
@Slf4j
@Configuration
@RefreshScope
public class DataSourceConfig {
    @Bean
    @RefreshScope
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource dataSource() {
        log.info("Initializing datasource to support refresh.");
        return new DataSoureWrapper();
    }

}
