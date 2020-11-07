package org.hotilsframework.jcl.layout.pattern;

import org.hotilsframework.jcl.LoggingEvent;

/**
 * 消息转换
 * @author hireny
 * @className MessageConverter
 * @create 2020-02-18 21:14
 */
public class MessageConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent source) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(':');
        stringBuilder.append(source.getMessage());
        return stringBuilder.toString();
    }
}
