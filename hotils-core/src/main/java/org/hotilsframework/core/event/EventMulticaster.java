package org.hotilsframework.core.event;

/**
 * EventMulticaster
 *
 * 时间管理者
 *
 * 管理监听器和发布事件
 *
 * @author hireny
 * @create 2020-09-14 0:11
 */
public interface EventMulticaster {
    /**
     * 添加事件监听器
     * @param listener
     */
    void addEventListener(EventListener<?> listener);

    /**
     * 删除事件监听器
     * @param listener
     */
    void removeEventListener(EventListener<?> listener);

    /**
     * 移除所有事件监听器
     */
    void removeEventListeners();
}
