package org.hotilsframework.core.event;

/**
 * EventListener
 *
 * 事件监听器
 *
 * @author hireny
 * @create 2020-09-10 23:46
 */
@FunctionalInterface
public interface EventListener<E extends Event> extends java.util.EventListener {
    /**
     * 事件处理
     * @param event 响应的事件
     */
    void onEvent(E event);
}
