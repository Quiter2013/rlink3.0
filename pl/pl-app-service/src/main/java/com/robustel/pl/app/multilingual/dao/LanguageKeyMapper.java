package com.robustel.pl.app.multilingual.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.multilingual.entity.LanguageKey;
import com.robustel.pl.app.multilingual.vo.LanguageKeyVo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 系统国际化语言KEY实体操作类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-08
 */
public interface LanguageKeyMapper extends Mapper<LanguageKey> {
    /**
     * 查询国际化语言KEY列表
     * 
     * @param record
     * @return
     */
    List<Map<String, Object>> queryKeys(LanguageKey record);

    /**
     * 根据应用获取语言Key列表，可根据key的代码、默认值、描述进行模糊查询
     * @param params 只含两个参数: appId(必填), keyword查询框输入的值
     * @return
     */
    List<LanguageKeyVo> queryKeysByAppId(Map<String, Object> params);

    /**
     * 获取指定应用的指定多语言Key记录
     * @param appId
     * @param keyCode
     * @return
     */
    LanguageKey queryKeyByAppIdAndKeyCode(@Param("appId") String appId, @Param("keyCode") String keyCode);

    /**
     * 判断修改时是否重复
     * @param langKeyId 多语言Key主键
     * @param appId 应用ID
     * @param keyCode 多语言代码
     * @return
     */
    LanguageKey judgeUpdateWhetherExists(@Param("langKeyId") String langKeyId, @Param("appId") String appId,
                                         @Param("keyCode") String keyCode);

    /**
     * 获取指定多语言Key在指定语种的值
     * 
     * @param langKeyId 多语言Key ID
     * @param muId 语种ID
     * @return
     */
    String getLanguageValue(@Param("langKeyId") String langKeyId, @Param("muId") String muId);

    /**
     * 根据语种ID、应用、多语言Key分组获取对应的多语言记录（key和某语种下的显示值）
     * 
     * @param params 必须包含appId、muId且其值不能为空，gpCodes可以为空
     * @return
     */
    List<Map<String, Object>> queryKeyValues(Map<String, Object> params);
}