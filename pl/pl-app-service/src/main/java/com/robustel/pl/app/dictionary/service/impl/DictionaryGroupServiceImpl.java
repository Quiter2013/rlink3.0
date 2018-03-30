package com.robustel.pl.app.dictionary.service.impl;

import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.pl.app.dictionary.dao.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustel.pl.app.dictionary.dao.DictionaryGroupMapper;
import com.robustel.pl.app.dictionary.entity.DictionaryGroup;
import com.robustel.pl.app.dictionary.service.DictionaryGroupService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Desc 提供字典分组在方法间调用的服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-05
 */
@Service
public class DictionaryGroupServiceImpl extends BaseServiceImpl<DictionaryGroupMapper,DictionaryGroup> implements DictionaryGroupService {
    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public DictionaryGroup queryDgByNameOrCodeInApp(String appId, String name, String code) {
        return mapper.queryDgByNameOrCodeInApp(appId, name, code);
    }

    @Override
    public DictionaryGroup judgeUpdateWhetherExists(String appId, String dicGpId, String name, String code) {
        return mapper.judgeUpdateWhetherExists(appId, dicGpId, name, code);
    }

    @Override
    public List<Map<String, Object>> queryDicList2Group(DictionaryGroup dictionaryGroup) {
        return mapper.queryDicList2Group(dictionaryGroup);
    }

    @Transactional
    @Override
    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
        dictionaryMapper.deleteByDictionaryGroupId(id.toString());
    }


}
