package com.robustel.pl.app.dictionary.controller;

import com.robustel.common.web.controller.BaseController;
import com.robustel.common.web.vo.RtResponse;
import com.robustel.pl.app.dictionary.entity.Dictionary;
import com.robustel.pl.app.dictionary.facade.DictionaryFacade;
import com.robustel.pl.app.dictionary.service.DictionaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Desc 业务处理接口实现类
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
@Api(tags = {"字典管理"})
@RestController
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController<DictionaryService,Dictionary> implements DictionaryFacade {

    @ApiOperation(value="删除字典分组",notes="根据数据字典分组ID删除指定分组下的所有数据项")
    @DeleteMapping("/dicGroup/{dicGpId}")
    public RtResponse deleteByDictionaryGroupId(@PathVariable("dicGpId") String dicGpId ) {
        service.deleteByDictionaryGroupId(dicGpId);
        return RtResponse.success();
    }


    @ApiOperation(value="查询字典分组的字典列表",notes="根据字典分组ID进行查询")
    @GetMapping("/dicGroup/{dicGpId}")
    @Override
    public List<Dictionary> queryDicListByGroupId(String dataDroupId) {
        return service.queryDicListByGroupId(dataDroupId);
    }


    @ApiOperation(value="多条件查询字典项",notes="在某分组中根据字典项名或字典项代码查询记录")
    @GetMapping()
    public RtResponse<Dictionary> queryDicByNameOrCodeInGp(
            @RequestParam(value = "dicGpId",required = false) String dicGpId,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "code") String code) {
        Dictionary dic = service.queryDicByNameOrCodeInGp(dicGpId, name, code);
        return RtResponse.success(dic);
    }

    @ApiOperation(value="通过分组代码查询",notes="后端调用，前端不使用此接口")
    @GetMapping("/code/{code}")
    @Override
	public List<Dictionary> queryDictionaryByCode(@PathVariable("code") String code) {
        return service.queryDictionaryByCode(code);
	}

}
