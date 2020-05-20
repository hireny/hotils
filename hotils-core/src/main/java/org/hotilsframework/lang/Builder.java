package org.hotilsframework.lang;

import org.hotilsframework.core.collect.Lists;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 通用构建器Builder
 * @author hireny
 * @className Builder
 * @create 2020-02-26 23:23
 */
public class Builder<T> {

    private final Supplier<T> instantiator;
    private List<Consumer<T>> modifiers = Lists.newArrayList();

    public Builder(Supplier<T> instantiator) {
        this.instantiator = instantiator;
    }

    public <P> Builder<T> with(OneConsumer<T, P> oneConsumer, P p) {
        Consumer<T> consumer = instance -> oneConsumer.accept(instance, p);
        modifiers.add(consumer);
        return this;
    }

    public <P1, P2> Builder<T> with(TwoConsumer<T, P1, P2> twoConsumer, P1 p1, P2 p2) {
        Consumer<T> consumer = instance -> twoConsumer.accept(instance, p1, p2);
        modifiers.add(consumer);
        return this;
    }

    public <P1, P2, P3> Builder<T> with(ThreeConsumer<T, P1, P2, P3> threeConsumer, P1 p1, P2 p2, P3 p3) {
        Consumer<T> consumer = instance -> threeConsumer.accept(instance, p1, p2, p3);
        modifiers.add(consumer);
        return this;
    }

    public T build() {
        T value = instantiator.get();
        modifiers.forEach(modifier -> modifier.accept(value));
        modifiers.clear();
        return value;
    }

    public static <E> Builder<E> of(Supplier<E> instantiator) {
        return new Builder<>(instantiator);
    }

    /**
     * 一个 Consumer消费者
     * @param <T>
     * @param <P>
     */
    @FunctionalInterface
    public interface OneConsumer<T, P> {
        void accept(T t, P p);
    }

    /**
     * 两个 Consumer 消费者
     * @param <T>
     * @param <P1>
     * @param <P2>
     */
    @FunctionalInterface
    public interface TwoConsumer<T, P1, P2> {
        void accept(T t, P1 p1, P2 p2);
    }

    /**
     * 三个 Consumer 消费者
     * @param <T>
     * @param <P1>
     * @param <P2>
     * @param <P3>
     */
    @FunctionalInterface
    public interface ThreeConsumer<T, P1, P2, P3> {
        void accept(T t, P1 p1, P2 p2, P3 p3);
    }
}
