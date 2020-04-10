package org.hotilsframework.aop;

import org.hotilsframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * 方法前置通知接口
 * @author hireny
 * @className MethodBeforeAdvice
 * @create 2020-04-09 20:27
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    /**
     * 调用给定方法之前的回调
     * @param method        被调用的方法
     * @param args          方法参数
     * @param target        方法调用的目标。可以是 {@code null}
     * @throws Throwable
     */
    void before(Method method, Object[] args, @Nullable Object target) throws Throwable;
}
