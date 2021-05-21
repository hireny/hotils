package org.hotilsframework.logging;

/**
 * @author hireny
 * @className LogFilter
 * @create 2020-02-18 17:00
 */
public interface LogFilter extends LogRunner {

    boolean doFilter(LoggingEvent event);
}
