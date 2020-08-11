package org.hotilsframework.http;

/**
 * HttpMessage
 *
 * 请求消息
 *
 * @author hireny
 * @create 2020-08-11 19:41
 */
public interface HttpMessage {
    /**
     * 返回该请求消息的请求头
     * @return
     */
    HttpHeaders getHeaders();
}
