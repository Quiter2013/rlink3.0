package com.robustel.config.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 11:56 2018/4/3
 * Modified By:
 */
@RestController
@RequestMapping("/config")
public class ConfigCenterController {
    @Autowired
    private EurekaClient client;


    @RequestMapping(value="/instances",method = RequestMethod.GET)
    public  Applications getAllInstance() {
        InstanceInfo info = client.getApplicationInfoManager().getInfo();
        Applications applications = client.getApplications();
        return applications;
    }

    @RequestMapping(value="/allInstance",method = RequestMethod.GET)
    public  Map<String, Object> getAllEurekaInstance() {
        InstanceInfo info = client.getApplicationInfoManager().getInfo();
        Applications applications = client.getApplications();
        Application app = applications.getRegisteredApplications("CONFIG-SERVER");
        InstanceInfo instance = app.getByInstanceId("172.16.14.86:9781");
        String statusPageUrl = instance.getStatusPageUrl();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            // Ignore 400
            public void handleError(ClientHttpResponse response) throws IOException {
                if (response.getRawStatusCode() != 400) {
                    super.handleError(response);
                }
            }
        });
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "123454");
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<String, String>();
        formData.add("token", "123455");
        Map<String, Object> result = null;
        try{
            result = restTemplate.exchange(statusPageUrl, HttpMethod.GET,
                    new HttpEntity<MultiValueMap<String, String>>(formData, headers), Map.class).getBody();
        }catch(HttpClientErrorException e){
            if(HttpStatus.UNAUTHORIZED.equals(e.getStatusCode())){
                System.out.println("Token has expired");
            }
        }
        System.out.println(info);
        return result;
    }
}
