package org.hotilsframework.jcl.layout.pattern;

import org.hotilsframework.jcl.LoggingEvent;

/**
 * 日志记录器转换
 * @author hireny
 * @className LoggerConverter
 * @create 2020-02-18 21:14
 */
public class LoggerConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent source) {
        return source.getLoggerName();
    }
}
