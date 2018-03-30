package com.robustel.pl.app.multilingual.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class LanguageKeyVo implements Serializable {
    /** 语言KEY值ID */
    private String langKeyId;

    /** KEY代码 */
    private String keyCode;

    /** 多语言分组代码 */
    private String gpCode;

    /** 分组名 */
    private String gpName;

    /** 应用ID */
    private String appId;

    /** KEY类型: 0普通页面,1系统后台 */
    private String keyType;

    /** 默认值 */
    private String defaultValue;

    /** KEY描述,这个语言标签使用场景 */
    private String keyDesc;
}
