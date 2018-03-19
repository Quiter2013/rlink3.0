package com.robustel.auth.client.rpc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 10:28 2018/3/19
 * Modified By:
 */
@Slf4j
@Data
public class RestTemplateService {
    private RestOperations restTemplate;
    private LoadBalancerClient loadBalancerClient;
    private String checkTokenEndpointUrl;
    private String clientId;
    private String clientSecret;
    private String tokenName = "token";
    private String authServiceName = "auth-server";

    public RestTemplateService(){
        restTemplate = new RestTemplate();
        ((RestTemplate)restTemplate).setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            // Ignore 400
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400) {
                    super.handleError(response);
                }
            }
        });
    }

    @Cacheable(value = "accessToken",key="#accessToken")
    public Map<String, Object> checkAccessToken(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", getAuthorizationHeader(clientId, clientSecret));

        ServiceInstance serviceInstance = loadBalancerClient.choose(authServiceName);
        if (serviceInstance == null) {
            throw new RuntimeException("Failed to choose an auth instance.");
        }
        String path = serviceInstance.getUri().toString() + checkTokenEndpointUrl;
        if (headers.getContentType() == null) {
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        }
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
        formData.add("token", accessToken);
        Map<String, Object> result = null;
        try{
             result = restTemplate.exchange(path, HttpMethod.POST,
                    new HttpEntity<MultiValueMap<String, String>>(formData, headers), Map.class).getBody();
        }catch(HttpClientErrorException e){
            if(HttpStatus.UNAUTHORIZED.equals(e.getStatusCode())){
                throw new InvalidTokenException("Token has expired");
            }
        }

       log.debug(String.format("将access_token:%s放入缓存中",formData.get("token")));
        return result;
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
