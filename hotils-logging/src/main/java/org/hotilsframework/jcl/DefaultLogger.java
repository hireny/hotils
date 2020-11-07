package org.hotilsframework.jcl;

import org.hotilsframework.jcl.appender.DefaultAppenderAttachable;

import java.util.StringJoiner;

/**
 * 默认的日志记录器
 * @author hireny
 * @className AbstractLogger
 * @create 2020-02-17 21:22
 */
public class DefaultLogger implements Logger, LifeCycle {
    /**
     * 完全限定名
     */
    private String name;
    /**
     * 日志级别
     */
    private Level level;
    /**
     * 父日志记录器
     */
    private DefaultLogger             parent;
    /**
     * 默认实现的可连接的输出源
     */
    private DefaultAppenderAttachable appenderAttachable;

    private LoggerContext loggerContext;

    protected DefaultLogger(String name) {
        this.name = name;
        this.level = Level.ALL;
    }

    @Override
    public boolean isTraceEnabled() {
        return isEnable(Level.TRACE);
    }

    @Override
    public void trace(String message) {
        log(Level.TRACE, message);
    }

    @Override
    public boolean isDebugEnabled() {
        return isEnable(Level.DEBUG);
    }

    @Override
    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    @Override
    public boolean isInfoEnabled() {
        return isEnable(Level.INFO);
    }

    @Override
    public void info(String message) {
        log(Level.INFO, message);
    }

    @Override
    public boolean isWarnEnabled() {
        return isEnable(Level.WARN);
    }

    @Override
    public void warn(String message) {
        log(Level.WARN, message);
    }

    @Override
    public boolean isErrorEnabled() {
        return isEnable(Level.ERROR);
    }

    @Override
    public void error(String message) {
        log(Level.ERROR, message);
    }

    @Override
    public boolean isFatalEnabled() {
        return isEnable(Level.FATAL);
    }

    @Override
    public void fatal(String message) {
        log(Level.FATAL, message);
    }

    /**
     * 是否输出日志
     * @param level
     * @return
     */
    private boolean isEnable(Level level) {
        return Level.compare(this.level, level) >= 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Logger getParent() {
        return parent;
    }

    public void setParent(Logger parent) {
        this.parent = (DefaultLogger) parent;
    }

    public DefaultAppenderAttachable getAppenderAttachable() {
        return appenderAttachable;
    }

    public void setAppenderAttachable(DefaultAppenderAttachable appenderAttachable) {
        this.appenderAttachable = appenderAttachable;
    }

    public LoggerContext getLoggerContext() {
        return loggerContext;
    }

    public void setLoggerContext(LoggerContext loggerContext) {
        this.loggerContext = loggerContext;
    }



    /**
     * 打印日志
     * @param level
     * @param message
     */
    private void log(Level level, String message) {
        LoggingEvent event = new LoggingEvent(getName(), level, message);
        for (DefaultLogger logger = this; logger != null; logger = logger.parent) {
            if (null ==logger.appenderAttachable) {
                continue;
            }
            if (level.toInt() > this.level.toInt()) {
                logger.appenderAttachable.appendLoopOnAppenders(event);
            }
            // 优先使用当前logger，如果当前没有则向上查找，找到就跳出
            // 默认情况下，如果不配置完整类名的logger，这里都需要向上查找，直至root
            // 比如name=x.y.z.AClass，则配置logger name="x.y.z"，则AClass会使用x.y.z这个logger
            break;
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DefaultLogger.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("level=" + level)
                .add("parent=" + parent)
                .add("appenderAttachable=" + appenderAttachable)
                .add("loggerContext=" + loggerContext)
                .toString();
    }
}
