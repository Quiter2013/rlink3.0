package com.robustel.common.utils.convert;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.robustel.common.utils.exception.JsonConvertException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonUtil {
	private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);

	private static ObjectMapper mapper = new ObjectMapper();

	public static String javaObjToJson(Object obj, DateFormat dateFormat) {
		String jsonStr = "";
		try {
			if (null != dateFormat) {
				mapper.setDateFormat(dateFormat);
			}
			jsonStr = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.error("", e);
		}
		return jsonStr;
	}

	public static String javaObjToJson(Object obj) {
		return javaObjToJson(obj, null);
	}

	public static JsonNode strTojsonNode(String jsonStr) {
		JsonNode json = null;
		try {
			json = (JsonNode) mapper.readValue(jsonStr, JsonNode.class);
		} catch (Exception e) {
			log.error("json字符串转换成json对象出错！", e);
		}
		return json;
	}

	public static <T> T jsonStrToOjb(String jsonStr, Class<T> t) throws JsonConvertException {
		try {
			return mapper.readValue(jsonStr, t);
		} catch (Exception e) {
			throw new JsonConvertException("json字符串转换对象出错");
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonStrToList(String jsonStr, Class<T> t) {
		try {
			JavaType javaType = getCollectionType(ArrayList.class, new Class[] { t });
			return ((List<T>) mapper.readValue(jsonStr, javaType));
		} catch (Exception e) {
			log.error("json字符串转换成json对象出错！", e);
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("deprecation")
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>[] elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T jsonStrToObj(String jsonStr, Class<T> targetClass, Map<String, Class> classMap) {
		return (T) JSONObject.toBean(JSONObject.fromObject(jsonStr), targetClass, classMap);
	}

	@SuppressWarnings("rawtypes")
	public static HashMap<String, String> toHashMap(Object object) {
		HashMap<String, String> data;
		try {
			data = new HashMap<String, String>();
			JSONObject jsonObject = JSONObject.fromObject(object);
			Iterator it = jsonObject.keys();
			while (it.hasNext()) {
				String key = String.valueOf(it.next());
				String value = jsonObject.get(key).toString();
				data.put(key, value);
			}
			return data;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static HashMap<String, Object> obj2HashMap(Object object) {
		HashMap<String, Object> data;
		try {
			data = new HashMap<String, Object>();
			JSONObject jsonObject = JSONObject.fromObject(object);
			Iterator it = jsonObject.keys();
			while (it.hasNext()) {
				String key = String.valueOf(it.next());
				Object value = jsonObject.get(key)==null?null:jsonObject.get(key);
				data.put(key, value);
			}
			return data;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}


}