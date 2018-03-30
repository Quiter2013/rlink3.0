package com.robustel.common.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示需登陆的接口
 * 如远程调用
 * @file NeedLogin
 * @author gaolinlou
 * @date 2016年1月28日 下午16:45
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [Robustel/ice] （可选）
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedLogin {

}
