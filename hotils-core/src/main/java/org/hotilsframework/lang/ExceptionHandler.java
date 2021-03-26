package org.hotilsframework.lang;

/**
 * ExceptionHandler
 *
 * 异常处理器
 *
 * @author hireny
 * @create 2020-12-30 13:09
 */
@FunctionalInterface
public interface ExceptionHandler<T extends Throwable> {
    /**
     * 处理给定的异常
     *
     * @param exception 传入的异常对象
     */
    void handle(T exception);
}
