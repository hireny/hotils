package org.hotilsframework.web.handler;

import org.hotilsframework.http.HttpHeaders;
import org.hotilsframework.web.server.WebHandler;

/**
 * RequestHandler
 *
 * 请求处理器
 *
 * 所有HTTP请求处理器都要实现此接口
 *
 * @author hireny
 * @create 2020-07-09 13:10
 */
public interface RequestHandler<T, R> extends WebHandler {
    /**
     * 请求处理逻辑
     *
     * @param request   请求参数对象
     * @return          请求响应对象
     */
    R handle(T request);

    /**
     * 给用户一个修改响应头的机会
     *
     * @param headers       响应头
     * @param data          {@link #handle(Object)} 的返回值
     */
    default void handleHeader(HttpHeaders headers, R data) {

    }
}
