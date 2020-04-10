package org.hotilsframework.aop;

import org.hotilsframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @author hireny
 * @className AfterReturningAdvice
 * @create 2020-04-09 20:23
 */
public interface AfterReturningAdvice extends AfterAdvice {

    /**
     * 成功返回给定方法后的回调
     * @param returnValue   方法返回的值，如果有
     * @param method        被调用的方法
     * @param args          方法参数
     * @param target        方法调用的目标，可以是 {@code null}
     * @throws Throwable
     */
    void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable;
}
