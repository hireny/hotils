package org.hotilsframework.core;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * MoreObjects
 *
 * 对Objects工具类的扩展
 *
 * @author hireny
 * @create 2020-08-03 8:47
 */
public final class MoreObjects {
    private MoreObjects() {
        throw new AssertionError("不能实例化");
    }
    private static final int INITIAL_HASH = 7;
    private static final int MULTIPLIER = 31;

    private static final String EMPTY_STRING = "";
    private static final String NULL_STRING = "null";
    private static final String ARRAY_START = "{";
    private static final String ARRAY_END = "}";
    private static final String EMPTY_ARRAY = ARRAY_START + ARRAY_END;
    private static final String ARRAY_ELEMENT_SEPARATOR = ", ";

    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }

        if (o instanceof Optional) {

            return !((Optional<?>) o).isPresent();
        } else if (o instanceof CharSequence) {

            return ((CharSequence) o).length() == 0;
        } else if (o.getClass().isArray()) {

            return Array.getLength(o) == 0;
        } else if (o instanceof Collection) {

            return ((Collection<?>) o).isEmpty();
        } else if (o instanceof Map) {

            return ((Map<?,?>) o).isEmpty();
        }
        return false;
    }

    /**
     * 比较两个对象是否相等
     * @param o1
     * @param o2
     * @return
     */
    public static boolean equals(Object o1, Object o2) {
        // 两个对象的引用相等，即两个对象相等
        if (o1 == o2) {
            return true;
        }

        // 如果两个对象中有一个为空，即两个对象不相等
        if (o1 == null || o2 == null) {
            return false;
        }

        // 如果两个类不相等，即两个对象不相等
        if (o1.getClass() != o2.getClass()) {
            return false;
        }

        if (o1.getClass().isPrimitive() || o1 instanceof String) {
            // 如果是基本类型或是字符串类型
            return o1.equals(o2);
        }

        return Objects.equals(o1, o2);
    }
}
