package org.aopalliance.intercept;

/**
 * @author hireny
 * @className MethodInterceptor
 * @create 2020-04-09 18:14
 */
@FunctionalInterface
public interface MethodInterceptor extends Interceptor {

    /**
     * 实现此方法以在调用之前和调用之后执行额外的处理。
     *
     * 调用 {@link Joinpoint#proceed()} 方法来实现
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    Object invoke(MethodInvocation invocation) throws Throwable;
}
