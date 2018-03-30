package com.robustel.pl.app.user.controller;

import com.github.pagehelper.PageHelper;
import com.robustel.common.web.controller.BaseController;
import com.robustel.common.web.vo.RtPageResponse;
import com.robustel.common.web.vo.RtResponse;
import com.robustel.pl.app.management.vo.AppUserVo;
import com.robustel.pl.app.user.entity.UserApp;
import com.robustel.pl.app.user.service.UserAppService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Desc 用户应用关联业务处理接口实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-28
 */
@Api(tags = {"用户应用管理"})
@RestController
@RequestMapping("/userapp")
public class UserAppController extends BaseController<UserAppService,UserApp> {
    /**
     * 获取某用户关联的应用列表信息
     * @param userId
     * @return
     */
    @ApiOperation( value ="获取某用户关联的应用列表信息",notes = "")
    @GetMapping("/user/{userId}")
    public RtPageResponse<List<AppUserVo>> apps2User(@PathVariable("userId") String userId,
                                                     @RequestParam(value = "pageSize" ,required = false) Integer pageSize,
                                                     @RequestParam(value = "pageNum" ,required = false) Integer pageNum) {
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        List<AppUserVo> list = service.apps2User(userId);
        return RtPageResponse.successPage(list);
    }

}
