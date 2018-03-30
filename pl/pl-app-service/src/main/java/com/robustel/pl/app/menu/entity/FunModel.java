package com.robustel.pl.app.menu.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 功能模块实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-27
 */
@Data
@Table(name = "tbs_pl_fun_model")
public class FunModel implements Serializable{
    /** 模块ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String modelId;

    /** 应用ID */
    private String appId;

    /** 模块名称 */
    private String name;

    /** 模块名称多语言Key编码 */
    private String keyCode;

    /** 模块描述 */
    private String modelDesc;

    /** 模块资源路径 */
    private String resPath;

    /** 参数 */
    private String resParam;
}