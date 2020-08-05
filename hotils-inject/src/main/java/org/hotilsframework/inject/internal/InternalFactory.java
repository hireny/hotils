package org.hotilsframework.inject.internal;

import org.hotilsframework.context.BeanContext;

/**
 * InternalFactory
 * 类描述
 *
 * @author hireny
 * @create 2020-08-05 20:47
 */
public interface InternalFactory<T> {
    /**
     * 获取对象
     * @param beanContext
     * @return
     */
    T get(BeanContext beanContext);
}
