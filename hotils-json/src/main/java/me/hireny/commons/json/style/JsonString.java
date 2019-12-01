package me.hireny.commons.json.style;

/**
 * The JSONString interface requires a toJSONString method,
 * allowing an object to provide its own serialization.
 * JSONString接口需要一个toJSONString方法，允许对象提供自己的序列化。
 * @Author: hireny
 * @Date: Create in 2019/07/21 23:27
 */
public interface JsonString {
    /**
     * The method allows a class to produce its own JSON serialization.
     * 该方法允许类生成自己的JSON序列化
     * @return
     */
    String toJSONString();
}
