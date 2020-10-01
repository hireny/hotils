package org.hotilsframework.core.event;

/**
 * EventPublisher
 *
 * 事件发布者
 *
 * 封装事件有关公共方法
 *
 * @author hireny
 * @create 2020-09-11 19:16
 */
@FunctionalInterface
public interface EventPublisher {

    /**
     * 发布事件
     * @param event
     */
    void publishEvent(Event event);
}
