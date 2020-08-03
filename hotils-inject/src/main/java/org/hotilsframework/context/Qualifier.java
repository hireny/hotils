package org.hotilsframework.context;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Qualifier
 *
 * 限定符
 *
 * @author hireny
 * @create 2020-07-27 23:11
 */
public interface Qualifier<T> {

    /**
     * 返回合格的选项，如果不合格，则返回null
     * @param type          类型
     * @param candidates    限定条件
     * @return
     */
    Stream<? extends T> reduce(Class<T> type, Stream<? extends T> candidates);

    /**
     * Whether this qualifier contains the given qualifier.
     * 此限定符是否包含在给定限定符中
     * @param qualifier         限定符 - 用于指定别名的服务
     * @return
     */
    default boolean contains(Qualifier<T> qualifier) {
        return equals(qualifier);
    }

    /**
     * 从限定名单中选取限定信息
     * @param type          类型
     * @param candidated    限定条件
     * @return
     */
    default Optional<? extends T> qualifier(Class<T> type, Stream<? extends T> candidated) {
        return reduce(type, candidated).findFirst();
    }
}
