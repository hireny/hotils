package org.hotilsframework.inject.qualifier;

/**
 * Qualifier
 *
 * 用于限定有多个可能选项的情况下选择的Bean
 *
 * @author hireny
 * @create 2020-07-27 23:11
 */
public interface Qualifier {

    /**
     * 重写equals
     * @param obj
     * @return
     */
    @Override
    boolean equals(Object obj);

    /**
     * 重写hashCode
     * @return
     */
    @Override
    int hashCode();

    /**
     * 返回字符串
     * @return
     */
    @Override
    String toString();


//    /**
//     * Whether this qualifier contains the given qualifier.
//     * 此限定符是否包含在给定限定符中
//     * @param qualifier         限定符 - 用于指定别名的服务
//     * @return
//     */
//    default boolean contains(Qualifier<T> qualifier) {
//        return equals(qualifier);
//    }
//
//    /**
//     * 从限定名单中选取限定信息
//     * @param type          类型
//     * @param candidated    限定条件
//     * @return
//     */
//    default Optional<? extends T> qualifier(Class<T> type, Stream<? extends T> candidated) {
//        return reduce(type, candidated).findFirst();
//    }
}
