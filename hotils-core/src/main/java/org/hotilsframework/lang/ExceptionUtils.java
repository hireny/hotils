package org.hotilsframework.lang;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * ExceptionUtils
 *
 * 异常处理工具
 * @author hireny
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
        return getMessage(t, false);
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
            // only advance every other iteration
            advanceSlowPointer = !advanceSlowPointer;
        }
        return throwable;
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /**
     * 运行时异常处理器
     */
    public static class RuntimeExceptionHandler {

        public static void handleReflectionException(Exception e) {
            if (e instanceof NoSuchMethodException) {
                throw new IllegalStateException("Method not found: " + e.getMessage());
            }
            if (e instanceof IllegalAccessException) {
                throw new IllegalStateException("Could not access method(无法访问方法): " + e.getMessage());
            }
            if (e instanceof InvocationTargetException) {
                handleInvocationTargetException((InvocationTargetException) e);
            }
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            throw new UndeclaredThrowableException(e);
        }

        /**
         * 处理调用目标异常
         * @param ex
         */
        public static void handleInvocationTargetException(InvocationTargetException ex) {
            rethrowRuntimeException(ex.getTargetException());
        }

        /**
         * 将异常包裹，并返回根异常
         * @param e
         */
        public static void rethrowRuntimeException(Throwable e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            if (e instanceof Error) {
                throw (Error) e;
            }
            throw new UndeclaredThrowableException(e);
        }
    }
}
