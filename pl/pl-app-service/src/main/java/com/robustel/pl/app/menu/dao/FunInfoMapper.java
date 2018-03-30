package com.robustel.pl.app.menu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.menu.entity.FunInfo;
import com.robustel.pl.app.menu.vo.FunResVo;

/**
 * @Desc 功能实体操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-24
 */
public interface FunInfoMapper {
    /**
     * 根据主键删除记录
     * @param funId 功能ID
     * @return
     */
    int deleteByPrimaryKey(String funId);

    /**
     * 删除某功能模块下的所有功能
     * 
     * @param modelId
     * @return
     */
    int deleteByModelId(@Param("modelId") String modelId);

    /**
     * 新增记录（全字段）
     * @param record
     * @return
     */
    int insert(FunInfo record);

    /**
     * 批量插入
     * @param funs
     * @return
     */
    long batchInsert(@Param("funs") List<Map<String, Object>> funs);

    /**
     * 新增记录（可选字段）
     * @param record
     * @return
     */
    int insertSelective(FunInfo record);

    /**
     * 根据主键获取记录
     * @param funId
     * @return
     */
    FunInfo selectByPrimaryKey(String funId);

    /**
     * 更新记录（可选字段）
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FunInfo record);

    /**
     * 更新记录（全部字段）
     * @param record
     * @return
     */
    int updateByPrimaryKey(FunInfo record);

    /**
     * 获取某菜单的功能列表
     * 
     * @param menuId 菜单id
     * @return
     */
    List<FunResVo> queryList2Menu(String menuId);

    /**
     * 功能管理的列表
     * 
     * @param record
     * @return
     */
    List<FunResVo> queryList2Manage(FunResVo record);

    /**
     * 获取某用户在指定根组下可访问的所有功能列表
     * 
     * @param userId 用户ID
     * @param rootGroupId 根组ID
     * @return
     */
    List<FunResVo> queryList2User(@Param("userId") String userId, @Param("rootGroupId") String rootGroupId);

    /**
     * 获取某应用的功能列表
     * @param appId
     * @return
     */
    List<FunResVo> queryList2App(@Param("appId") String appId);
}