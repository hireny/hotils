package org.hotilsframework.lang;

import org.hotilsframework.utils.Assert;
import org.hotilsframework.utils.StringUtils;

import java.util.Scanner;

/**
 * @ClassName: Console
 * @Author: hireny
 * @Date: Create in 2019/12/08 23:42
 * @Description: TODO   命令行(控制台)工具方法类
 */
public final class Console {

    private Console() {}

    //******************Log****************************//

    /**
     * 同 System.out.println()方法，打印控制台日志
     */
    public static void log() {
        System.out.println();
    }

    /**
     * 同 System.out.println()方法，打印控制台日志<br>
     * 如果传入打印对象为{@link Throwable}对象，那么同时打印堆栈
     *
     * @param object    要打印的对象
     */
    public static void log(Object object) {
        if (object instanceof Throwable) {
            Throwable e = (Throwable) object;
            log(e, e.getMessage());
        } else {
            log("{}", object);
        }
    }

    /**
     * 同 System.out.println()方法，打印控制台日志
     *
     * @param template      文本模板，被替换的部分用 {} 表示
     * @param values        值
     */
    public static void log(String template, Object... values) {
        log(null, template, values);
    }

    /**
     * 同 System.out.println()方法，打印控制台日志
     * @param t             异常对象
     * @param template      文本模板，被替换的部分用 {} 表示
     * @param values        值
     */
    public static void log(Throwable t, String template, Object... values) {
        System.out.println(StringUtils.format(template, values));
        if (null != t) {
            t.printStackTrace();
            System.out.flush();
        }
    }

    /**
     * 同 System.out.print()方法，打印控制台日志
     *
     * @param obj 要打印的对象
     */
    public static void print(Object obj) {
        print("{}", obj);
    }

    /**
     * 同 System.out.print()方法，打印控制台日志
     *
     * @param template 文本模板，被替换的部分用 {} 表示
     * @param values 值
     */
    public static void print(String template, Object... values) {
        System.out.print(StringUtils.format(template, values));
    }



    /**
     * 打印进度条
     *
     * @param showChar 进度条提示字符，例如“#”
     * @param len 打印长度
     * @since 4.5.6
     */
    public static void printProgress(char showChar, int len) {
//        print("{}{}", CharUtil.CR, StrUtil.repeat(showChar, len));
    }

    /**
     * 打印进度条
     *
     * @param showChar 进度条提示字符，例如“#”
     * @param totalLen 总长度
     * @param rate 总长度所占比取值0~1
     * @since 4.5.6
     */
    public static void printProgress(char showChar, int totalLen, double rate) {
        Assert.isTrue(rate >= 0 && rate <= 1, "Rate must between 0 and 1 (both include)");
        printProgress(showChar, (int) (totalLen * rate));
    }


    //******************Error****************************//

    /**
     * 同 System.err.println()方法，打印控制台日志
     */
    public static void error() {
        System.err.println();
    }

    /**
     * 同 System.err.println()方法，打印控制台日志
     * @param object    要打印的对象
     */
    public static void error(Object object) {
        if (object instanceof Throwable) {
            Throwable t = (Throwable) object;
            error(t, t.getMessage());
        } else {
            error("{}", object);
        }
    }

    /**
     * 同 System.err.println() 方法，打印控制台日志
     *
     * @param template      文本模板，被替换的部分用 {} 表示
     * @param values        值
     */
    public static void error(String template, Object... values) {
        error(null, template, values);
    }

    /**
     * 同 System.err.println() 方法，打印控制台日志
     *
     * @param t             异常对象
     * @param template      文本模板，被替换的部分用 {} 表示
     * @param values        值
     */
    public static void error(Throwable t, String template, Object... values) {
        System.err.println(StringUtils.format(template, values));
        if (null != t) {
            t.printStackTrace();
            System.err.flush();
        }
    }




    //******************in****************************//

    /**
     * 创建从控制台读取内容的 {@link Scanner}
     *
     * @return      {@link Scanner}
     */
    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    /**
     * 读取用户输入的内容(在控制台敲回车前的内容)
     *
     * @return      用户输入的内容
     */
    public static String input() {
        return scanner().next();
    }

}
