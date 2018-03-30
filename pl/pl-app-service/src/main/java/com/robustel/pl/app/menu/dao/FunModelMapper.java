package com.robustel.pl.app.menu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.menu.entity.FunModel;
import com.robustel.pl.app.menu.vo.FunModelResVo;
import com.robustel.pl.app.menu.vo.FunModelVo;

/**
 * @Desc 功能模块数据库操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-27
 */
public interface FunModelMapper {
    /**
     * 根据主键删除记录
     * @param modelId 模块ID
     * @return
     */
    int deleteByPrimaryKey(String modelId);

    /**
     * 新增记录（全字段）
     * @param record
     * @return
     */
    int insert(FunModel record);

    /**
     * 批量插入
     * @param models
     * @return
     */
    long batchInsert(@Param("models") List<Map<String, Object>> models);

    /**
     * 新增记录（可选字段）
     * @param record
     * @return
     */
    int insertSelective(FunModel record);

    /**
     * 根据主键获取记录
     * @param menuId
     * @return
     */
    FunModel selectByPrimaryKey(String modelId);

    /**
     * 更新记录（可选字段）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FunModel record);

    /**
     * 更新记录（全部字段）
     * @param record
     * @return
     */
    int updateByPrimaryKey(FunModel record);

    /**
     * 功能模块管理列表
     * @param funModel
     * @return
     */
    List<FunModelResVo> queryList2ModelManage(FunModelVo funModel);
}