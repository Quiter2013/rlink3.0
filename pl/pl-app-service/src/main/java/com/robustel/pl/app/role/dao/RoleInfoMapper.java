package com.robustel.pl.app.role.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.role.entity.RoleInfo;
import com.robustel.pl.app.role.vo.RoleInfoVo;

/**
 * @Desc 角色实体操作类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-06
 */
public interface RoleInfoMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);

    /**
     * 查询角色列表信息
     * 
     * @param record
     * @return
     */
    List<Map<String, Object>> queryRoles(RoleInfoVo record);

    /**
     * 判断角色是否存在
     * @param appId 必填
     * @param roleName 必填
     * @param roleId 修改时才存在
     * @return
     */
    RoleInfo selectByAppIdAndRoleNameAndRoleId(@Param("appId") String appId, @Param("roleName") String roleName,
                                               @Param("roleId") String roleId);

    /**
     * 获取某应用appId名为roleName的系统角色
     * 
     * @param appId
     * @param roleName
     * @return
     */
    RoleInfo selectSystemRoleByAppIdAndRoleName(@Param("appId") String appId, @Param("roleName") String roleName);

    /**
     * 获取某应用用户createrId创建的系统角色<br>
     * 代理商的系统固定角色创建人ID为agent；终端客户的系统固定角色创建人ID为Client；
     * 
     * @param record
     * @return
     */
    List<RoleInfo> selectSystemRoleByCreaterId(RoleInfoVo record);
}