package org.hotilsframework.collect;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: Maps
 * @Author: hireny
 * @Date: Create in 2019/11/05 14:38
 */
public final class MapUtils {

    private MapUtils() {}

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
     * 创建IdentityHashMap
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<>();
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

    public static <K, V>ConcurrentHashMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap<>();
    }
}
