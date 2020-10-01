package org.hotilsframework.jcl;

/**
 * @author hireny
 * @className LogLevelFilter
 * @create 2020-02-18 17:01
 */
public class LevelFilter implements LogFilter {

    private String level;

    private Level LogLevel;

    @Override
    public boolean doFilter(LoggingEvent event) {
        return Level.compare(event.getLevel(), LogLevel) >= 0;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public void start() {
        this.LogLevel = Level.parse(level);
    }

    @Override
    public void stop() {

    }
}
