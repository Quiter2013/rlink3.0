package com.robustel.common.cache.redis.properties;

import lombok.Data;

import java.util.Map;

/**
 * @Author: gaolinlou
 * Description:
 * Date: Created in 14:22 2018/3/16
 * Modified By:
 */
@Data
public class RedisCacheProperties {
    private  boolean enable;
    private Map<String,Long> expires;
}
