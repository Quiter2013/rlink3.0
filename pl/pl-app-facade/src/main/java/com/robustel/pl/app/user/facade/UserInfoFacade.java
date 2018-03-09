package com.robustel.pl.app.user.facade;

import com.robustel.common.web.vo.RtResponse;
import com.robustel.pl.app.user.entity.UserInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "app-manage")
public interface UserInfoFacade {
    /**
     * 根据主键删除记录
     * @param userId 主键 
     * @return
     */
    @RequestMapping(value = "/user/{userId}" ,method = RequestMethod.DELETE)
    @ResponseBody
    RtResponse<UserInfo> deleteByPrimaryKey(String userId);

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    RtResponse<UserInfo> addUser (@RequestBody UserInfo userInfo);



    /**
     * 根据主键获取记录
     * @param userId
     * @return
     */
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    @ResponseBody
    RtResponse<UserInfo> selectByPrimaryKey(@PathVariable("userId") String userId);

    /**
     * 更新记录（更新非空字段）
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @ResponseBody
    RtResponse<UserInfo> updateByPrimaryKeySelective(@RequestBody UserInfo userInfo);
}
