package com.robustel.pl.app.dictionary.service.impl;

import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.pl.app.dictionary.dao.DictionaryMapper;
import com.robustel.pl.app.dictionary.entity.Dictionary;
import com.robustel.pl.app.dictionary.service.DictionaryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Desc 提供字典项在方法间调用的服务接口实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-05
 */
@Service
public class DictionaryServiceImpl extends BaseServiceImpl<DictionaryMapper,Dictionary> implements DictionaryService {


    @Override
    public Dictionary queryDicByNameOrCodeInGp(String dicGpId, String name, String code) {
        return mapper.queryDicByNameOrCodeInGp(dicGpId, name, code);
    }

    @Override
    public Dictionary judgeUpdateWhetherExists(String dicId, String dicGpId, String name, String code) {
        return mapper.judgeUpdateWhetherExists(dicId, dicGpId, name, code);
    }

    @Override
    public int deleteByDictionaryGroupId(String dictionaryGroupId) {
        return mapper.deleteByDictionaryGroupId(dictionaryGroupId);
    }

    @Override
    public List<Dictionary> queryDicListByGroupId(String dataDroupId) {
        return mapper.queryDicListByGroupId(dataDroupId);
    }

    @Override
    public List<Dictionary> queryDictionaryByCode(String code) {
        return mapper.queryDictionaryByCode(code);
    }

}
