package com.robustel.pl.app.multilingual.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc 多语言显示值导入导出VO
 * @author HanZhijun
 *
 */
@Data
public class MultilingualDataExportVo implements Serializable {
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

    /**
     * 多语言Key在不同语种下的显示值
     * Map结构为: cofName, cofDisplay
     */
    private List<CofDataVo> cofDataList;
}
