package com.robustel.pl.app.multilingual.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.multilingual.entity.MultilingualCof;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 系统多语言配置信息操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-08
 */
public interface MultilingualCofMapper extends Mapper<MultilingualCof> {

    /**
     * 查询多语言配置列表
     * 
     * @param record
     * @return
     */
    List<Map<String, Object>> queryCofList(MultilingualCof record);

    /**
     * 获取某应用的语种列表
     * 
     * @param appId
     * @return
     */
    List<MultilingualCof> queryCofs2App(@Param("appId") String appId);

    /**
     * 在指定应用下根据语种代码或语种名获取语种记录
     * 
     * @param appId
     * @param code
     * @param multiName
     * @return
     */
    MultilingualCof queryCofByCodeOrMultiName(@Param("appId") String appId,
                                              @Param("code") String code,
                                              @Param("multilingualName") String multiName);

    /**
     * 修改时判断是否重复
     * @param muId 语种ID
     * @param appId 应用ID
     * @param code 语种代码
     * @param multiName 语种名
     * @return
     */
    MultilingualCof judgeUpdateWhetherExists(@Param("muId") String muId,
                                             @Param("appId") String appId,
                                             @Param("code") String code,
                                             @Param("multilingualName") String multiName);

    /**
     * 取消某应用的默认显示语种
     * 
     * @param appId
     * @return
     */
    int cancelDefault(@Param("appId") String appId);
}