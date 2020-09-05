package org.hotilsframework.collect;

import org.hotilsframework.lang.ArrayUtils;
import org.hotilsframework.lang.Nullable;

import java.util.*;

/**
 * Collections
 * 集合操作
 * @Author: hireny
 * @Date: Create in 2019/10/05 22:46
 */
public class CollectionUtils {

    private CollectionUtils() {}

    /**
     * 判断集合是否为空
     *
     * @param collection 要检查的集合
     * @return 返回给定的集合是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 判断给定的映射是否为空
     * @param map 要检查的映射表
     * @return 返回给定的映射表是否为空
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 获取集合中指定下标的元素值，下标可以为负数，例如-1表示最后一个元素
     * 如果元素越界，返回null
     * @param collection    集合
     * @param index         下标，支持负数
     * @param <T>           元素类型
     * @return              元素值
     */
    public static <T> T get(Collection<T> collection, int index) {
        if (null == collection) {
            return null;
        }
        final int size = collection.size();
        if (0 == size) {
            return null;
        }
        if (index < 0) {
            index += size;
        }
        // 越界检查
        if (index >= size) {
            return null;
        }

        if (collection instanceof List) {
            return  ((List<T>) collection).get(index);
        } else {
            int i = 0;
            for (T t : collection) {
                if (i > index) {
                    break;
                } else if (i == index) {
                    return t;
                }
                i++;
            }
        }
        return null;
    }


    //------------------------------------------------------
    // Convenience methods for working with arrays
    // 方便处理数组的方法
    //------------------------------------------------------

    /**
     * 将集合转换为指定的数组
     * @param collection
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T[] toArray(@Nullable Collection<T> collection, Class<T> clazz) {
        ;
        return (!isEmpty(collection) ?
                collection.toArray(ArrayUtils.newArray(clazz, collection.size()))
                : ArrayUtils.newArray(clazz, 0));
    }

    public static <T> T[] toArray(@Nullable Enumeration<T> enumeration, Class<T> clazz) {
        return (enumeration != null ?
                toArray(Collections.list(enumeration), clazz)
                : ArrayUtils.newArray(clazz, 0));
    }
}
