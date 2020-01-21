package org.hotilsframework.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: DefaultHeaders
 * @Author: hireny
 * @Date: Create in 2019/12/20 23:01
 * @Description: TODO   默认的头部信息
 *
 * 所有HTTP请求将共用此头部信息，除非在 {@link HttpRequest} 中自定义头部信息覆盖
 */
public enum DefaultHeaders {

    INSTANCE;

    /**
     * 存储头信息
     */
    protected Map<String, List<String>> headers = new HashMap<>();
}
