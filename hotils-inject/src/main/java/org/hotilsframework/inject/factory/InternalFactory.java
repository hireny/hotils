package org.hotilsframework.inject.factory;

import org.hotilsframework.context.Context;

/**
 * InternalFactory
 *
 * 内部工厂，用来创建要注入的对象
 *
 * @author hireny
 * @create 2020-08-05 20:47
 */
public interface InternalFactory<T> {

    /**
     * 根据上下文获取对象
     * @param context
     * @return
     */
    T get(Context context);
}
