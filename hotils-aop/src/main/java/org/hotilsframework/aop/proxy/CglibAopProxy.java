package org.hotilsframework.aop.proxy;

import java.io.Serializable;

/**
 * @ClassName: CglibProxy
 * @Author: hireny
 * @Date: Create in 2020/01/06 01:54
 * @Description: TODO   CGLIB代理
 */
public class CglibAopProxy implements AopProxy, Serializable {
    private static final long serialVersionUID = 2359375337088685766L;


    @Override
    public Object getProxy() {
        return getProxy(null);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
//        Class<?> rootClass =
        return null;
    }
}
