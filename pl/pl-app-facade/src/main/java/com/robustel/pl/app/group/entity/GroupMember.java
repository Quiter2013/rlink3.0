package com.robustel.pl.app.group.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Desc 组成员实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-27
 */
@Data
@Table(name = "tbs_pl_group_member")
public class GroupMember {
    private static final long serialVersionUID = 7161860126123921600L;

    /** 主键，不参与业务 */
    @Id
    @GeneratedValue(generator = "UUID")
    private String memberId;

    /** 组ID */
    private String groupId;

    /** 表主键，不参与业务 */
    private String userId;

    /** 默认为用户名字 */
    private String nickeName;

    /** 加入时间 */
    private Long joinTime;

    /** 邀请人ID */
    private String inviterId;

    /** 邀请人名称 */
    private String inviterName;

    /** 状态：0邀请未同意,1拒绝,2正常,3禁用,4删除 */
    private String state;
}