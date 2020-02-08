package org.hotilsframework.core.lang;

import org.hotilsframework.utils.StringUtils;

/**
 * @ClassName: Console
 * @Author: hireny
 * @Date: Create in 2019/12/08 23:42
 * @Description: TODO   命令行(控制台)工具方法类
 */
public class Console {

    private Console() {}

    /**
     * 同 System.out.println()方法， 打印控制台日志
     * 如果传入打印对象为 {@link Throwable} 对象，那么同时打印堆栈
     * @param o     要打印的对象
     */
    public static void info(Object o) {
        if (o instanceof Throwable) {
            Throwable t = (Throwable) o;
            info(t, t.getMessage());
        } else {
            info("{}", o);
        }
    }

    /**
     * 同 System.out.println()方法，打印控制台日志
     *
     * @param text      文本信息，被替换的部分用 {} 表示
     * @param args      值
     */
    public static void info(String text, Object... args) {
        info(null, text, args);
    }

    /**
     * 同 System.out.println()方法，打印控制台日志
     * @param t     异常对象
     * @param text  文本，被替换的部分用 {} 表示
     * @param args  值
     */
    public static void info(Throwable t, String text, Object... args) {
        System.out.println(StringUtils.format(text, args));
        if (null != t) {
            t.printStackTrace();
            System.out.flush();
        }
    }
}
