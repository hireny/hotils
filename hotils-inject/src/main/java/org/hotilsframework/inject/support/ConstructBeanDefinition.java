package org.hotilsframework.inject.support;

import org.hotilsframework.inject.BeanDefinition;
import org.hotilsframework.inject.factory.config.Scope;

/**
 * GenericBeanDefinition
 *
 * 建造BeanDefinition，是默认实现的类
 *
 * @author hireny
 * @create 2020-08-06 20:10
 */
public class ConstructBeanDefinition extends AbstractBeanDefinition {
    private static final long serialVersionUID = -7076405082212693150L;

    public ConstructBeanDefinition(BeanDefinition parent, Class<?> type, String name, Scope scope, boolean lazyInit) {
        super(parent, type, name, scope, lazyInit);
    }
}
