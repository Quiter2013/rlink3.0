package com.robustel.common.utils;

import java.util.UUID;

/**
 * @Desc 用于生成主键
 * @author HanZhijun
 * @version 1.0.0
 * @since 2017-02-23
 */
public class UUIDUtil {

	/**
	 * 获取随机生成的32位主键
	 * @return
	 */
	public static String getKeys(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replace("-", "");
	}
}