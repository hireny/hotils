package org.aopalliance.intercept;

/**
 * @author hireny
 * @className ConstructorInterceptor
 * @create 2020-04-09 20:19
 */
public interface ConstructorInterceptor extends Interceptor {

    /**
     * 实现此方法以在构造新对象之前和之后执行额外的处理。
     * @param invocation    连接点
     * @return  新创建的对象，它也是调用 {@link Joinpoint#proceed()} 的结果，可能会被拦截器取代
     * @throws Throwable
     */
    Object construct(ConstructorInvocation invocation) throws Throwable;
}
