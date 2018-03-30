package com.robustel.pl.app.group.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 请求参数封装类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-26
 */
@Data
public class ReqGroupInfoVo implements Serializable{
    /** 登录凭证 */
    private String ticket;

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

    /** 组类型：系统设定0普通社交圈,1团队,2组织,3中小企业,4集团,5内部小组 */
    private String groupType;

    /** 组业务类型，主要匹配组扩展字段的业务类型 */
    private String bizType;

    /** 父级组ID */
    private String parentGroupId;

    /** 组织根组ID */
    private String rootGroupId;

    /** 显示排序 */
    private Integer showOrder;

    /** 组描述 */
    private String gpDesc;

    /** 组状态：0可用,1禁用 */
    private String state;

    /** 请求显示页数 */
    private Integer pageNum;

    /** 每页显示记录数 */
    private Integer pageSize;

    /** 模糊查询字段,可根据组名、组编码、组简称模糊查询 */
    private String keyword;
}
