package com.robustel.pl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 18:09 2018/2/28
 * Modified By:
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket ProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.robustel.pl"))
                .build()
                .apiInfo(productApiInfo());

    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("用户系统数据接口文档",
                "用户管理相关接口",
                "1.0.0",
                "API TERMS URL",
                "gaolinlou@robustel.cn",
                "license",
                "www.robustel.com");
        return apiInfo;
    }
}
