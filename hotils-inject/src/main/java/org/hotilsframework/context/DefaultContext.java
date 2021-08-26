package org.hotilsframework.context;

import org.hotilsframework.inject.factory.BeanFactory;

/**
 * DefaultBeanContext
 *
 * 默认实现的Bean上下文
 *
 * <p>
 *     用于实现Bean类的加载
 * </p>
 *
 * @author hireny
 * @create 2020-07-27 23:15
 */
public class DefaultContext extends AbstractContext {


    public DefaultContext(Context parent) {
        super(parent);
    }

    public DefaultContext(Context parent, BeanFactory provider) {
        super(parent, provider);
    }
}
