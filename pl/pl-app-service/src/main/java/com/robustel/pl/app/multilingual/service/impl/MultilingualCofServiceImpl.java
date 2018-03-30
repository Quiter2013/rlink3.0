package com.robustel.pl.app.multilingual.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robustel.pl.app.multilingual.dao.MultilingualCofMapper;
import com.robustel.pl.app.multilingual.entity.MultilingualCof;
import com.robustel.pl.app.multilingual.service.MultilingualCofService;

/**
 * @Desc 语种方法间调用服务接口实现类
 * @author HanZhijun
 * @since 2017-05-05
 */
@Service("multilingualCofService")
public class MultilingualCofServiceImpl implements MultilingualCofService {
    @Autowired
    private MultilingualCofMapper multilingualCofMapper;

    @Override
    public MultilingualCof queryCofByCodeOrMultiName(String appId, String code, String multilingualName) {
        return multilingualCofMapper.queryCofByCodeOrMultiName(appId, code, multilingualName);
    }

    @Override
    public MultilingualCof judgeUpdateWhetherExists(String muId, String appId, String code, String multilingualName) {
        return multilingualCofMapper.judgeUpdateWhetherExists(muId, appId, code, multilingualName);
    }

}
