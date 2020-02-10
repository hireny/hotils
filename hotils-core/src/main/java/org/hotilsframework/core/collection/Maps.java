package org.hotilsframework.core.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;

/**
 * @ClassName: Maps
 * @Author: hireny
 * @Date: Create in 2019/11/05 14:38
 * @Description: TODO
 */
public final class Maps {

    private Maps() {}

    /**
     * 创建HashMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    /**
     * 创建LinkedHashMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    /**
     * 创建TreeMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    /**
     * 创建WeakHashMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> WeakHashMap<K, V> newWeakHashMap() {
        return new WeakHashMap<>();
    }
}
