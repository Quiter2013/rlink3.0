package com.robustel.common.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Facade接口注解
 * @file Facade
 * @author gaolinlou
 * @date 2017年6月23日 下午15:21
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [Robustel/ice] （可选）
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Facade {

}
