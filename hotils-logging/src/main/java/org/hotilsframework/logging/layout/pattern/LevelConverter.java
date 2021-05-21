package org.hotilsframework.logging.layout.pattern;

import org.hotilsframework.core.convert.converter.Converter;
import org.hotilsframework.logging.LoggingEvent;

/**
 * 日志级别转换
 * @author hireny
 * @className LevelConverter
 * @create 2020-02-18 21:10
 */
public class LevelConverter implements Converter<LoggingEvent, String> {
    @Override
    public String convert(LoggingEvent source) {
        return source.getLevel().toString();
    }
}
