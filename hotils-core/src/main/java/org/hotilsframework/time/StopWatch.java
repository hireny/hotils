package org.hotilsframework.time;

import org.hotilsframework.collect.Lists;
import org.hotilsframework.lang.Nullable;
import org.hotilsframework.utils.Assert;

import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 秒表
 * @author hireny
 * @className StopWatch
 * @create 2020-06-11 12:13
 */
public class StopWatch {
    /**
     * 标识符
     * <p>方便时, 会在日志或控制台输出多个秒表来区分它们。
     */
    private final String id;

    private boolean keepTaskList = true;
    /**
     *  任务信息列表
     */
    private final List<TaskInfo> taskList = Lists.newLinkedList();
    /**
     * 当前任务的启动时间
     */
    private long startTimeNanos;
    /**
     * 当前任务名
     */
    @Nullable
    private String currentTaskName;
    /**
     * 最后的任务数据
     */
    private TaskInfo lastTaskInfo;
    /**
     * 任务数量
     */
    private int taskCount;
    /**
     * 总任务时间
     */
    private long totalTimeNanos;

    public StopWatch() {
        this("");
    }

    /**
     * 给定秒表ID标识
     *
     * <p>当有多个秒表时，需要ID标识来区分它们</p>
     * @param id    当前秒表的ID标识
     */
    public StopWatch(String id) {
        this.id = id;
    }

    /**
     * 获取当前秒表ID标识符
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * 设置是否保存任务列表
     * @param keepTaskList
     */
    public void setKeepTaskList(boolean keepTaskList) {
        this.keepTaskList = keepTaskList;
    }

    /**
     * 秒表启动
     */
    public void start() {
        start("");
    }

    /**
     * 启动一个被命名的任务
     * @param taskName
     */
    public void start(String taskName) {
        // 当 currentTaskName != null 时，抛出异常，因为当前秒表已经在跑了
        Assert.state(this.currentTaskName == null, "Can't start StopWatch: it's already running");
        this.currentTaskName = taskName;
        this.startTimeNanos = System.nanoTime();
    }

    /**
     * 将当前秒表停止
     */
    public void stop() {
        // 当 currentTaskName == null时，抛出异常，因为当前秒表已经停止
        Assert.state(this.currentTaskName != null, "Can't stop StopWatch: it's not running");
        long lastTime = System.nanoTime() - this.startTimeNanos;
        this.totalTimeNanos += lastTime;
        this.lastTaskInfo = new TaskInfo(this.currentTaskName, lastTime);
        if (this.keepTaskList) {
            this.taskList.add(this.lastTaskInfo);
        }
        this.taskCount++;
        this.currentTaskName = null;
    }

    /**
     * 用于判断当前任务是否还在运行
     * @return
     */
    public boolean isRunning() {
        return this.currentTaskName != null;
    }

    /**
     * 获取当前任务名称
     * @return
     */
    public String currentTaskName() {
        return this.currentTaskName;
    }

    /**
     * 获取最后任务时间
     * @return
     */
    public long getLastTaskTimeNanos() {
        // 判断最后的任务信息是否还有，如果没有就抛出异常，没有任务在跑了
        Assert.state(this.lastTaskInfo != null, "No tasks run: can't get last task interval");
        return this.lastTaskInfo.getTimeNanos();
    }

    /**
     * 获取最后任务时间的毫秒数
     * @return
     */
    public long getLastTaskTimeMillis() {
        Assert.state(this.lastTaskInfo != null, "No tasks run: can't get last task interval");
        return this.lastTaskInfo.getTimeMillis();
    }

    public String getLastTaskName() {
        Assert.state(this.lastTaskInfo != null, "No tasks run: can't get last task name");
        return this.lastTaskInfo.getTaskName();
    }

    public TaskInfo getLastTaskInfo() {
        Assert.state(this.lastTaskInfo != null, "No tasks run: can't get last task info");
        return this.lastTaskInfo;
    }

    public long getTotalTimeNanos() {
        return this.totalTimeNanos;
    }

    public long getTotalTimeMillis() {
        return nanosToMillis(this.totalTimeNanos);
    }

    public double getTotalTimeSeconds() {
        return nanosToSeconds(this.totalTimeNanos);
    }

    /**
     * 获取秒表任务数量
     * @return
     */
    public int getTaskCount() {
        return this.taskCount;
    }

    public TaskInfo[] getTaskInfo() {
        if (!this.keepTaskList) {
            // 没有这样的操作
            throw new UnsupportedOperationException("Task info is not being kept!");
        }
        return this.taskList.toArray(new TaskInfo[0]);
    }

    /**
     * 简单的摘要
     *
     * <p>比较简短的介绍该任务的信息</p>
     * @return
     */
    public String shortSummary() {
        return "StopWatch '" + getId() + "': running time = " + getTotalTimeNanos() + "ns";
    }

    /**
     * 对秒表打印进行美化
     * @return
     */
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder(shortSummary());
        sb.append('\n');
        if (!this.keepTaskList) {
            sb.append("No task info kept");
        }
        else {
            sb.append("---------------------------------------------\n");
            sb.append("ns         %     Task name\n");
            sb.append("---------------------------------------------\n");
            NumberFormat nf = NumberFormat.getNumberInstance();
            nf.setMinimumIntegerDigits(9);
            nf.setGroupingUsed(false);
            NumberFormat pf = NumberFormat.getPercentInstance();
            pf.setMinimumIntegerDigits(3);
            pf.setGroupingUsed(false);
            for (TaskInfo task : getTaskInfo()) {
                sb.append(nf.format(task.getTimeNanos())).append("  ");
                sb.append(pf.format((double) task.getTimeNanos() / getTotalTimeNanos())).append("  ");
                sb.append(task.getTaskName()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(shortSummary());
        if (this.keepTaskList) {
            for (TaskInfo task : getTaskInfo()) {
                sb.append("; [")
                        .append(task.getTaskName())
                        .append("] took ")
                        .append(task.getTimeNanos())
                        .append(" ns");
                long percent = Math.round(100.0 * task.getTimeNanos() / getTotalTimeNanos());
                sb.append(" = ").append(percent).append("%");
            }
        } else {
            sb.append("; no task info kept");
        }
        return sb.toString();
    }

    private static long nanosToMillis(long duration) {
        return TimeUnit.NANOSECONDS.toMillis(duration);
    }

    private static double nanosToSeconds(long duration) {
        return duration / 1_000_000_000.0;
    }

    /**
     * 在类中执行的一个任务数据的单位
     */
    public static final class TaskInfo {
        /**
         * 任务名
         */
        private final String taskName;
        /**
         * 时间
         */
        private final long timeNanos;

        TaskInfo(String taskName, long timeNanos) {
            this.taskName = taskName;
            this.timeNanos = timeNanos;
        }

        public String getTaskName() {
            return taskName;
        }

        public long getTimeNanos() {
            return timeNanos;
        }

        /**
         * 获取此任务所花费的毫秒数
         * @return
         */
        public long getTimeMillis() {
            return nanosToMillis(this.timeNanos);
        }

        /**
         * 获取此任务所花费的秒数
         * @return
         */
        public double getTimeSeconds() {
            return nanosToSeconds(this.timeNanos);
        }
    }
}
