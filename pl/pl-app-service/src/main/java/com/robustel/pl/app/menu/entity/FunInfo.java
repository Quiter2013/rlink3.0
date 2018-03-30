package com.robustel.pl.app.menu.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Desc 功能实体类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-24
 */
@Data
@Table(name = "tbs_pl_fun_info")
public class FunInfo implements Serializable{
    /** 功能ID */
    @Id
    @GeneratedValue(generator = "UUID")
    private String funId;

    /** 功能模块ID */
    private String modelId;

    /** 功能名称 */
    private String funName;

    /** 功能代码 */
    private String funCode;

    /** 执行函数 */
    private String executeMethod;

    /** 参数 */
    private String param;

    /** 多语言KEY */
    private String keyCode;

    /** 扩展字段1 */
    private String extend1;

    /** 扩展字段2 */
    private String extend2;

    /** 备注 */
    private String remark;

    /**
     * 请求地址
     */
    private String requestUrl;

    /**
     * 请求方式:1POST,2GET,3PUT，默认为1
     */
    private Character requestType;

    /**
     * 是否验证登录: 0否,1是，默认为1
     */
    private Character isValidLogin;
}