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
}
