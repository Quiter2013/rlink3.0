package com.robustel.common.utils.annotation;

import java.lang.annotation.*;

/**
 * 表示无需登陆的接口
 * @file NotNeedLogin
 * @author leicheng
 * @date 2015年10月27日 下午3:48:31
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [Robustel/ice] （可选）
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNeedLogin {
}
