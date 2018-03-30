package com.robustel.pl.app.user.service.impl;

import com.robustel.common.core.service.impl.BaseServiceImpl;
import com.robustel.pl.app.user.dao.UserRoleMapper;
import com.robustel.pl.app.user.entity.UserRole;
import com.robustel.pl.app.user.service.UserRoleService;
import com.robustel.pl.app.user.vo.UserRoleVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 14:57 2018/3/28
 * Modified By:
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper,UserRole> implements UserRoleService {
    @Override
    public List<UserRoleVo> queryList(String userId, String appId) {
        return mapper.queryList(userId,appId);
    }

    @Override
    public List<UserRoleVo> queryNoDistributedRolesInApp(String userId, String appId, String createrId) {
        return mapper.queryNoDistributedRolesInApp(userId,appId,createrId);
    }

    @Override
    public List<UserRoleVo> queryNoDistributedRolesInRootGroup(String userId, String rootGroupId) {
        return mapper.queryNoDistributedRolesInRootGroup(userId,rootGroupId);
    }

    @Override
    public List<UserRoleVo> queryDistributedRoles2Business(String userId, String appId, String keyword, String createrId) {
        return mapper.queryDistributedRoles2Business(userId,appId,keyword,createrId);
    }

    @Override
    public List<UserRoleVo> queryNoDistributedRoles2Business(String userId, String appId, String createrId) {
        return mapper.queryNoDistributedRoles2Business(userId,appId,createrId);
    }

    @Override
    public void deleteByUserId(String userId) {
        mapper.deleteByUserId(userId);
    }

    @Override
    public List<UserRoleVo> queryNoDistributedRoles2BusinessAndApps(String userId, Set<String> appIds, String createrId) {
        return mapper.queryNoDistributedRoles2BusinessAndApps(userId,appIds,createrId);
    }
}
