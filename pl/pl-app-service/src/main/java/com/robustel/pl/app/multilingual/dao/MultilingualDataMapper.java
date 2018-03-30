package com.robustel.pl.app.multilingual.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.multilingual.entity.MultilingualData;
import com.robustel.pl.app.multilingual.vo.MultilingualDataVo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 系统多语言数据操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-08
 */
public interface MultilingualDataMapper extends Mapper<MultilingualData>{
    /**
     * 获取语言数据列表
     * 
     * @param record
     * @return
     */
    List<MultilingualData> getMulDatas(MultilingualData record);

    /**
     * 获取语言Key在特定语种下的显示列表<br>
     * 注：只有显示值才会随着语种的变化而变化,其他值为语言Key的数据
     * 
     * @param params 参数有两个值，一个是语种ID(不可为空,为空时返回的数据为长度等于0的数组)，<br>
     * 一个keyword,可模糊查询Key代码、默认值、描述、显示值
     * @return
     */
    List<MultilingualDataVo> getMulDatas4Cof(Map<String, Object> params);

    /**
     * 获取某应用下的多语言Key在不同语种下的显示值列表
     * 
     * @param appId
     * @return
     */
    List<Map<String, Object>> queryCofsAndDatas(@Param("appId") String appId);

    /**
     * 根据语种ID和多语言Key代码获取显示记录
     * @param muId
     * @param keyCode
     * @return
     */
    MultilingualData selectByMuIdAndKeyCode(@Param("muId") String muId, @Param("keyCode") String keyCode);
}