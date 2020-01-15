package me.hireny.commons.utils.concurrent;

import me.hireny.commons.core.time.SystemClock;

/**
 * @ClassName: TimestampHolder
 * @Author: hireny
 * @Date: Create in 2019/12/04 13:48
 * @Description: TODO   时间戳持有者
 */
public class TimestampHolder {
    private long timestamp;

    public TimestampHolder() {
        this(SystemClock.now());
    }

    public TimestampHolder(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
