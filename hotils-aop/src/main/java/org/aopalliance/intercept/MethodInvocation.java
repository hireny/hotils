package org.aopalliance.intercept;

import java.lang.reflect.Method;

/**
 * @author hireny
 * @className MethodInvocation
 * @create 2020-04-09 18:14
 */
public interface MethodInvocation extends Invocation {
    /**
     * 获取被调用的方法
     * 该方法 与 {@link Joinpoint#getStaticPart()} 方法相同
     * @return  返回被调用的方法
     */
    Method getMethod();
}
