package org.hotilsframework.beans;

import org.hotilsframework.lang.Nullable;

/**
 * 元数据元素接口
 * @author hireny
 * @className BeanMetadataElement
 * @create 2020-04-08 12:20
 */
public interface BeanMetadataElement {

    /**
     * 获取元数据元素
     * @return
     */
    @Nullable
    default Object getSource() {
        return null;
    }
}
