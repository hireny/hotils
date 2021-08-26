package org.hotilsframework.inject.factory;

import org.hotilsframework.context.Context;

/**
 * Factory
 * 类描述
 *
 * @author hireny
 * @create 2021-05-20 21:38
 */
public interface Factory {

    /**
     * 通过上下文在工厂中获取对应的元素
     * @param context
     * @param <T>
     * @return
     */
    <T> T get(Context context);
}
