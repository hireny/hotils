package org.hotilsframework.http;

import java.util.HashMap;
import java.util.Map;

/**
 * HttpMethod
 *
 * HTTP枚举
 *
 * @author hireny
 * @create 2020-08-11 19:44
 */
public enum HttpMethod {
    /**
     * GET请求
     */
    GET,
    /**
     * HEAD请求
     */
    HEAD,
    /**
     * POST请求
     */
    POST,
    /**
     * PUT请求
     */
    PUT,
    /**
     * PATCH请求
     */
    PATCH,
    /**
     * DELETE请求
     */
    DELETE,
    /**
     * OPTIONS请求
     */
    OPTIONS,
    /**
     * TRACE请求
     */
    TRACE;

    private static final Map<String, HttpMethod> mappings = new HashMap<>();

    static {
        for (HttpMethod httpMethod : HttpMethod.values()) {
            mappings.put(httpMethod.name(), httpMethod);
        }
    }

    /**
     * 用于解析传入的方法与该类中枚举值进行匹配，并返回匹配的结果
     * @param method
     * @return
     */
    public static HttpMethod resolve(String method) {
        return (method != null ? mappings.get(method) : null);
    }

    public boolean matches(String method) {
        return (this == resolve(method));
    }
}
