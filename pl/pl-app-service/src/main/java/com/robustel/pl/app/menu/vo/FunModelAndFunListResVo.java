package com.robustel.pl.app.menu.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Desc 功能模块及其对应的功能列表展示类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-27
 */
@Data
public class FunModelAndFunListResVo implements Serializable {
    /** 模块ID */
    private String modelId;

    /** 应用ID */
    private String appId;

    /** 模块名称 */
    private String name;

    /** 模块描述 */
    private String modelDesc;

    /** 模块资源路径 */
    private String resPath;

    /** 参数 */
    private String resParam;

    /**
     * 功能模块对应的功能列表
     */
    private List<FunResVo> funList;

    public FunModelAndFunListResVo() {

    }

    public FunModelAndFunListResVo(FunModelResVo fmrv) {
        this.appId = fmrv.getAppId();
        this.modelDesc = fmrv.getModelDesc();
        this.modelId = fmrv.getModelId();
        this.name = fmrv.getName();
        this.resParam = fmrv.getResParam();
        this.resPath = fmrv.getResPath();
    }
}
