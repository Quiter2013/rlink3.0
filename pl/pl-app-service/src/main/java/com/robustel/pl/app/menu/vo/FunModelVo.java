package com.robustel.pl.app.menu.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class FunModelVo implements Serializable {
    /** 模块ID */
    private String modelId;

    /** 应用ID */
    private String appId;

    /** 模块名称 */
    private String name;

    /** 模块描述 */
    private String modelDesc;

    /** 模块资源路径 */
    private String resPath;

    /** 参数 */
    private String resParam;

    /** 模糊查询，可根据模块名、模块描述进行模糊查询 */
    private String keyword;
}
