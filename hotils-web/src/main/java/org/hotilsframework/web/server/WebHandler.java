package org.hotilsframework.web.server;

/**
 * WebHandler
 * Web处理器
 *
 * @author hireny
 * @create 2020-07-09 13:02
 */
public interface WebHandler {
    /**
     * 处理
     * @param exchange
     */
    void handle(ServerWebExchange exchange);
}
