package com.robustel.pl.app.dictionary.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 数据字典分组实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
@Data
@Table(name = "tbs_pl_dictionary_group")
public class DictionaryGroup implements Serializable{
    /** 字典分组ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String dicGpId;

    /** 字典分组名称 */
    private String name;

    /** 应用ID */
    private String appId;

    /** 字典分组代码 */
    private String code;

    /** 字典分组描述 */
    private String gpDesc;

    /** 字典类型[0现行结构,1树型结构] */
    private String type;

    /** 对字典进行分类 */
    private String parentDicGpId;

    /** 字典名称多语言代码 */
     private String lgNameCode;

    /** 字典描述多语言代码 */
    private String lgDescCode;

    /** 创建时间 */
    private Long createTime;

    /** 创建人 */
    private String createUserId;

    /** 创建人名 */
    private String creater;

    /** 字典级别：0 系统级别  1用户级别 */
    private String dicLevel;
}