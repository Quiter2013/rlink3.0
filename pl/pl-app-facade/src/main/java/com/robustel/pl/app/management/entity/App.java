package com.robustel.pl.app.management.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 应用实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-22
 */
@Data
@Table(name = "tbs_pl_app")
public class App implements Serializable{
    /** 应用ID */
    @Id
    @GeneratedValue(generator = "UUID")
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
}