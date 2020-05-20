package org.hotilsframework.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常处理工具
 * @author hireny
 * @className ExceptionUtils
 * @create 2020-05-12 9:44
 */
public class ExceptionUtils {

    private ExceptionUtils() {

    }

    /**
     * 获取消息，调用异常类的getMessage方法
     * @param t
     * @return
     */
    public static String getMessage(Throwable t) {
        return getMessage(t);
    }

    /**
     * 获取消息，调用异常类的getMessage方法
     * @param t                     异常
     * @param isNeedClassName       是否需要异常名，当为true是，消息格式为：{SimpleClassName}: {ThrowableMessage}
     * @return
     */
    public static String getMessage(Throwable t, boolean isNeedClassName) {
        if (null == t) {
            return StringUtils.NULL;
        }
        if (!isNeedClassName) {
            return t.getMessage();
        }
        return StringUtils.format(t.getClass().getSimpleName(), t.getMessage());
    }

    /**
     * 获取当前栈信息
     *
     * @return  当前栈信息
     */
    public static StackTraceElement[] getStackElements() {
       return Thread.currentThread().getStackTrace();
    }

    /**
     * 获取指定层的堆栈信息
     *
     * @param index 层数
     * @return      指定层的堆栈信息
     */
    public static StackTraceElement getStackElement(int index) {
        return getStackElements()[index];
    }

    /**
     * 获取入口堆栈信息
     * @return  入口堆栈信息
     */
    public static StackTraceElement getRootStackElement() {
        final StackTraceElement[] stackTraceElements = getStackElements();
        return stackTraceElements[stackTraceElements.length - 1];
    }

    public static Throwable getRootCause(Throwable throwable) {
        Throwable slowPointer = throwable;
        boolean advanceSlowPointer = false;

        Throwable cause;
        while ((cause = throwable.getCause()) != null) {
            throwable = cause;

            if (throwable == slowPointer) {
                throw new IllegalArgumentException("Loop in causal chain detected.", throwable);
            }
            if (advanceSlowPointer) {
                slowPointer = slowPointer.getCause();
            }
            advanceSlowPointer = !advanceSlowPointer; // only advance every other iteration
        }
        return throwable;
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
