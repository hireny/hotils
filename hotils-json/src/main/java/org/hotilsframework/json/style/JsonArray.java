package org.hotilsframework.json.style;

import org.hotilsframework.json.exception.JsonTypeException;

import java.util.List;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/16 21:13
 */
public class JsonArray extends JsonElement implements JsonValue {

    List<Object> list;

    private JsonArray() {}

    public JsonArray(List<Object> list) {
        this.list = list;
    }

    /**
     * 添加Object元素
     * @param o
     * @return
     */
    public boolean add(Object o) {
        return list.add(o);
    }

    /**
     * 获取下标为index的Object元素
     * @param index
     * @return
     */
    public Object get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    /**
     * 获取下标为index的JsonObject元素
     * @param index
     * @return
     */
    public JsonObject getJsonObject(int index) throws JsonTypeException {
        Object o = list.get(index);
        if (!(o instanceof JsonObject)) {
            throw new JsonTypeException("Type of value is not JsonObject.(该值的类型不是JsonObject类型)");
        }
        return (JsonObject) o;
    }

    /**
     * 获取下标为index的JsonArray元素
     * @param index
     * @return
     */
    public JsonArray getJsonArray(int index) throws JsonTypeException {
        Object o = list.get(index);
        if (!(o instanceof JsonArray)) {
            throw new JsonTypeException("Type of value is not JsonArray.(该值的类型不是JsonArray类型)");
        }
        return (JsonArray) o;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T toJsonValue() {
        return (T) list;
    }

    @Override
    public JsonElement deepCopy() {
        return null;
    }
}
