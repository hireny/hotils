package org.hotilsframework.core.event;

import java.util.EventObject;

/**
 * EventElement
 *
 * 事件元素
 *
 * @author hireny
 * @create 2020-09-10 23:43
 */
public class EventElement extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventElement(Object source) {
        super(source);
    }
}
