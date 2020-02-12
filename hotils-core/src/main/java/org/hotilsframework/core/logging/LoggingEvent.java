package org.hotilsframework.core.logging;

import java.util.StringJoiner;

/**
 * @ClassName: LoggerEvent
 * @Author: hireny
 * @Date: Created in 2020-02-12 18:20
 * @Version: 1.0
 */
public class LoggingEvent {
    private long timestamp;
    private Level level;
    private Object message;
    private String threadName;
    private long threadId;
    private String loggerName;

    public LoggingEvent(Level level, Object message, String loggerName) {
        this.timestamp = System.currentTimeMillis();
        this.level = level;
        this.message = message;
        Thread currentThread = Thread.currentThread();
        this.threadName = currentThread.getName();
        this.threadId = currentThread.getId();
        this.loggerName = loggerName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public long getThreadId() {
        return threadId;
    }

    public void setThreadId(long threadId) {
        this.threadId = threadId;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LoggingEvent that = (LoggingEvent) o;

        if (timestamp != that.timestamp) {
            return false;
        }
        if (threadId != that.threadId) {
            return false;
        }
        if (level != that.level) {
            return false;
        }
        if (message != null ? !message.equals(that.message) : that.message != null) {
            return false;
        }
        if (threadName != null ? !threadName.equals(that.threadName) : that.threadName != null) {
            return false;
        }
        return loggerName != null ? loggerName.equals(that.loggerName) : that.loggerName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (timestamp ^ (timestamp >>> 32));
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (threadName != null ? threadName.hashCode() : 0);
        result = 31 * result + (int) (threadId ^ (threadId >>> 32));
        result = 31 * result + (loggerName != null ? loggerName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LoggingEvent.class.getSimpleName() + "[", "]")
                .add("timestamp=" + timestamp)
                .add("level=" + level)
                .add("message=" + message)
                .add("threadName='" + threadName + "'")
                .add("threadId=" + threadId)
                .add("loggerName='" + loggerName + "'")
                .toString();
    }
}
