package com.robustel.pl.app.dictionary.service;

import com.robustel.common.core.service.BaseService;
import com.robustel.pl.app.dictionary.entity.DictionaryGroup;

import java.util.List;
import java.util.Map;

/**
 * @Desc 提供字典分组在方法间调用的服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-05
 */
public interface DictionaryGroupService extends BaseService<DictionaryGroup> {

    /**
     * 在指定应用下根据分组名或分组代码获取分组信息
     * @param appId
     * @param name
     * @param code
     * @return
     */
    DictionaryGroup queryDgByNameOrCodeInApp(String appId, String name, String code);

    /**
     * 判断字典分组修改时是否有重复
     * @param appId
     * @param dicGpId
     * @param name
     * @param code
     * @return 如果重复,返回重复的记录,如果不重复,返回null
     */
    DictionaryGroup judgeUpdateWhetherExists(String appId, String dicGpId, String name, String code);

    /**
     * 查询某个分组下的字典列表
     * @param dictionaryGroup
     * @return
     */
    List<Map<String, Object>> queryDicList2Group(DictionaryGroup dictionaryGroup);

}
