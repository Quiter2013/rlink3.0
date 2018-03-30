package com.robustel.pl.app.user.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 平台查询用户列表返回展示类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-25
 */
@Data
public class PlUserVo implements Serializable {
    /** 表主键，不参与业务 */
    private String userId;

    /** 用户名 */
    private String userName;

    /** 登录账号 */
    private String loginAccount;

    /** 邮箱地址 */
    private String email;

    /** 用户状态 */
    private String state;

    /** 创建时间 */
    private Long createTime;

    /** 创建人 */
    private String creater;

    /** 应用ID */
    private String appId;

    /** 应用名称 */
    private String appName;

    /** 是否默认应用：0否，1是。默认为0 */
    private String isDefault;
    
    private String groupId;
}
