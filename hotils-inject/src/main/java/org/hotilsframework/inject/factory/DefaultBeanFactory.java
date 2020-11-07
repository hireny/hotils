package org.hotilsframework.inject.factory;

import org.hotilsframework.inject.factory.config.Scoping;

/**
 * DefaultBeanFactory
 * 类描述
 *
 * @author hireny
 * @create 2020-08-09 20:56
 */
public class DefaultBeanFactory extends AbstractBeanFactory {

    /**
     * 构造器
     */
    public DefaultBeanFactory() {
        super();
    }

    /**
     * 构造器
     * @param scopes
     */
    public DefaultBeanFactory(Scoping... scopes) {
        super(scopes);
    }
}
