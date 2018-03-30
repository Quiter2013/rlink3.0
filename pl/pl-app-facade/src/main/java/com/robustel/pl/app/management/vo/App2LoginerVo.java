package com.robustel.pl.app.management.vo;

import com.robustel.pl.app.group.vo.ResponseGroupInfoVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class App2LoginerVo implements Serializable{

    /** 应用ID */
    private String appId;

    /** 应用名称 */
    private String appName;

    /** 应用代码 */
    private String appCode;

    private String isDefault;

    private List<ResponseGroupInfoVo> rootGroups;
}
