package org.hotilsframework.collect;

import java.util.Collection;

/**
 * @className ImmutableCollection
 *
 * 不可变的集合类
 *
 * @author hireny
 * @create 2020-06-17 20:16
 */
public interface ImmutableCollection<E> extends Collection<E> {

    /**
     * {@link ImmutableCollection} 类型的构建器的抽象类
     * @param <E>
     */
    public abstract static class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

    }
}
