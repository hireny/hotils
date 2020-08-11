package org.hotilsframework.http;

import org.hotilsframework.utils.Assert;

import java.util.Map;

/**
 * @ClassName: ResponseEntity
 * @Author: hireny
 * @Date: Create in 2019/12/11 14:06
 * @Description: TODO   响应实体类
 */
public class ResponseEntity<T> extends HttpEntity<T> {
    /**
     * 状态
     */
    private final Object stauts;

    /**
     * 使用给定的正文、标题和状态码创建一个新的 {@code HttpEntity} 。只是在嵌套在 builder API 后面使用
     *
     * @param body
     * @param headers
     * @param status
     */
    private ResponseEntity(T body, Map<String, String> headers, Object status) {
        super(body, headers);
        this.stauts = Assert.notNull(status, "HttpStatus must not be null");
    }
}
