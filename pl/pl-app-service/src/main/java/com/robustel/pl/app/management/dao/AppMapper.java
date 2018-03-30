package com.robustel.pl.app.management.dao;

import com.robustel.pl.app.management.entity.App;
import com.robustel.pl.app.management.vo.AppVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Desc 应用操作类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-22
 */
public interface AppMapper extends Mapper<App> {
    /**
     * 查询符合条件的数据列表
     * @param record
     * @return
     */
    List<Map<String, Object>> queryList(AppVo record);

    /**
     * 获取指定用户可以访问的应用列表（带应用信息查询）
     * @param params 必须带有userId（用户ID），其他字段必须是应用信息实体中的字段
     * @return
     */
    List<Map<String, Object>> queryAppList2User(Map<String, Object> params);
}