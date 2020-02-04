package org.hotilsframework.aop;

import java.io.Serializable;

/**
 * 默认的切面代理工厂
 * @ClassName: DefaultAopProxyFactory
 * @Author: hireny
 * @Date: Created in 2020-01-31 0:13
 * @Version: 1.0
 */
public class DefaultAopProxyFactory implements AopProxyFacotry, Serializable {
    private static final long serialVersionUID = 9106721812446917251L;

    @Override
    public AopProxy createAopProxy(ProxyConfig config) {
//        // 在这里进行判断用户是否使用代理的接口，没有代理接口，就使用cglib代理模式
//        if (config.isOpaque() || config.isProxyTargetClass() || hasNoUserSuppliedProxyInterfaces(config)) {
//            Class<?> targetClass = config.getTargetClass();
//            if (targetClass == null) {
//                // TargetSource不能确定目标类，创建代理需要接口或目标
//                throw new AopConfigException("TargetSource cannot determine target class: " +
//                        "Either an interface or a target is required for proxy creation.");
//            }
//            if (targetClass.isInterface() || Proxy.isProxyClass(targetClass)) {
//                // 判断目标类是否是接口或者是代理类
//                return new JdkDynamicAopProxy(config);
//            }
//            // 如果不是接口或者不是代理类，就使用 cglib 代理
//            return new ObjenesisCglibAopProxy(config);
//        }
//        return new JdkDynamicAopProxy(config);
        return null;
    }

    private boolean hasNoUserSuppliedProxyInterfaces(ProxyConfig config) {
//        Class<?>[] ifcs = config.getInterfaces().toArray(new Class[0]);
//        return (ifcs.length == 0 || (ifcs.length == 1 && Proxy.class.isAssignableFrom(ifcs[0])));
        return true;
    }
}
