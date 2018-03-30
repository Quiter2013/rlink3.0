package com.robustel.pl.app.dictionary.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.dictionary.entity.Dictionary;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 数据字典项操作类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
public interface DictionaryMapper extends Mapper<Dictionary>{

    /**
     * 根据数据字典分组ID删除指定分组下的所有数据项
     * 
     * @param dictionaryGroupId
     * @return
     */
    int deleteByDictionaryGroupId(String dictionaryGroupId);

    /**
     * 查询数据列表（主要用于查询某分组下的所有字典项列表）
     * @param dictionary
     * @return
     */
    List<Map<String, Object>> queryList(Dictionary dictionary);

    List<Dictionary> queryDicListByGroupId(String dataDroupId);

    /**
     * 在某分组中根据字典项名或字典项代码查询记录
     * @param dicGpId
     * @param name
     * @param code
     * @return
     */
    Dictionary queryDicByNameOrCodeInGp(@Param("dicGpId") String dicGpId, @Param("name") String name,
                                        @Param("code") String code);

    /**
     * 判断数字字典项修改时是否重复
     * 
     * @param dicId 字典项ID
     * @param dicGpId 字典分组ID
     * @param name 字典项名
     * @param code 字典项编码
     * @return
     */
    Dictionary judgeUpdateWhetherExists(@Param("dicId") String dicId, @Param("dicGpId") String dicGpId,
                                        @Param("name") String name, @Param("code") String code);

	List<Dictionary> queryDictionaryByCode(String code);
}