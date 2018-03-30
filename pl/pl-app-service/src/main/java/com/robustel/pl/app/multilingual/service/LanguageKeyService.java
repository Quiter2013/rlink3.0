package com.robustel.pl.app.multilingual.service;

import com.robustel.pl.app.multilingual.entity.LanguageKey;

/**
 * @Desc 提供多语言Key在方法间调用的服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-05
 */
public interface LanguageKeyService {

    /**
     * 获取指定应用的指定多语言Key记录
     * @param appId
     * @param keyCode
     * @return
     */
    LanguageKey queryKeyByAppIdAndKeyCode(String appId, String keyCode);

    /**
     * 判断修改时是否重复
     * @param langKeyId 多语言Key主键
     * @param appId 应用ID
     * @param keyCode 多语言代码
     * @return
     */
    LanguageKey judgeUpdateWhetherExists(String langKeyId, String appId, String keyCode);

    /**
     * 获取指定多语言Key在指定语种的值
     * 
     * @param langKeyId 多语言Key ID
     * @param muId 语种ID
     * @return
     */
    String getLanguageValue(String langKeyId, String muId);
}
