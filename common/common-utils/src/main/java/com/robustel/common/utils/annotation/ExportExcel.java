package com.robustel.common.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表示需要将结果导出到Excel
 * 主要用于通用Excel导出，在原有查询的service接口上加上此注解，并在原有
 * 的查询接口的URL上带上请求参数export=xls 或者 export=xlsx
 * @file ExportExcel
 * @author gaolinlou
 * @date 2016年4月27日  上午10:33
 * @version 1.0.0
 * @see [相关类/方法]（可选）
 * @since [Robustel/ice] （可选）
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExportExcel {

}
