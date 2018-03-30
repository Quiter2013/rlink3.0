package com.robustel.pl.app.dictionary.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.dictionary.entity.DictionaryGroup;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 数据字典组操作类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
public interface DictionaryGroupMapper extends Mapper<DictionaryGroup> {

    /**
     * 查询符合条件的数据列表
     * @param dictionaryGroup
     * @return
     */
    List<Map<String, Object>> queryList(DictionaryGroup dictionaryGroup);

    /**
     * 获取某应用的某个分组的数字字典项列表（可根据字典分组ID或字典分组的code获取）
     * 注：必须有appId，字典分组ID或分组code没有，则查询所有字典分组的字典项
     * 
     * @param dictionaryGroup
     * @return
     */
    List<Map<String, Object>> queryDicList2Group(DictionaryGroup dictionaryGroup);

    /**
     * 在指定应用下根据分组名或分组代码获取分组信息
     * @param appId
     * @param name
     * @param code
     * @return
     */
    DictionaryGroup queryDgByNameOrCodeInApp(@Param("appId") String appId, @Param("name") String name,
                                             @Param("code") String code);

    /**
     * 判断字典分组修改时是否有重复
     * @param appId
     * @param dicGpId
     * @param name
     * @param code
     * @return
     */
    DictionaryGroup judgeUpdateWhetherExists(@Param("appId") String appId, @Param("dicGpId") String dicGpId,
                                             @Param("name") String name, @Param("code") String code);
}