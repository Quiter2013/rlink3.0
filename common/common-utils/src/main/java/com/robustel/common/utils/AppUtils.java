package com.robustel.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.CRC32;

/**
 * 公共帮助 util类
 * 
 * @author jingfangnan
 *
 */
public class AppUtils {

	/**
	 * Checks if is blank.
	 * 
	 * @param str
	 *            the str
	 * @return true, if is blank
	 */
	public static boolean isBlank(final String str) {
		return (str == null) || (str.trim().length() <= 0);
	}

	/**
	 * Checks if is not blank.
	 * 
	 * @param str
	 *            the str
	 * @return true, if is not blank
	 */
	public static boolean isNotBlank(final String str) {
		return !(isBlank(str));
	}

	/**
	 * Checks if is blank.
	 * 
	 * @param objs
	 *            the objs
	 * @return true, if is blank
	 */
	public static boolean isBlank(final Object[] objs) {
		return (objs == null) || (objs.length <= 0);
	}

	/**
	 * Checks if is not blank.
	 * 
	 * @param objs
	 *            the objs
	 * @return true, if is not blank
	 */
	public static boolean isNotBlank(final Object[] objs) {
		return !(isBlank(objs));
	}

	/**
	 * Checks if is blank.
	 * 
	 * @param objs
	 *            the objs
	 * @return true, if is blank
	 */
	public static boolean isBlank(final Object objs) {
		return (objs == null) || "".equals(objs)||objs.toString().trim().length()<=0;
	}

	/**
	 * Checks if is not blank.
	 * 
	 * @param objs
	 *            the objs
	 * @return true, if is not blank
	 */
	public static boolean isNotBlank(final Object objs) {
		return !(isBlank(objs));
	}

	/**
	 * Checks if is blank.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if is blank
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(final Collection obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	/**
	 * Checks if is not blank.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if is not blank
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotBlank(final Collection obj) {
		return !(isBlank(obj));
	}

	/**
	 * Checks if is blank.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if is blank
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(final Set obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	/**
	 * Checks if is not blank.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if is not blank
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotBlank(final Set obj) {
		return !(isBlank(obj));
	}

	/**
	 * Checks if is blank.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if is blank
	 */
	public static boolean isBlank(final Serializable obj) {
		return obj == null;
	}

	/**
	 * Checks if is not blank.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if is not blank
	 */
	public static boolean isNotBlank(final Serializable obj) {
		return !(isBlank(obj));
	}

	/**
	 * Checks if is blank.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if is blank
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(final Map obj) {
		return (obj == null) || (obj.size() <= 0);
	}

	/**
	 * Checks if is not blank.
	 * @param obj the obj
	 * @return true, if is not blank
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotBlank(final Map obj) {
		return !(isBlank(obj));
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNumber(final Object obj) {
		boolean res = false;
		if (obj instanceof Number) {
			res = true;
		}
		return res;
	}

	/**
	 * <p>
	 * String representation of a calendar. Format: MM/DD/YYYY
	 * </p>
	 * 
	 * @param date
	 *            the calendar
	 * @return String
	 */
	public static String getDisplayDate(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		if (date != null)
			return format.format(date);
		else
			return "";
	}

	/**
	 * 对象拷贝时 忽略空值
	 * 
	 * @param source
	 * @return
	 */
	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	/**
	 * 忽略空值 进行对象值拷贝
	 * 
	 * @param src
	 *            源对象
	 * @param target
	 *            目标对象
	 */
	public static void copyPropertiesIgnoreNull(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}
	
	/**
	 * <p>
	 * CRC32 value on the key String value
	 * </p>
	 * 
	 * @param value
	 *            the key
	 * @return Long
	 */
	public static Long getCRC32(String value) {
		CRC32 crc32 = new CRC32();
		crc32.update(value.getBytes());
		return crc32.getValue();
	}
	
	public static Float formatFloatData(Float data){
		if(isBlank(data)){
			return null;
		}
		return data/1024/1024;
	}
	
	public static Integer powMathValue(Integer m){
		if(isBlank(m)){
			return null;
		}
		int i;
	    for( i=0;i<32;i++){
	    	if(1<<i==m)
	  	      break;
	    }
	    return i;
	}
}
