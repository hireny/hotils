package org.hotilsframework.core.event;

import java.util.EventObject;

/**
 * AbstractEvent
 *
 * 抽象的事件
 *
 * @author hireny
 * @create 2020-09-10 23:43
 */
public abstract class AbstractEvent extends EventObject implements Event {
    private static final long serialVersionUID = 4902200597131913431L;
    /**
     * 事件类型
     */
    private final String eventType;
    /**
     * 当事件发生时的时间戳
     */
    private final long timestamp;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @param type   The event type
     * @throws IllegalArgumentException if source is null.
     */
    public AbstractEvent(Object source, String type) {
        super(source);
        this.eventType = type;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public String getEventType() {
        return this.eventType;
    }

    @Override
    public Object getEventSource() {
        return this.getSource();
    }

    @Override
    public long getTimestamp() {
        return this.timestamp;
    }
}
