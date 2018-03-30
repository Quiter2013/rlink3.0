package com.robustel.pl.app.multilingual.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 系统多语言配置信息类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-08
 */
@Data
@Table(name = "tbs_pl_multilingual_cof")
public class MultilingualCof implements Serializable {
    /** 语言ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String muId;

    /** 多语言CODE */
    private String code;

    /** 应用ID */
    private String appId;

    /** 语言名称 */
    private String multilingualName;

    /** 语言描述 */
    private String langDesc;

    /** 呈现约束: 当什么情况下使用 */
    private String useCondition;

    /** 是否默认 */
    private String isDefault;
}