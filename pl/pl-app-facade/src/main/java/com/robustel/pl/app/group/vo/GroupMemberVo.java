package com.robustel.pl.app.group.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 组员展示VO
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-09
 */
@Data
public class GroupMemberVo implements Serializable{
    /** 主键，不参与业务 */
    private String memberId;

    /** 表主键，不参与业务 */
    private String userId;

    /** 组ID */
    private String groupId;

    /** 登录账号 */
    private String loginAccount;

    /** 邮箱地址 */
    private String email;

    /** 默认为用户名字 */
    private String nickeName;

    /** 加入时间 */
    private Long joinTime;

    /** 邀请人名称 */
    private String inviterName;

    /** 状态：0邀请未同意,1拒绝,2正常,3禁用,4删除 */
    private String state;

    /**  该组的管理员ID  */
    private String superAdminId;

    private boolean isAdmin;
}
