package org.hotilsframework.jcl;

/**
 * @author hireny
 * @className LogFilter
 * @create 2020-02-18 17:00
 */
public interface LogFilter extends LifeCycle {

    boolean doFilter(LoggingEvent event);
}
