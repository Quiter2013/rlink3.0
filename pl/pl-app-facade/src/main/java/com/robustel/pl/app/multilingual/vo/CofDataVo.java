package com.robustel.pl.app.multilingual.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Desc 多语言导入导出VO
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-03
 */
@Data
public class CofDataVo implements Serializable {
    /**
     * 多语言Key code
     */
    private String keyCode;

    /**
     * 语种名
     */
    private String cofName;

    /**
     * 多语言Key在此语种下的显示值
     */
    private String dataDisplay;
}
