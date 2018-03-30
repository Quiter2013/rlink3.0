package com.robustel.pl.app.menu.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 功能模块返回展示类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-27
 */
@Data
public class FunModelResVo implements Serializable {
    /** 模块ID */
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
