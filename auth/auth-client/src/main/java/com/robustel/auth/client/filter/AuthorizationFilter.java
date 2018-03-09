package com.robustel.auth.client.filter;

import com.robustel.auth.client.security.CustomAuthentication;
import com.robustel.auth.client.security.SimpleGrantedAuthority;
import com.robustel.auth.common.constants.AccessType;
import com.robustel.auth.common.constants.SecurityConstants;
import com.robustel.auth.common.entity.Permission;
import com.robustel.auth.common.feign.FeignAuthClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author keets
 */
public class AuthorizationFilter implements Filter {

    @Autowired
    private FeignAuthClient feignAuthClient;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器正在执行...");
        // pass the request along the filter chain
        String userId = ((HttpServletRequest) servletRequest).getHeader(SecurityConstants.USER_ID_IN_HEADER);

        if (StringUtils.isNotEmpty(userId)) {
            UserContext userContext = new UserContext(UUID.fromString(userId));
            userContext.setAccessType(AccessType.ACCESS_TYPE_NORMAL);
            //TODO 先查缓存查找，没有再调用认证鉴权服务
            List<Permission> permissionList = feignAuthClient.getUserPermissions(userId);
            List<SimpleGrantedAuthority> authorityList = new ArrayList();
            for (Permission permission : permissionList) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority();
                authority.setAuthority(permission.getPermission());
                authorityList.add(authority);
            }

            CustomAuthentication userAuth  = new CustomAuthentication();
            userAuth.setAuthorities(authorityList);
            userContext.setAuthorities(authorityList);
            userContext.setAuthentication(userAuth);
            SecurityContextHolder.setContext(userContext);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
