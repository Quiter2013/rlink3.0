package com.robustel.auth.client.annotation;

import com.robustel.auth.client.config.AuthAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 18:06 2018/3/12
 * Modified By:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AuthAutoConfiguration.class)
@Documented
@Inherited
public @interface EnableAuthClient {
}
