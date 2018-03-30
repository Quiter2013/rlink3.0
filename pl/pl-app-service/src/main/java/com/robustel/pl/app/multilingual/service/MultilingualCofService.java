package com.robustel.pl.app.multilingual.service;

import com.robustel.pl.app.multilingual.entity.MultilingualCof;

/**
 * @Desc 语种方法间调用服务接口
 * @author HanZhijun
 * @since 2017-05-05
 */
public interface MultilingualCofService {

    /**
     * 在指定应用下根据语种代码或语种名获取语种记录
     * @param appId
     * @param code
     * @param multilingualName
     * @return
     */
    MultilingualCof queryCofByCodeOrMultiName(String appId, String code, String multilingualName);

    /**
     * 修改时判断是否重复
     * @param muId 语种ID
     * @param appId 应用ID
     * @param code 语种代码
     * @param multilingualName 语种名
     * @return
     */
    MultilingualCof judgeUpdateWhetherExists(String muId, String appId, String code, String multilingualName);
}
