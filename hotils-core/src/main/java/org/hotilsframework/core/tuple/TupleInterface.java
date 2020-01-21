package org.hotilsframework.core.tuple;

import java.io.Serializable;
import java.util.List;

/**
 * 元组接口
 * @ClassName: TupleInterface
 * @Author: hireny
 * @Date: Created in 2020-01-21 9:36
 * @Version: 1.0
 */
public interface TupleInterface extends Serializable {

    /**
     * 返回元组中元素的数量
     * @return  元组中元素的数量
     */
    int size();

    /**
     * 如果元组中包含指定名称，返回true，否则返回false
     * @param name  元素的名称
     * @return      如果元组中包含指定的名称，返回true
     */
    boolean contains(String name);

    /**
     * 如果元组中包含指定的元素，返回 true；否则返回 false
     *
     * @param value 要查找的元素
     * @return 如果元组中包含指定的元素，返回 true
     */
    boolean contains(Object value);

    /**
     * 获取元组中所有的值
     *
     * @return 元组中所有的值
     */
    List<Object> getValues();
}
