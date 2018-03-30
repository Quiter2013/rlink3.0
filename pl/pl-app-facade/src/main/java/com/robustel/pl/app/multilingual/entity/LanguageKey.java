package com.robustel.pl.app.multilingual.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 系统国际化语言KEY类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-08
 */
@Data
@Table(name = "tbs_pl_language_key")
public class LanguageKey implements Serializable {
    /** 语言KEY值ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String langKeyId;

    /** KEY代码 */
    private String keyCode;

    /** 多语言分组代码 */
    private String gpCode;

    /** 应用ID */
    private String appId;

    /** KEY类型: 0普通页面,1系统后台 */
    private String keyType;

    /** 默认值 */
    private String defaultValue;

    /** KEY描述,这个语言标签使用场景 */
    private String keyDesc;
}