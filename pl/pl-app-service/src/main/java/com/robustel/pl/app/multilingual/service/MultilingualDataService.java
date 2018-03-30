package com.robustel.pl.app.multilingual.service;

import java.io.InputStream;
import java.util.Map;

/**
 * @Desc 系统多语言数据服务接口
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-05-03
 */
public interface MultilingualDataService {
    /**
     * 将某个应用的多语言数据转换成字节流
     * @param appId
     * @return
     */
    byte[] exportData(String appId);

    /**
     * 导入文件内容到数据库
     * @param muId 语种ID
     * @param fileName 上传的Excel文件名
     * @param fileIs 上传的Excel文件流
     * @return {add:11,update:12,ignore:11}
     */
    Map<String, Object> importData(String muId, String fileName, InputStream fileIs);
}
