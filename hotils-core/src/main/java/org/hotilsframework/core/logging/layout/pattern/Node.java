package org.hotilsframework.core.logging.layout.pattern;

import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.core.logging.LoggingEvent;

/**
 * 节点
 * @author hireny
 * @className Node
 * @create 2020-02-18 20:49
 */
public class Node {

    public static final int LITERAL = 0;

    public static final int KEYWORD = 1;

    protected int type;
    protected String value;
    protected Node next;
    protected Converter<LoggingEvent, String> converter;

    public Node(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Converter<LoggingEvent, String> getConverter() {
        return converter;
    }

    public void setConverter(Converter<LoggingEvent, String> converter) {
        this.converter = converter;
    }
}
