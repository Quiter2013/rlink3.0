package com.robustel.pl.app.group.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 终端客户显示类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-07-04
 */
@Data
public class ClientVo implements Serializable{
    /** 组ID */
    private String groupId;

    /** 应用ID */
    private String appId;

    /** 组名称 */
    private String groupName;

    /** 组代码 */
    private String groupCode;

    /** 组简称 */
    private String groupShortName;

    /** 组状态：0可用,1禁用 */
    private String state;

    /** 创建人ID */
    private String createUserId;

    /** 创建时间 */
    private Long createTime;

    /** 创建人 */
    private String creater;

    /** 超级管理员ID */
    private String superAdminId;

    /** 超级管理员 */
    private String superAdmin;

    /** 超级管理员对应的登录账号 */
    private String loginAccount;

    /** 超级管理员的联系邮箱 */
    private String email;
}
