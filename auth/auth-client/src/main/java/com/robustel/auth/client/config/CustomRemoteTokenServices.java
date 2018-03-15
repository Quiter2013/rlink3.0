package com.robustel.auth.client.config;

import com.robustel.auth.client.context.UserContext;
import com.robustel.auth.common.constants.AccessType;
import com.robustel.auth.common.constants.SecurityConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import java.util.HashMap;
import java.util.Map;


public class CustomRemoteTokenServices implements ResourceServerTokenServices {
    protected final Log logger = LogFactory.getLog(getClass());
    private LoadBalancerClient loadBalancerClient;
    private RestOperations restTemplate;
    private String checkTokenEndpointUrl;
    private String clientId;
    private String clientSecret;
    private String tokenName = "token";
    private String authServiceName = "auth-server";

    private AccessTokenConverter tokenConverter = new DefaultAccessTokenConverter();

    public CustomRemoteTokenServices() {
        restTemplate = new RestTemplate();
        ((RestTemplate) restTemplate).setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            // Ignore 400
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400) {
                    super.handleError(response);
                }
            }
        });
    }

    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setCheckTokenEndpointUrl(String checkTokenEndpointUrl) {
        this.checkTokenEndpointUrl = checkTokenEndpointUrl;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setAccessTokenConverter(AccessTokenConverter accessTokenConverter) {
        this.tokenConverter = accessTokenConverter;
    }

    public void setLoadBalancerClient(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    @Override
    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {
        //解析token获取
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
        formData.add(tokenName, accessToken);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", getAuthorizationHeader(clientId, clientSecret));

        ServiceInstance serviceInstance = loadBalancerClient.choose(authServiceName);
        if (serviceInstance == null) {
            throw new RuntimeException("Failed to choose an auth instance.");
        }

        Map<String, Object> map = postForMap(serviceInstance.getUri().toString() + checkTokenEndpointUrl, formData, headers);

        if (map.containsKey("error")) {
            logger.debug("check_token returned error: " + map.get("error"));
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

    public String getAuthServiceName() {
        return authServiceName;
    }

    public void setAuthServiceName(String authServiceName) {
        this.authServiceName = authServiceName;
    }

    public String getCheckTokenEndpointUrl() {
        return checkTokenEndpointUrl;
    }

    public LoadBalancerClient getLoadBalancerClient() {
        return loadBalancerClient;
    }

    public RestOperations getRestTemplate() {
        return restTemplate;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getTokenName() {
        return tokenName;
    }

    public AccessTokenConverter getTokenConverter() {
        return tokenConverter;
    }

    public void setTokenConverter(AccessTokenConverter tokenConverter) {
        this.tokenConverter = tokenConverter;
    }

    private String getAuthorizationHeader(String clientId, String clientSecret) {
        String creds = String.format("%s:%s", clientId, clientSecret);
        try {
            return "Basic " + new String(Base64.encode(creds.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Could not convert String");
        }
    }

    private Map<String, Object> postForMap(String path, MultiValueMap<String, String> formData, HttpHeaders headers) {
        if (headers.getContentType() == null) {
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        }
        Map<String, Object> result = new HashMap<>();
        //TODO 先从缓存获取数据

        @SuppressWarnings("rawtypes")
        Map map = restTemplate.exchange(path, HttpMethod.POST,
                new HttpEntity<MultiValueMap<String, String>>(formData, headers), Map.class).getBody();
        result = map;
        return result;
    }

}
