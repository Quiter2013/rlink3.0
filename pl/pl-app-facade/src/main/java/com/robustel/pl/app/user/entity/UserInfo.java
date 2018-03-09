package com.robustel.pl.app.user.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Desc 用户基本信息实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
@Table(name="tbs_pl_user_base_info")
public class UserInfo {
    /** 表主键，不参与业务 */
    @Column(name="USER_ID")
    @Id()
    @GeneratedValue(generator = "UUID")
    private String userId;

    /** 用户名 */
    @Column(name="USER_NAME")
    private String userName;

    /** 登录账号 */
    @Column(name="LOGIN_ACCOUNT")
    private String loginAccount;

    /** 登录密码 */
    @Column(name="LOGIN_PWD")
    private String loginPwd;

    /** 邮箱地址 */
    @Column(name="EMAIL")
    private String email;

    /** 用户状态 */
    @Column(name="STATE")
    private String state;

    /** 创建时间 */
    @Column(name="CREATE_TIME")
    private Long createTime;

    /** 创建人 */
    @Column(name="CREATER")
    private String creater;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }
}