package com.robustel.auth.client.rpc;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 19:04 2018/3/16
 * Modified By:
 */
public class RemoteRestTemplate {
    private static RemoteRestTemplate remoteRestTemplate;
    private  RestOperations restTemplate ;

    private  RemoteRestTemplate(){
    }

    public static RemoteRestTemplate getInstance(){
        if(remoteRestTemplate == null){
            remoteRestTemplate = new RemoteRestTemplate();
             RestTemplate rest = new RestTemplate();
             rest.setErrorHandler(new DefaultResponseErrorHandler() {
                @Override
                // Ignore 400
                public void handleError(ClientHttpResponse response) throws IOException {
                    if (response.getRawStatusCode() != 400) {
                        super.handleError(response);
                    }
                }
            });
            remoteRestTemplate.restTemplate = rest;
        }
        return remoteRestTemplate;
    }


    @Cacheable(value = "check_token", key = "#formData.token", sync = true)
    public Map<String, Object> postForMap(String path, MultiValueMap<String, String> formData, HttpHeaders headers) {
        if (headers.getContentType() == null) {
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        }

        @SuppressWarnings("rawtypes")
        Map map = restTemplate.exchange(path, HttpMethod.POST,
                new HttpEntity<MultiValueMap<String, String>>(formData, headers), Map.class).getBody();
        Map<String, Object> result = map;
        System.out.println(String.format("将access_token:%s放入缓存中",formData.get("token")));
        return result;
    }
}
