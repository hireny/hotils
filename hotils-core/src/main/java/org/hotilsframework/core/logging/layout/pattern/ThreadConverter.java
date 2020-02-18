package org.hotilsframework.core.logging.layout.pattern;

import org.hotilsframework.core.logging.LoggingEvent;

/**
 * 线程转换
 * @author hireny
 * @className ThreadConverter
 * @create 2020-02-18 21:15
 */
public class ThreadConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent source) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(source.getThreadName());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
