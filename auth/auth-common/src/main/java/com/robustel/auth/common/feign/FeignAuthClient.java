package com.robustel.auth.common.feign;

import com.robustel.auth.common.entity.Permission;
import com.robustel.auth.common.entity.UserAccess;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author keets
 * @date 2017/11/21
 */
@FeignClient(name = "auth")
public interface FeignAuthClient {

    @RequestMapping(method = RequestMethod.GET, value = "/oauth/userPermissions?userId={userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Permission> getUserPermissions(@RequestParam("userId") String userId);

    @RequestMapping(method = RequestMethod.GET, value = "/oauth/userAccesses?userId={userId}",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserAccess> getUserAccessList(@RequestParam("userId") String userId);
}
