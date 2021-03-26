package org.hotilsframework.core.factory;


/**
 * ObjectFactory
 *
 * 对象工厂
 *
 * @author hireny
 * @date Create in 2019/12/08 14:05
 */
@FunctionalInterface
public interface ObjectProvider {
    /**
     * 对象获取
     * @return
     */
    Object get();
}
