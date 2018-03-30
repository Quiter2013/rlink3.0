package com.robustel.common.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记不可为空的参数
 * 
 * @file NotNull
 * @author leicheng
 * @date 2015年12月21日 下午2:46:56
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [Robustel/ice] （可选）
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
}
