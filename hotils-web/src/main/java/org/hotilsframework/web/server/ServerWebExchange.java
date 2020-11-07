package org.hotilsframework.web.server;

import org.hotilsframework.web.Request;
import org.hotilsframework.web.Response;

/**
 * ServerWebExchange
 *
 * 网络交换
 *
 * @author hireny
 * @create 2020-07-10 9:46
 */
public interface ServerWebExchange {
    /**
     * 请求
     * @return
     */
    Request getRequest();

    /**
     * 响应
     * @return
     */
    Response getResponse();
}
