package org.hotilsframework.core.factory;

/**
 * ObjectRegistry
 *
 * 对象注册
 *
 * @author hireny
 * @create 2020-08-05 23:58
 */
public interface ObjectRegistry extends AutoCloseable {
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
