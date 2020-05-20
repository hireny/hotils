package org.hotilsframework.lang;

import java.io.Serializable;

/**
 * 元素类
 * 用于标注被该接口实现的类都是资源元素，获取资源
 * @author hireny
 * @className Element
 * @create 2020-05-17 23:01
 */
public interface Element extends Serializable {
    /**
     * 返回资源对象，该对象包含有关此元素的信息
     * @return
     */
    Object getSource();

    /**
     * 获取资源对象类型
     * @return
     */
    Class<?> getSourceType();
}
