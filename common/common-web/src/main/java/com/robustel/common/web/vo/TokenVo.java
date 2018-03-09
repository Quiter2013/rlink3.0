package com.robustel.common.web.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc 登录凭证保存VO
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-02
 */
public class TokenVo implements Serializable {
    private static final long serialVersionUID = -1930472531326283321L;

    /**
     * 用户ID
     */
    private String userId;
    /** 用户名 */
    private String userName;

    /** 登录账号 */
    private String loginAccount;

    /** 登录密码 */
    private String loginPwd;

    /** 用户状态 */
    private String state;
    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 当前登录的根组ID
     */
    private String rootGroupId;

    /**
     * 所在组织的业务类型:0开发者，1运营商，2终端客户，3内部组织
     */
    private String orgBizType;

    /**
     * 当前登录的应用ID
     */
    private String appId;

    /** 当前登录的应用名 */
    private String appName;

    /**
     * 是否被抢占登录：0否,1是
     */
    private String isSeize;

    private List<UserGroup> groups;

    /**
     * @Desc 默认构造方法
     * @author HanZhijun
     */
    public TokenVo() {

    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getRootGroupId() {
        return rootGroupId;
    }

    public void setRootGroupId(String rootGroupId) {
        this.rootGroupId = rootGroupId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getOrgBizType() {
        return orgBizType;
    }

    public void setOrgBizType(String orgBizType) {
        this.orgBizType = orgBizType;
    }

    public String getIsSeize() {
        return isSeize;
    }

    public void setIsSeize(String isSeize) {
        this.isSeize = isSeize;
    }

    public List<UserGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<UserGroup> groups) {
        this.groups = groups;
    }

    /**
     * 获取UserGroup实例
     * @return
     */
    public UserGroup getUserGroup() {
        UserGroup ug = new UserGroup();
        return ug;
    }

    /**
     * 当前登录人所在组织及身份判别
     * @author HanZhijun
     * @version 1.0.0
     * @since 2017-08-04
     */
    public class UserGroup implements Serializable {
        /**
         * 用户ID
         */
        private String userId;
        /**
         * 组织ID
         */
        private String groupId;
        /**
         * 组织名
         */
        private String groupName;
        /**
         * 是否是管理员
         */
        private Boolean isManager;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Boolean getIsManager() {
            return isManager;
        }

        public void setIsManager(Boolean isManager) {
            this.isManager = isManager;
        }
    }

	@Override
	public String toString() {
		return "TokenVo [userId=" + userId + ", userName=" + userName
				+ ", loginAccount=" + loginAccount + ", loginPwd=" + loginPwd
				+ ", state=" + state + ", loginIp=" + loginIp
				+ ", rootGroupId=" + rootGroupId + ", orgBizType=" + orgBizType
				+ ", appId=" + appId + ", appName=" + appName + ", isSeize="
				+ isSeize + ", groups=" + groups + "]";
	}
    
    
}
