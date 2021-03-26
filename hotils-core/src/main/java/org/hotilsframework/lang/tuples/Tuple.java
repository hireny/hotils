package org.hotilsframework.lang.tuples;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 元组接口
 * @ClassName: TupleInterface
 * @Author: hireny
 * @Date: Created in 2020-01-21 9:36
 * @Version: 1.0
 */
public interface Tuple extends Iterable<Object>, Serializable {

    /**
     * 返回元组中元素的数量
     * @return  元组中元素的数量
     */
    int size();

    /**
     * 如果元组中包含指定的元素，返回 true；否则返回 false
     *
     * @param value 要查找的元素
     * @return 如果元组中包含指定的元素，返回 true
     */
    boolean contains(Object value);

    /**
     * 如果元组中包含指定的集合元素，返回 true；否则返回 false
     * @param collection    要查找的集合
     * @return  如果元组中包含指定的集合，返回 true
     */
    boolean contains(final Collection<?> collection);

    /**
     * 如果元组汇总包含指定的参数数组，返回true；否则返回 false
     * @param values       要查找的可变参数
     * @return  如果元组中包含指定的可变参数，返回 true
     */
    boolean contains(final Object... values);

    /**
     * 获取元素位置
     * @param value     要查找的值
     * @return          元素的位置
     */
    int indexOf(final Object value);

    /**
     * 获取元素位置
     * @param value     要查找的值
     * @return          元素的位置
     */
    int lastIndexOf(final Object value);

    /**
     * 获取元组中所有的值
     * @return  以列表的形式返回元组的值
     */
    List<Object> toList();

    /**
     * 获取元组中所有的值
     * @return  以数组的形式返回元组的值
     */
    Object[] toArray();
}
