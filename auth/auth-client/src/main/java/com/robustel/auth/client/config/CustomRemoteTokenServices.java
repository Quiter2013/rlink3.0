package com.robustel.auth.client.config;

import com.robustel.auth.client.context.UserContext;
import com.robustel.auth.client.rpc.RestTemplateService;
import com.robustel.auth.common.constants.AccessType;
import com.robustel.auth.common.constants.SecurityConstants;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Slf4j
@Data
public class CustomRemoteTokenServices implements ResourceServerTokenServices {
    private LoadBalancerClient loadBalancerClient;
    private String checkTokenEndpointUrl;
    private String clientId;
    private String clientSecret;
    private String tokenName = "token";
    private String authServiceName = "auth-server";
    private RestTemplateService restTemplateService;

    private AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        //解析token获取

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", getAuthorizationHeader(clientId, clientSecret));

        ServiceInstance serviceInstance = loadBalancerClient.choose(authServiceName);
        if (serviceInstance == null) {
            throw new RuntimeException("Failed to choose an auth instance.");
        }
        Map<String, Object> map = restTemplateService.postForMap(serviceInstance.getUri().toString() + checkTokenEndpointUrl, accessToken, headers);

        if (map.containsKey("error")) {
            log.debug("check_token returned error: " + map.get("error"));
            throw new InvalidTokenException(accessToken);
        }

        Assert.state(map.containsKey("client_id"), "Client id must be present in response from auth server");
        //TODO 将accesToken放入安全上下文中
        String user_id = map.get(SecurityConstants.USER_ID_IN_HEADER).toString();
        UserContext userContext = new UserContext(user_id);
        userContext.setAccessToken(accessToken);
        userContext.setAccessType(AccessType.ACCESS_TYPE_NORMAL);
        OAuth2Authentication oAuth2Authentication = tokenConverter.extractAuthentication(map);
        userContext.setAuthorities(oAuth2Authentication.getAuthorities());
        userContext.setAuthentication(oAuth2Authentication);
        SecurityContextHolder.setContext(userContext);
        //TODO 根据用户id查询权限列表
        return oAuth2Authentication;
    }

    @Override
    public OAuth2AccessToken readAccessToken(String accessToken) {
        throw new UnsupportedOperationException("Not supported: read access token");
    }

    private String getAuthorizationHeader(String clientId, String clientSecret) {
        String creds = String.format("%s:%s", clientId, clientSecret);
        try {
            return "Basic " + new String(Base64.encode(creds.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Could not convert String");
        }
    }

}
