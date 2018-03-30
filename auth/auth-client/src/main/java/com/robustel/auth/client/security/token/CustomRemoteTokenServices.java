package com.robustel.auth.client.security.token;

import com.robustel.auth.common.context.UserContext;
import com.robustel.auth.client.rpc.RestTemplateService;
import com.robustel.auth.common.constants.SecurityConstants;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.Assert;

import java.util.Map;

@Slf4j
@Data
public class CustomRemoteTokenServices implements ResourceServerTokenServices {
    private RestTemplateService restTemplateService;
    private AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        Map<String, Object> map = restTemplateService.checkAccessToken(accessToken);
        if (map.containsKey("error")) {
            log.debug("check_token returned error: " + map.get("error"));
            throw new InvalidTokenException(accessToken);
        }

        Assert.state(map.containsKey("client_id"), "Client id must be present in response from auth server");

        OAuth2Authentication oAuth2Authentication = tokenConverter.extractAuthentication(map);

        //构建用户上下文
        String user_id = map.get(SecurityConstants.USER_ID_IN_HEADER).toString();
        UserContext userContext = new UserContext(user_id);
        userContext.setAccessToken(accessToken);
        userContext.setAuthorities(oAuth2Authentication.getAuthorities());
        userContext.setAuthentication(oAuth2Authentication);

        //将用户上下文设置安全上下文中
        SecurityContextHolder.setContext(userContext);
        return oAuth2Authentication;
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }



}
