package com.robustel.common.web.controller;

import com.github.pagehelper.PageHelper;
import com.robustel.auth.common.context.UserContext;
import com.robustel.common.core.service.BaseService;
import com.robustel.common.web.vo.RtPageResponse;
import com.robustel.common.web.vo.RtResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

/**
 * Controller的基类，处理异常，公共方法
 * @author gaolinlou
 * @created 2018年3月27日 下午7:19:14
 * @updated 
 * @param 
 */
public abstract class BaseController<E extends  BaseService<T>,T> {
	protected Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	protected  E service;

	/**
	 * 通用列表查询
	 * @param selectOption 查询参数
	 * @param pageSize 页大小
	 * @param pageNum  页码
	 * @return
	 */
	@RequestMapping("/list")
	protected RtResponse<List<T>> list(HttpServletRequest request, T selectOption,
									   @RequestParam(value = "pageSize",required = false) Integer pageSize,
									   @RequestParam(value = "pageNum",required = false) Integer pageNum){
		if(pageNum != null && pageSize != null){
			PageHelper.startPage(pageNum, pageSize);
		}
		List<T> result = service.selectList(selectOption);
		return RtPageResponse.successPage(result);
	}

	/**
	 * 通用更新操作
	 * 注意body中需要包含主键
	 * @param entity
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	public RtResponse modify(HttpServletRequest request,@RequestBody T entity,@PathVariable("id")String id){
		service.updateById(entity);
		return RtResponse.success();
	}

	/**
	 * 通用查询明细操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public RtResponse<T> cat(HttpServletRequest request,@PathVariable("id") String id){
		T t = service.selectById(id);
		return RtResponse.success(t);
	}

	/**
	 * 通用新增操作
	 * @param entity
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public RtResponse<T> add(HttpServletRequest request,@RequestBody T entity) {
		Class<?> c = entity.getClass();
		Field[] fields = c.getDeclaredFields();
		for(Field field : fields){
			try {
				field.setAccessible(true);
				if (field.isAnnotationPresent(Id.class)) {
					field.set(entity, UUID.randomUUID().toString().replaceAll("-", ""));
				}
				String name = field.getName();
				SecurityContext context = SecurityContextHolder.getContext();
				if (context instanceof UserContext){
					UserContext userContext = (UserContext)context;
					String userId = userContext.getUserId();
					String username = userContext.getUsername();
					Object value = field.get(entity);
					if("createUserId".equals(name) &&  value != null){
						 field.set(entity,userId);
					}
					if( "creater".equals(name) && value != null){
						field.set(entity, username);
					}
				}
				if("createTime".equals(name)){
					field.set(entity, System.currentTimeMillis());
				}
			}catch (IllegalAccessException e) {
				log.error("设置用户信息失败！");
			}

		}
		service.insert(entity);
		return RtResponse.success(entity);

	}

	/**
	 * 通用删除操作
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public RtResponse del(HttpServletRequest request,@PathVariable String id){
		service.deleteById(id);
		return RtResponse.success();
	}
}