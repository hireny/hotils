package org.hotilsframework.logger;

/**
 * 日志器
 * @ClassName: Logger
 * @Author: hireny
 * @Date: Created in 2020-02-03 16:16
 * @Version: 1.0
 */
public class Logger {

    /**
     * 打印方法
     * @param tag
     * @param line
     * @param level
     */
    private void println(String tag, String line, Level level) {
        StringBuilder stringBuilder;
        switch (level) {
            case INFO:
                stringBuilder = new StringBuilder("INFO:");
                break;
            case DEBUG:
                stringBuilder = new StringBuilder("DEBUG:");
                break;
            case WARN:
                stringBuilder = new StringBuilder("WARN:");
                break;
            case ERROR:
                stringBuilder = new StringBuilder("ERROR:");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + level);
        }
        stringBuilder.append(tag).append(" ").append(line);
        System.out.println(stringBuilder.toString());
    }
}
