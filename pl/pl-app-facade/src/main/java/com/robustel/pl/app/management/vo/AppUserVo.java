package com.robustel.pl.app.management.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 用户的应用信息展示类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-06-01
 */
@Data
public class AppUserVo implements Serializable{
    /** 用户关联应用的记录主键 */
    private String pid;

    /** 应用ID */
    private String appId;

    /** 应用名称 */
    private String appName;

    /** 应用代码 */
    private String appCode;

    /** 是否上线，0下线，1上线（如对应用进行删除操作，即置为0） */
    private String isOnline;

    /** 用户ID */
    private String userId;

    /** 是否默认应用：0否，1是。默认为0 */
    private String isDefault;
}
