package org.hotilsframework.core.event;

/**
 * Event
 *
 * 事件
 *
 * @author hireny
 * @create 2020-09-11 19:25
 */
public interface Event {
    /**
     * 获取事件类型
     * @return
     */
    String getEventType();

    /**
     * 获取事件源
     * @return
     */
    Object getEventSource();

    /**
     * 事件发生时的时间戳
     * @return
     */
    long getTimestamp();
}
