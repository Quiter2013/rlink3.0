package com.robustel.pl.app.user.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 用户基本信息实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
@Data
@Table(name = "tbs_pl_user_base_info")
public class UserInfo implements Serializable {
    /** 表主键，不参与业务 */
    @Id
    @GeneratedValue(generator = "UUID")
    private String userId;

    /** 用户名 */
    private String userName;

    /** 登录账号 */
    private String loginAccount;

    /** 登录密码 */
    private String loginPwd;

    /** 邮箱地址 */
    private String email;

    /** 用户状态 */
    private String state;

    /** 创建时间 */
    private Long createTime;

    /** 创建人 */
    private String creater;
}