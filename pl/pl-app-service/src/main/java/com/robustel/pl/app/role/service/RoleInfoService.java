package com.robustel.pl.app.role.service;

import java.util.List;

import com.robustel.pl.app.role.entity.RoleInfo;
import com.robustel.pl.app.role.vo.RoleInfoVo;

/**
 * @Desc 为了应付生成代理商或终端客户时要有系统规定的四种角色：管理员、标准、受限、浏览<br>
 * 这是在修改License存在风险的情况下的临时方案，以后还会改为由License控制
 * 
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-09-14
 */
public interface RoleInfoService {
    /**
     * 关联四种代理商的角色：管理员、标准、浏览、受限，步骤：<br>
     * 1）获取代理商固定的系统角色列表；<br>
     * 2）将userId和角色ID关联；<br>
     * 3）入库
     * 
     * @param userId 需关联的用户ID
     * @param appId 应用ID
     * @return
     */
    int relevanceFourFixRole2Agent(String userId, String appId);

    /**
     * 关联四种终端客户的角色：管理员、标准、浏览、受限，步骤：<br>
     * 1）获取终端客户固定的系统角色列表；<br>
     * 2）将userId和角色ID关联；<br>
     * 3）入库
     * 
     * @param userId 需关联的用户ID
     * @param appId 应用ID
     * @return
     */
    int relevanceFourFixRole2Client(String userId, String appId);

    /**
     * 获取四种固定的代理商角色
     * @param appId
     * @return
     */
    List<RoleInfo> queryAgentRoles(RoleInfoVo riv);

    /**
     * 获取四种固定的终端客户角色
     * @param appId
     * @return
     */
    List<RoleInfo> queryClientRoles(RoleInfoVo riv);
}
