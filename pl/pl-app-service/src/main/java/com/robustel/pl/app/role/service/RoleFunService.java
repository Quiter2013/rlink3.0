package com.robustel.pl.app.role.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.role.entity.RoleFun;

/**
 * @Desc 方法间调用的角色功能服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-28
 */
public interface RoleFunService {

    /**
     * 批量插入角色功能
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<RoleFun> records);
}
