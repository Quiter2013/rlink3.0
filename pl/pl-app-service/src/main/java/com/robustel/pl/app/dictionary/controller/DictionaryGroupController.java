package com.robustel.pl.app.dictionary.controller;

import com.github.pagehelper.PageHelper;
import com.robustel.common.web.controller.BaseController;
import com.robustel.common.web.vo.RtResponse;
import com.robustel.common.web.vo.TokenVo;
import com.robustel.pl.app.dictionary.entity.DictionaryGroup;
import com.robustel.pl.app.dictionary.facade.DictionaryGroupFacade;
import com.robustel.pl.app.dictionary.service.DictionaryGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Desc 业务处理接口实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
@Api(tags = {"字典分组管理"})
@RestController
@RequestMapping("/dictionaryGroup")
public class DictionaryGroupController extends BaseController<DictionaryGroupService,DictionaryGroup>implements DictionaryGroupFacade {

   /* @ApiOperation(value="添加字典分组",notes="字典分组代码不重复")
    @RequestMapping(method= RequestMethod.POST)
    @Override
    public RtResponse<DictionaryGroup> add(HttpServletRequest request, @RequestBody DictionaryGroup entity){
        TokenVo tv = new TokenVo();
        entity.setCreater(tv.getUserName());
        entity.setCreateUserId(tv.getUserId());
        entity.setCreateTime(System.currentTimeMillis());
        service.insert(entity);
        return RtResponse.success(entity);

    }*/

    @ApiOperation(value="获取用户级别字典项列表",notes="可根据字典分组ID或字典分组的code获取")
    @GetMapping("/dicList")
    public RtResponse queryDicList2Group(DictionaryGroup dictionaryGroup,
                                         @RequestParam(value = "pageSize" ,required = false) Integer pageSize,
                                         @RequestParam(value = "pageNum" ,required = false) Integer pageNum) {
        if(pageNum != null && pageSize != null){
            PageHelper.startPage(pageNum,pageSize);
        }
        // 由于查询的是系统列表，所以分组的等级应该是用户级，即：dicLevel为1
        dictionaryGroup.setDicLevel("1");
        List<Map<String, Object>> list = service.queryDicList2Group(dictionaryGroup);


        return RtResponse.success(list);
    }


    @ApiOperation(value="获取某应用的某个分组的数字字典项列表",notes="在指定应用下根据分组名或分组代码获取分组信息")
    @GetMapping("/groupinfo")
    public RtResponse queryDgByNameOrCodeInApp(@RequestParam(value = "name" ,required = false) String name,
                                               @RequestParam(value = "code" ,required = false) String code,
                                               @RequestParam(value = "appId" ,required = false) String appId) {
        DictionaryGroup dictionaryGroup = service.queryDgByNameOrCodeInApp(appId, name, code);
        return RtResponse.success(dictionaryGroup);
    }

}
