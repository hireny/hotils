package org.hotilsframework.aop;

import java.lang.reflect.Method;

/**
 * 异常通知
 * @author hireny
 * @className AfterThrowingAdvice
 * @create 2020-04-09 20:56
 */
public interface AfterThrowingAdvice extends ThrowsAdvice {

    /**
     * 在给定的方法执行异常的时候，调用该接口
     * @param method
     * @param args
     * @param e
     */
    void afterThrowing(Method method, Object[] args, Throwable e);
}
