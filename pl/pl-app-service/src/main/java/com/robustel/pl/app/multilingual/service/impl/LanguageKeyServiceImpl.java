package com.robustel.pl.app.multilingual.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustel.pl.app.multilingual.dao.LanguageKeyMapper;
import com.robustel.pl.app.multilingual.entity.LanguageKey;
import com.robustel.pl.app.multilingual.service.LanguageKeyService;

/**
 * @Desc 提供多语言Key在方法间调用的服务接口实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-05
 */
@Service("languageKeyService")
public class LanguageKeyServiceImpl implements LanguageKeyService {
    @Autowired
    private LanguageKeyMapper languageKeyMapper;

    @Override
    public LanguageKey queryKeyByAppIdAndKeyCode(String appId, String keyCode) {
        return languageKeyMapper.queryKeyByAppIdAndKeyCode(appId, keyCode);
    }

    @Override
    public LanguageKey judgeUpdateWhetherExists(String langKeyId, String appId, String keyCode) {
        return languageKeyMapper.judgeUpdateWhetherExists(langKeyId, appId, keyCode);
    }

    @Override
    public String getLanguageValue(String langKeyId, String muId) {
        return languageKeyMapper.getLanguageValue(langKeyId, muId);
    }

}
