package org.hotilsframework.lang;

import java.io.Serializable;

/**
 * 可构建的
 *
 * 建造者模式接口定义
 * @author hireny
 * @className Buildable
 * @create 2020-02-26 23:39
 */
public interface Buildable<T> extends Serializable {
    /**
     * 构建
     * @return  被构建的对象
     */
    T build();
}
