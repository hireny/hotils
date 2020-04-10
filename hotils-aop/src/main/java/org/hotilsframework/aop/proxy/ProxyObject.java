package org.hotilsframework.aop.proxy;

/**
 * 代理对象
 * @ClassName: ProxyObject
 * @Author: hireny
 * @Date: Created in 2020-01-31 0:05
 * @Version: 1.0
 */
public interface ProxyObject {

    /**
     * 判断是否是代理的目标类
     * @return
     */
    boolean isProxyTargetClass();

    /**
     * 获取代理的接口
     * @return
     */
    Class<?>[] getProxiedInterfaces();

    /**
     * 判断是否是接口代理
     * @param intf
     * @return
     */
    boolean isInterfaceProxied(Class<?> intf);
}
