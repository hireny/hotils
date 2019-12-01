package me.hireny.commons.json.style;

import me.hireny.commons.json.exception.JsonTypeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JSON对象
 * 对象是键(key)-值(value)对形式的无序集合。
 * 一个对象以"{"(左括号)开始，"}"(右括号)结束。
 * 值之间使用","(逗号)分隔。
 * @Author: hireny
 * @Date: Create in 2019/07/16 21:08
 */
public class JsonObject extends JsonElement implements JsonValue {

    private Map<String,Object> map;

    private JsonObject() {}

    public JsonObject(Map<String, Object> map) {
        this.map = map;
    }

    /**
     * 添加键为key，值为value的键值对
     * @param key
     * @param value
     * @return
     */
    public Object put(String key, Object value) {
        return map.put(key, value);
    }

    /**
     * 获取键为key的对象
     * @param key
     * @return
     */
    public Object get(String key) {
        return map.get(key);
    }

    /**
     * 获取所有键值对
     * @return
     */
    public List<Map.Entry<String, Object>> getAllKeyValues() {
        return new ArrayList<>(map.entrySet());
    }

    /**
     * 获取键为key的JsonObject对象
     * @param key
     * @return
     */
    public JsonObject getJsonObject(String key) throws JsonTypeException {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Invalid key");
        }

        Object o = map.get(key);
        if (!(o instanceof JsonObject)) {
            throw new JsonTypeException("Type of value is not JsonObject.(该值的类型不是JsonObject类型)");
        }
        return (JsonObject) o;
    }

    /**
     * 获取键为key的JsonArray对象
     * @param key
     * @return
     */
    public JsonArray getJsonArray(String key) throws JsonTypeException {
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("Invalid key");
        }

        Object o = map.get(key);
        if (!(o instanceof JsonArray)) {
            throw new JsonTypeException("Type of value is not JsonArray.(该值的类型不是JsonArray类型)");
        }
        return (JsonArray) o;
    }

    @Override
    public String toString() {
        return map.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T toJsonValue() {
        return (T) map;
    }

    @Override
    public JsonElement deepCopy() {
        return null;
    }
}
