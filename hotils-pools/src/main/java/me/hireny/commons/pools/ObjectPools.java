package me.hireny.commons.pools;

import java.io.Closeable;

/**
 * @ClassName: ObjectPools
 * @Author: hireny
 * @Date: Create in 2019/12/08 14:06
 * @Description: TODO   对象池的基本接口
 * TODO 提供获取一个对象和释放一个对象的方法
 */
public interface ObjectPools<T> extends Closeable {
    /**
     * 获取一个对象
     * @return
     */
    T get();

    /**
     * 释放一个对象
     * @param t     需要释放的对象资源
     */
    void release(T t);
}
