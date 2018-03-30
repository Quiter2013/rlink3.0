package com.robustel.pl.app.role.service.impl;

import com.robustel.common.utils.UUIDUtil;
import com.robustel.pl.app.role.dao.RoleInfoMapper;
import com.robustel.pl.app.role.entity.RoleInfo;
import com.robustel.pl.app.role.service.RoleInfoService;
import com.robustel.pl.app.role.vo.RoleInfoVo;
import com.robustel.pl.app.user.dao.UserRoleMapper;
import com.robustel.pl.app.user.entity.UserRole;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {
    private static Logger logger = Logger.getLogger(RoleInfoServiceImpl.class);
    /**
     * 代理商系统角色创建人ID
     */
    private static final String AGENT_CREATER_ID = "Agent";
    /**
     * 终端客户系统角色创建人ID
     */
    private static final String CLIENT_CREATER_ID = "Client";

    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int relevanceFourFixRole2Agent(String userId, String appId) {
        logger.info("--------------- 关联四种代理商的角色：管理员、标准、浏览、受限 ----------------");
        // 返回结果
        int result = 0;
        // 1）获取代理商固定的系统角色列表；
        RoleInfoVo riv = new RoleInfoVo();
        riv.setAppId(appId);
        List<RoleInfo> roles = queryAgentRoles(riv);
        for (RoleInfo roleInfo : roles) {
            // 2）将userId和角色ID关联；
            UserRole ur = RoleInfoServiceImpl.assembleUserRole(userId, roleInfo);
            if (ur != null) {
                // 3）入库
                userRoleMapper.insert(ur);
                result++;
            }
        }
        return result;
    }

    @Override
    public int relevanceFourFixRole2Client(String userId, String appId) {
        logger.info("--------------- 关联四种终端客户的角色：管理员、标准、浏览、受限 ----------------");
        // 返回结果
        int result = 0;
        // 1）获取终端客户固定的系统角色列表；
        RoleInfoVo riv = new RoleInfoVo();
        riv.setAppId(appId);
        List<RoleInfo> roles = queryClientRoles(riv);
        for (RoleInfo roleInfo : roles) {
            // 2）将userId和角色ID关联；
            UserRole ur = RoleInfoServiceImpl.assembleUserRole(userId, roleInfo);
            if (ur != null) {
                // 3）入库
                userRoleMapper.insert(ur);
                result++;
            }
        }
        return result;
    }

    @Override
    public List<RoleInfo> queryAgentRoles(RoleInfoVo riv) {
        riv.setCreaterId(AGENT_CREATER_ID);
        return roleInfoMapper.selectSystemRoleByCreaterId(riv);
    }

    @Override
    public List<RoleInfo> queryClientRoles(RoleInfoVo riv) {
        riv.setCreaterId(CLIENT_CREATER_ID);
        return roleInfoMapper.selectSystemRoleByCreaterId(riv);
    }

    /**
     * 组装用户角色关联记录
     * 
     * @param userId
     * @param roleInfo
     * @return
     */
    private static UserRole assembleUserRole(String userId, RoleInfo roleInfo) {
        UserRole userRole = null;
        if (StringUtils.isNotBlank(userId) && roleInfo != null) {
            userRole = new UserRole();
            userRole.setUserRoleId(UUIDUtil.getKeys());
            userRole.setUserId(userId);
            userRole.setOperaterId(userId);
            userRole.setOperateTime(System.currentTimeMillis());
            userRole.setRoleId(roleInfo.getRoleId());
        }
        logger.info(String.format("组装完的用户角色关联信息为：%s", userId + "-" + roleInfo.getRoleId()));
        return userRole;
    }

}
