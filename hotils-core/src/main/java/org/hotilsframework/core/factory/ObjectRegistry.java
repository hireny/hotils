package org.hotilsframework.core.factory;

import java.io.Closeable;

/**
 * ObjectRegistry
 *
 * 对象注册
 *
 * @author hireny
 * @create 2020-08-05 23:58
 */
public interface ObjectRegistry extends Closeable {
    /**
     * 对象注册
     * @return
     */
    Object register();

    /**
     * 释放对象
     * @param o
     */
    void release(Object o);
}
