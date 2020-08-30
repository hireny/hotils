package org.hotilsframework.core;

import java.io.Serializable;

/**
 * 元素抽象类，是对对象的抽象建模
 * @author hireny
 * @className Element
 * @create 2020-05-17 23:01
 */
public interface Element extends Serializable {
    /**
     * 返回资源对象，该对象包含有关此元素的信息
     * @return
     */
    Object getElement();
}
