package com.robustel.pl.app.dictionary.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 数据字典项实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
@Data
@Table(name = "tbs_pl_dictionary")
public class Dictionary implements Serializable {
    /** 字典项ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String dicId;

    /** 字典分组ID */
    private String dicGpId;

    /** 字典名称 */
    private String name;

    /** 字典代码 */
    private String code;

    /** 字典父项 */
    private String parentId;

    /** 字典名称多语言代码 */
    private String lgNameCode;

    /** 字典描述多语言代码 */
    private String lgDescCode;

    /** 字典项描述 */
    private String dicDesc;

    /** 显示排序 */
    private Integer showOrder;

    /** 字典级别 */
    private String dicLevel;

    /** 扩展字段1 */
    private String expand1;

    /** 扩展字段2 */
    private String expand2;

    /** 创建人 */
    private String creater;

    /** 创建人ID */
    private String createUserId;

    /** 创建时间 */
    private Long createTime;

    /** 修改时间 */
    private Long updateTime;
}