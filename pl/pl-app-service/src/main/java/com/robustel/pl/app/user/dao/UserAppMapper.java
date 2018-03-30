package com.robustel.pl.app.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.robustel.pl.app.management.vo.AppUserVo;
import com.robustel.pl.app.user.entity.UserApp;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Desc 用户应用操作接口类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
public interface UserAppMapper extends Mapper<UserApp>{
    /**
     * 获取某用户关联的应用列表信息
     * @param userId
     * @return
     */
    List<AppUserVo> apps2User(@Param("userId") String userId);

    /**
     * 根据userId和appId获取关联记录
     * 
     * @param userId
     * @param appId
     * @return
     */
    UserApp queryByUserIdAndAppId(@Param("userId") String userId, @Param("appId") String appId);

    /**
     * 获取某用户已关联的默认应用记录<br>
     * 如果pid不为空，则为查询除当前关联以外是否存在默认应用
     * 
     * @param userId
     * @param pid 可以为空
     * @return
     */
    UserApp queryDefaultAppByUserId(@Param("userId") String userId, @Param("pid") String pid);

    /**
     * 取消某用户的默认应用
     * 
     * @param userId
     * @return
     */
    int updateIsDefaultByUserId(@Param("userId") String userId);

    /**
     * 取消用户userId和应用的关联关系
     * 
     * @param userId
     * @return
     */
    int deleteByUserId(@Param("userId") String userId);
}