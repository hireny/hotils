package org.hotilsframework.core.logging.layout.pattern;

import org.hotilsframework.core.logging.LoggingEvent;

/**
 * @author hireny
 * @className ProcessConverter
 * @create 2020-02-18 23:27
 */
public class ProcessConverter extends KeywordConverter {
    @Override
    public String convert(LoggingEvent source) {
        return String.valueOf(source.getProcessId());
    }
}
