package org.hotilsframework.aop.proxy;

/**
 * @ClassName: AopProxy
 * @Author: hireny
 * @Date: Create in 2020/01/06 01:53
 * @Description: TODO   AOP代理
 */
public interface AopProxy {
    Object getProxy();
    Object getProxy(ClassLoader classLoader);
}
