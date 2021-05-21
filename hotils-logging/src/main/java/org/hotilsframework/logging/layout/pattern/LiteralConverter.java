package org.hotilsframework.logging.layout.pattern;


import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.logging.LoggingEvent;

/**
 * 文字转换
 * @author hireny
 * @className LiteralConverter
 * @create 2020-02-18 21:12
 */
public class LiteralConverter implements Converter<LoggingEvent, String> {

    private String literal;

    public LiteralConverter(String literal) {
        this.literal = literal;
    }

    @Override
    public String convert(LoggingEvent source) {
        return literal;
    }
}
