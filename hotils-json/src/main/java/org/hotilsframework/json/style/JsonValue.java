package org.hotilsframework.json.style;

/**
 * @Author: hireny
 * @Date: Create in 2019/07/22 08:24
 */
public interface JsonValue {

    /**
     * 获取Json的值
     * @param <T>
     * @return
     */
    <T> T toJsonValue();
}
