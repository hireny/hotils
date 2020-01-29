package org.hotilsframework.net.http;

import java.util.Map;

/**
 * @ClassName: HttpEntity
 * @Author: hireny
 * @Date: Create in 2019/12/11 14:02
 * @Description: TODO   HTTP实体类
 */
public class HttpEntity<T> {

    /**
     * 空的HTTP实体类，没有请求正文和请求头
     */
    public static final HttpEntity<?> EMPTY = new HttpEntity<>();
    /**
     * 请求头
     */
    private final HttpHeaders headers;
    /**
     * 请求体
     */
    private final T body;

    /**
     * 无参构造器
     */
    public HttpEntity() {
        this(null, null);
    }

    /**
     * 构造
     * @param body
     */
    public HttpEntity(T body) {
        this(body, null);
    }

    /**
     * 构造
     * @param headers
     */
    public HttpEntity(Map<String, String> headers) {
        this(null, headers);
    }

    /**
     * 构造器
     * @param body
     * @param headers
     */
    public HttpEntity(T body, Map<String, String> headers) {
        this.body = body;
        // 我们要将Map映射转换为HttpHeaders
        this.headers = null;
    }
}
