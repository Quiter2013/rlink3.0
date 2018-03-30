package com.robustel.common.utils.convert;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;



import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc 实体类工具集
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-03-03
 */
public class EntityUtil {
	private static Logger logger = Logger.getLogger(EntityUtil.class);

	/**
	 * @Desc 将map转换成实体类
	 * @param params
	 * @param clazz
	 * @return
	 */
	public static Object map2Entity(Map<String, Object> params, Class<?> clazz) {
		Object obj = null;
		try {
			obj = clazz.newInstance();
			BeanUtils.populate(obj, params);
		} catch (InstantiationException e) {
			logger.info(e.getMessage());
		} catch (IllegalAccessException e) {
			logger.info(e.getMessage());
		} catch (InvocationTargetException e) {
			logger.info(e.getMessage());
		}
		return obj;
	}
	
	/**
	 * @Desc 将实体转换为map
	 * @param obj bean实例
	 * @return
	 */
	public static Map<String, String> entity2Map(Object obj){
		Map<String, String> result = new HashMap<String, String>();
		try {
			result = BeanUtils.describe(obj);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return result;
	}
}