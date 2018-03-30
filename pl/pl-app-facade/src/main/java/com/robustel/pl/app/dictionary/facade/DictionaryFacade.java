package com.robustel.pl.app.dictionary.facade;

import com.robustel.pl.app.dictionary.entity.Dictionary;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.List;

/**
 * @Desc 数据字典项业务操作接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
@FeignClient("app-manage")
public interface DictionaryFacade {

    List<Dictionary> queryDicListByGroupId(String dataDroupId);
    
    List<Dictionary> queryDictionaryByCode(String code);
}