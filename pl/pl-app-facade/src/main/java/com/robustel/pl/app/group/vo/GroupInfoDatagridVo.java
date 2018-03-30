package com.robustel.pl.app.group.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 组信息Datagrid展示类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-26
 */
@Data
public class GroupInfoDatagridVo implements Serializable{
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

    /**
     * 父组名
     */
    private String parentGroupName;

    /** 组织根组ID */
    private String rootGroupId;

    /**
     * 根组名
     */
    private String rootGroupName;

    /** 组全路径名，格式为：根组名称/父组名称/子组名称 */
    private String groupFullName;

    /** 组全路径编码，格式为：根组编码/父组编码/子组编码 */
    private String groupFullCode;

    /** 组全路径Id，格式为：根组Id/父组Id/子组Id */
    private String groupFullId;

    /** 组LOGO */
    private String groupLogo;

    /** 组版图 */
    private String groupBgImg;

    /** 显示排序 */
    private Integer showOrder;

    /** 组描述 */
    private String gpDesc;

    /** 组状态：0可用,1禁用 */
    private String state;

    /** 超级管理员ID */
    private String superAdminId;

    /** 超级管理员 */
    private String superAdmin;

    /** 所属国家 */
    private String country;

    /** 所属国家代码 */
    private String countryCode;

    /** 所属省份 */
    private String province;

    /** 所属省份代码 */
    private String provinceCode;

    /** 所属城市 */
    private String city;

    /** 所属城市代码 */
    private String cityCode;

    /** 详细街道地址 */
    private String detailAddress;

    /** 位置经度 */
    private Float longitude;

    /** 位置纬度 */
    private Float latitude;

    /** 创建人ID */
    private String createUserId;

    /** 创建时间 */
    private Long createTime;

    /** 创建人 */
    private String creater;
}
