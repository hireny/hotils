package org.hotilsframework.aop;

import org.hotilsframework.utils.ClassUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 基于JDK动态代理的代理对象生成器
 * @ClassName: JdkDynamicProxy
 * @Author: hireny
 * @Date: Create in 2020/01/06 01:54
 * @Description: TODO   JDK动态代理
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler, Serializable {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

    @Override
    public Object getProxy() {
        return ClassUtils.getDefaultClassLoader();
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
