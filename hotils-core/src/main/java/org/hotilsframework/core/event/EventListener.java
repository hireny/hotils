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
public interface EventListener extends java.util.EventListener {
    /**
     * 添加事件
     * @param event
     */
    void addListener(EventElement event);
}
