package com.robustel.common.utils;


import com.robustel.common.utils.convert.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;
import java.util.*;



public class ReflectUtil {
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

	private static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes) {
		for (Class<?> superClass = object.getClass(); 
				superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException e) {
				log.warn("", e);
			}
		}

		return null;
	}

	private static void makeAccessible(Field field) {
		if (!(Modifier.isPublic(field.getModifiers())))
			field.setAccessible(true);
	}

	@SuppressWarnings("rawtypes")
	private static Field getDeclaredField(Object object, String filedName) {
		for (Class superClass = object.getClass(); 
				superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {

				return superClass.getDeclaredField(filedName);
			} catch (NoSuchFieldException e) {
			}
		}
		return null;
	}

	public static Object invokeMethod(Object object, String methodName, 
			Class<?>[] parameterTypes, Object[] parameters) throws InvocationTargetException {
		Method method = getDeclaredMethod(object, methodName, parameterTypes);

		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName 
					+ "] on target [" + object + "]");
		}

		method.setAccessible(true);
		try {
			return method.invoke(object, parameters);
		} catch (IllegalAccessException e) {
			log.warn("", e);
		}

		return null;
	}

	public static void setFieldValue(Object object, String fieldName, Object value) {
		Field field = getDeclaredField(object, fieldName);

		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName 
					+ "] on target [" + object + "]");
		}

		makeAccessible(field);
		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			log.error("", e);
		}
	}

	public static Object getFieldValue(Object object, String fieldName) {

		Field field = getDeclaredField(object, fieldName);
		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName 
					+ "] on target [" + object + "]");
		}

		makeAccessible(field);

		Object result = null;
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			log.error("", e);
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getFieldValues(Collection<?> objects, Class<T> clazz, String fieldName) {
		List<T> result = new ArrayList<T>();
		for (Object obj : objects) {
			result.add((T) getFieldValue(obj, fieldName));
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> getFieldValues(Collection<?> objects, String fieldName) {
		List<T> result = new ArrayList<T>();
		for (Object obj : objects) {
			result.add((T) getFieldValue(obj, fieldName));
		}
		return result;
	}

	@SuppressWarnings({ "unchecked" })
	public static <T> T[] getFieldValuesA(Collection<?> objects, Class<T> clazz, String fieldName) {
		List<T> result = new ArrayList<T>();
		for (Object obj : objects) {
			result.add((T) getFieldValue(obj, fieldName));
		}
		Object o = Array.newInstance(clazz, result.size());
		return (T[]) result.toArray((Object[]) o);
	}

	@SuppressWarnings("rawtypes")
	public static void setBlankStringNull(Object object) {
		for (Class superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			Field[] fields = superClass.getDeclaredFields();
			for (Field field : fields) {
				if ((field.getType() != String.class) || (!("".equals(getFieldValue(object, field.getName())))))
					continue;
				setFieldValue(object, field.getName(), null);
			}
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Object> objectPropertyToMap(Object object) {
		Map rnt = new HashMap();
		for (Class superClass = object.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			Field[] fields = superClass.getDeclaredFields();
			for (Field field : fields) {
				rnt.put(field.getName(), getFieldValue(object, field.getName()));
			}
		}
		return rnt;
	}

	@SuppressWarnings("rawtypes")
	public static Object objectPropertyCopy(Object newObject, Object oldObject) {
		for (Class superClass = newObject.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			Field[] fields = superClass.getDeclaredFields();
			for (Field field : fields)
				if (!Modifier.isStatic(field.getModifiers())) {
					try {
						setFieldValue(newObject, field.getName(), getFieldValue(oldObject, field.getName()));
					} catch (Exception e) {
					}
				}
		}
		return newObject;
	}

	public static <T> List<T> clearListNull(List<T> rawList) {
		List<T> newList = new ArrayList<T>();
		for (T t : rawList) {
			if (t != null)
				newList.add(t);
		}
		return newList;
	}

	/**
	 *
	 *
	 * @name List转为Map (这里描述这个方法适用条件 – 可选)
	 * @param list
	 * @param keyName
	 *            作为Map key的字段，不可重复或为空
	 * @return
	 * @autor leicheng
	 * @time 2015年7月15日 上午10:21:46
	 * @update 2015年7月15日 上午10:21:46
	 *
	 */
	public static <T> Map<String, T> listToHashMap(Collection<T> list, String keyName) {
		Map<String, T> map = new HashMap<String, T>();
		for (T obj : list) {
			Object valueKey = getFieldValue(obj, keyName);
			if (valueKey == null || map.containsKey(valueKey)) {
				throw new RuntimeException("key异常");
			}
			map.put(valueKey.toString(), obj);
		}
		return map;
	}

	/**
	 *
	 *
	 * @name List转为Map (这里描述这个方法适用条件 – 可选)
	 * @param list
	 * @param keyName
	 *            作为Map key的字段，不可重复或为空
	 * @return
	 * @autor leicheng
	 * @time 2015年7月15日 上午10:21:46
	 * @update 2015年7月15日 上午10:21:46
	 *
	 */
	public static <T> Map<String, List<T>> listToListHashMap(List<T> list, String keyName) {
		Map<String, List<T>> map = new HashMap<>();
		for (T obj : list) {
			Object valueKey = getFieldValue(obj, keyName);
			List<T> sublist = map.get(valueKey);
			if (sublist == null) {
				sublist = new ArrayList<T>();
				map.put(valueKey.toString(), sublist);
			}
			sublist.add(obj);
		}
		return map;
	}

	public static Class<?> classForName(String className) {
		try {
			switch (className) {
			case "int":
				return Integer.TYPE;
			case "double":
				return Double.TYPE;
			case "short":
				return Short.TYPE;
			case "float":
				return Float.TYPE;
			case "char":
				return Character.TYPE;
			case "byte":
				return Byte.TYPE;
			case "long":
				return Long.TYPE;
			default:
				try {
					return Class.forName(className);
				} catch (ClassNotFoundException e) {
					if (!className.contains(".")) {
						return Class.forName("java.lang." + className);
					} else {
						throw e;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			return null;
		}
	}

	public static Class<?>[] classForNames(String[] classNames) {
		Class<?>[] result = new Class[classNames.length];
		for (int i = 0; i < classNames.length; i++) {
			String className = classNames[i];
			result[i] = classForName(className);
		}
		return result;
	}

}