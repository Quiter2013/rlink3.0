package com.robustel.pl.app.user.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.user.entity.UserRole;
import com.robustel.pl.app.user.vo.UserRoleVo;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 用户角色数据库操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-04-29
 */
public interface UserRoleMapper extends Mapper<UserRole> {

    /**
     * 获取某用户在某应用下的角色列表
     * @param userId 用户ID
     * @param appId 应用ID
     * @return
     */
    List<UserRoleVo> queryList(@Param("userId") String userId, @Param("appId") String appId);

    /**
     * 获取用户在某应用下没有分配的角色列表
     * @param userId
     * @param appId
     * @return
     */
    List<UserRoleVo> queryNoDistributedRolesInApp(@Param("userId") String userId, @Param("appId") String appId,
                                                  @Param("createrId") String createrId);

    /**
     * 获取用户在某根组下没有分配的角色列表
     * @param userId
     * @param rootGroupId
     * @return
     */
    List<UserRoleVo> queryNoDistributedRolesInRootGroup(@Param("userId") String userId,
                                                        @Param("rootGroupId") String rootGroupId);

    /**
     * 获取已分配给用户的角色列表
     * @param userId 用户ID
     * @param appId 需查询的某个应用
     * @param keyword 模糊查询角色
     * @param createrId 通过createrId获取代理商或终端客户的固定角色
     * @return
     */
    List<UserRoleVo> queryDistributedRoles2Business(@Param("userId") String userId, @Param("appId") String appId,
                                                    @Param("keyword") String keyword, @Param("createrId") String createrId);

    /**
     * 获取未分配给用户的角色列表
     * 
     * @param userId
     * @param appId
     * @param createrId 通过createrId获取代理商或终端客户的固定角色
     * @return
     */
    List<UserRoleVo> queryNoDistributedRoles2Business(@Param("userId") String userId, @Param("appId") String appId,
                                                      @Param("createrId") String createrId);

    /**
     * 取消赋给用户userId的角色
     * 
     * @param userId
     */
    void deleteByUserId(@Param("userId") String userId);

    /**
     * 获取RLink3.0且与RLink3.0绑定的其他应用的没有分配的角色
     * 
     * @param userId
     * @param appIds
     * @param createrId
     * @return
     */
    List<UserRoleVo> queryNoDistributedRoles2BusinessAndApps(@Param("userId") String userId,
                                                             @Param("appIds") Set<String> appIds, @Param("createrId") String createrId);
}
