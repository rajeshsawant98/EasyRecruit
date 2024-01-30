package jsonpath.implementation;

import java.math.BigDecimal;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


public final class Utils {
	
	private static final Configuration config = Configuration.defaultConfiguration()
			.addOptions(Option.ALWAYS_RETURN_LIST);
	
	private static final JSONArray queryJSONString(String json, String path) {
		JSONArray results = JsonPath.using(Utils.config)
				.parse(json)
				.read(path, JSONArray.class);
		return results;
	}
	
	public static final Boolean queryJSONStringForBoolean(String json, String path) {
		JSONArray results = Utils.queryJSONString(json, path);
		if (!results.isEmpty()) {
			Object firstResult = results.get(0);
			if (firstResult instanceof Boolean) {
				return (Boolean) firstResult;
			} else { return null; }
		} else { return null; }
	}
	
	public static final String queryJSONStringForString(String json, String path) {
		JSONArray results = Utils.queryJSONString(json, path);
		if (!results.isEmpty()) {
			Object firstResult = results.get(0);
			if (firstResult instanceof String) {
				return (String) firstResult;
			} else { return null; }
		} else { return null; }
	}
	
	public static final Number queryJSONStringForInteger(String json, String path) {
		JSONArray results = Utils.queryJSONString(json, path);
		if (!results.isEmpty()) {
			Object firstResult = results.get(0);
			if (firstResult instanceof Number) {
				return (Number) firstResult;
			} else { return null; }
		} else { return null; }
	}
	
	public static final BigDecimal queryJSONStringForDecimal(String json, String path) {
		JSONArray results = Utils.queryJSONString(json, path);
		if (!results.isEmpty()) {
			Object firstResult = results.get(0);
			if (firstResult instanceof Double) {
				return BigDecimal.valueOf((Double) firstResult);
			} else { return null; }
		} else { return null; }
	}
	
	@SuppressWarnings("unchecked")
	public static final String queryJSONStringForObject(String json, String path) {
		Object results = JsonPath.using(Utils.config)
				.parse(json)
				.read(path, JSONObject.class);
		final List<Object> objList = (List<Object>)(List<?>) results;
		if (!objList.isEmpty()) {
			Object firstResult = objList.get(0);
			if (firstResult instanceof JSONObject) {
				return ((JSONObject) firstResult).toJSONString();
			} else { return null; }
		} else { return null; }
	}
	
	public static final String queryJSONStringForArray(String json, String path) {
		JSONArray results = Utils.queryJSONString(json, path);
		return results.toJSONString();
	}
}
