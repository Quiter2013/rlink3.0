package com.robustel.common.cache.redis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 14:22 2018/3/16
 * Modified By:
 */
public class RedisCacheProperties {
    private Map<String,Long> expires;

    public Map<String, Long> getExpires() {
        return expires;
    }

    public void setExpires(Map<String, Long> expires) {
        this.expires = expires;
    }
}
