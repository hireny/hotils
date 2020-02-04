package org.hotilsframework.aop;

/**
 * @ClassName: AopProxyFacotry
 * @Author: hireny
 * @Date: Create in 2020/01/06 01:53
 * @Description: TODO   AOP代理工厂
 */
public interface AopProxyFacotry {
    /**
     * 创建Aop代理
     * @param config
     * @return
     */
    AopProxy createAopProxy(ProxyConfig config);
}
