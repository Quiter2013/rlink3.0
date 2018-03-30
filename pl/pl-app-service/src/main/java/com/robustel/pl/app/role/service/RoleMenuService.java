package com.robustel.pl.app.role.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.role.entity.RoleMenu;

/**
 * @Desc 方法间调用的角色菜单服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-28
 */
public interface RoleMenuService {

    /**
     * 批量挂载菜单到角色
     * @param records
     * @return
     */
    int batchInsert(@Param("records") List<RoleMenu> records);
}
