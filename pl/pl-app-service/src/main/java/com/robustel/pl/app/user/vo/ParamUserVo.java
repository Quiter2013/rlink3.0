package com.robustel.pl.app.user.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc 请求参数VO
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-25
 */
@Data
public class ParamUserVo implements Serializable {
    /** 用户名 */
    private String userName;

    /** 登录账号 */
    private String loginAccount;

    /** 当前登录人所在的组列表 */
    private List<String> groupIds;

    /** 用户状态 */
    private String state;

    /** 是否默认应用：0否，1是。默认为0 */
    private String isDefault;

    /** 模糊查询 */
    private String keyword;

    /** 应用ID */
    private String appId;
}
