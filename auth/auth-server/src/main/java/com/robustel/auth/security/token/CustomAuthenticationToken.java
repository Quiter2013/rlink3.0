package com.robustel.auth.security.token;

import com.robustel.auth.security.userdetails.CustomUserDetails;
import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @Author: gaolinlou
 * Description: 自定义认证Token
 * Date: Created in 16:23 2018/3/6
 * Modified By:
 */
public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private CustomUserDetails userDetails;

    public CustomAuthenticationToken(CustomUserDetails userDetails) {
        super(null);
        this.userDetails = userDetails;
        super.setAuthenticated(true);
    }

    public Object getPrincipal() {
        return this.userDetails;
    }

    public Object getCredentials() {
        return this.userDetails.getPassword();
    }

}