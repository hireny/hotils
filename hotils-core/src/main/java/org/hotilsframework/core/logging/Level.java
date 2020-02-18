package org.hotilsframework.core.logging;

import java.util.EnumSet;

/**
 * @ClassName: Level
 * @Author: hireny
 * @Date: Create in 2019/12/13 11:44
 * @Description: TODO   日志级别
 */
public enum Level {
    /**
     * 'ALL' log level.
     * 最低级别，用于打开所有日志记录
     */
    ALL(0, "ALL"),
    /**
     * 'TRACE' log level.
     * 很低的日志级别，一般不会使用
     */
    TRACE(10, "TRACE"),
    /**
     * 'DEBUG' log level.
     * 指出细粒度信息事件对调式应用程序是非常有帮助的，主要用于开发过程中打印一些运行信息。
     */
    DEBUG(20, "DEBUG"),
    /**
     * 'INFO' log level.
     * 消息在粗粒度级别上突出强调应用程序的运行过程。打印一些你感兴趣的或者重要的信息，
     * 这个可以用于生产环境中输出程序运行的一些重要信息，但是不能滥用，避免打印过多的日志。
     */
    INFO(30, "INFO"),
    /**
     * 'WARN' log level.
     * 表明会出现潜在错误的情形，有些信息不是错误信息，但是也要给程序员的一些提示。
     */
    WARN(40, "WARN"),
    /**
     * 'ERROR' log level.
     * 指出虽然发生错误事件，但仍然不影响系统的继续运行。打印错误和异常信息，
     * 如果不想输出太多的日志，可以使用这个级别。
     */
    ERROR(50, "ERROR"),
    /**
     * 'FATAL' log level.
     * 指出每个严重的错误事件将会导致应用程序的退出。这个级别比较高了。
     * 重大错误，这个级别你可以直接停止程序了。
     */
    FATAL(60, "FATAL"),
    /**
     * 'OFF' log level.
     * 最高级别的，用于关闭所有日志记录
     */
    OFF(70, "OFF");

    /**
     * 优先级
     */
    private int levelInt;
    /**
     * 日志级别名称
     */
    private String levelString;

    Level(int levelInt, String levelString) {
        this.levelInt = levelInt;
        this.levelString = levelString;
    }

    /**
     * 优先级
     * @return
     */
    public int toInt() {
        return this.levelInt;
    }

    @Override
    public String toString() {
        return this.levelString;
    }

    private static final EnumSet<Level> LEVEL_ENUM_SET = EnumSet.allOf(Level.class);

    /*
    * 如果将 log level 设置在某一个级别上，那么比此级别优先级高的log都能打印出来。
    * 例如：如果设置优先级为WARN，那么OFF、FATAL、ERROR、WARN 4个级别的log能正常输出，
    * 而INFO、DEBUG、TRACE、ALL级别的log则会被忽略。
    */

    /**
     * 比较级别
     * @param l1
     * @param l2
     * @return  if value > 0 优先级 l1 > l2， else value < 0 优先级 l1 < l2
     */
    public static int compare(Level l1, Level l2) {
        return l1.toInt() - l2.toInt();
    }

    public static Level parse(final String levelName) {
        Level level = Level.OFF;
        for (final Level lv1 : LEVEL_ENUM_SET) {
            if (levelName.equalsIgnoreCase(lv1.name())) {
                level = lv1;
                break;
            }
        }
        return level;
    }
}
