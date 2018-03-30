package com.robustel.pl.app.management.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AppVo implements Serializable{
    /** 应用ID */
    private String appId;

    /** 应用名称 */
    private String appName;

    /** 应用代码 */
    private String appCode;

    /** 是否上线，0下线，1上线（如对应用进行删除操作，即置为0） */
    private String isOnline;

    /** 应用类型[0独立系统,1平台,2子系统] */
    private String appType;

    /** 所属平台Id */
    private String appPlatformId;

    /** 所属平台名 */
    private String appPlatformName;

    /** 应用描述 */
    private String appDesc;

    /** 0存库,1写文件,2Nosql,3忽略 */
    private String appLogTactics;

    /**
     * 模糊查询字段
     */
    private String keyword;
}
