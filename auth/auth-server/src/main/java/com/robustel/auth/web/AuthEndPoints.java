package com.robustel.auth.web;

import com.robustel.auth.common.entity.Permission;
import com.robustel.auth.common.entity.UserAccess;
import com.robustel.auth.common.feign.FeignAuthClient;
import com.robustel.auth.security.userdetails.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 11:22 2018/3/8
 * Modified By:
 */
@RestController
public class AuthEndPoints implements FeignAuthClient {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public List<Permission> getUserPermissions(String userId) {
        return  customUserDetailsService.loadUserPermission(userId);
    }

    @Override
    public List<UserAccess> getUserAccessList(String userId) {
        return null;
    }
}
