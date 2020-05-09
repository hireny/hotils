package org.hotilsframework.aop.interceptor;

import org.aopalliance.intercept.Invocation;
import org.hotilsframework.core.Order;

import java.lang.reflect.Method;

/**
 * @author hireny
 * @className TraceInterceptor
 * @create 2020-04-10 15:52
 */
public interface TraceInterceptor extends Order {

    /**
     * 是否匹配
     * @param method    方法
     * @return          true则拦截
     */
    default boolean match(Method method) {
        return false;
    }

    /**
     * 拦截
     * @param invocation    调用封装
     * @return              true为继续执行下一个拦截
     */
    default boolean intercept(Invocation invocation) {
        return true;
    }
}
