package org.hotilsframework.inject;

import org.hotilsframework.lang.Nullable;

/**
 * BeanMetaDataElement
 *
 * Bean元数据元素
 *
 * @author hireny
 * @create 2020-12-03 10:49
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
