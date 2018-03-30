package com.robustel.pl.app.management.facade;

/**
 * @Desc 业务处理类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-22
 */
public interface AppMangeFacade {

    /**
     * 根据AppCode获取AppId，只限后端调用
     * @param appCode
     * @return
     */
    String queryAppIdByAppCode(String appCode);
}
