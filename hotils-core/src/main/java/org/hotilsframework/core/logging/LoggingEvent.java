package org.hotilsframework.core.logging;

import org.hotilsframework.utils.SystemUtils;

import java.util.StringJoiner;

/**
 * 日志事件Bean类
 * @author hireny
 * @className LoggingEvent
 * @create 2020-02-17 21:29
 */
public class LoggingEvent {
    /**
     * 记录日志的时间戳
     */
    private long timestamp;
    /**
     * 日志记录器名字
     */
    private String loggerName;
    /**
     * 日志级别
     */
    private Level level;
    /**
     * 进程ID
     */
    private long processId;
    /**
     * 线程ID
     */
    private long threadId;
    /**
     * 线程名称
     */
    private String threadName;
    /**
     * 日志消息
     */
    private Object message;

    /**
     * 构造
     * @param loggerName
     * @param level
     * @param message
     */
    public LoggingEvent(String loggerName, Level level, Object message) {
        this.timestamp = System.currentTimeMillis();
        this.loggerName = loggerName;
        this.level = level;
        this.processId = SystemUtils.getCurrentPID();
        this.threadId = Thread.currentThread().getId();
        this.threadName = Thread.currentThread().getName();
        this.message = message;
    }


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public long getProcessId() {
        return processId;
    }

    public void setProcessId(long processId) {
        this.processId = processId;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LoggingEvent.class.getSimpleName() + "[", "]")
                .add("timestamp=" + timestamp)
                .add("loggerName='" + loggerName + "'")
                .add("level=" + level)
                .add("processId=" + processId)
                .add("threadId=" + threadId)
                .add("threadName='" + threadName + "'")
                .add("message=" + message)
                .toString();
    }
}
