package com.robustel.pl.app.dictionary.service;

import com.robustel.common.core.service.BaseService;
import com.robustel.pl.app.dictionary.entity.Dictionary;

import java.util.List;

/**
 * @Desc 提供字典项在方法间调用的服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-05
 */
public interface DictionaryService extends BaseService<Dictionary>{

    /**
     * 在某分组中根据字典项名或字典项代码查询记录
     * @param dicGpId
     * @param name 
     * @param code
     * @return
     */
    Dictionary queryDicByNameOrCodeInGp(String dicGpId, String name, String code);

    /**
     * 判断数字字典项修改时是否重复
     * @param dicId
     * @param dicGpId
     * @param name
     * @param code
     * @return
     */
    Dictionary judgeUpdateWhetherExists(String dicId, String dicGpId, String name, String code);

    int deleteByDictionaryGroupId(String dictionaryGroupId);

    List<Dictionary> queryDicListByGroupId(String dataDroupId);

    List<Dictionary> queryDictionaryByCode(String code);

}
