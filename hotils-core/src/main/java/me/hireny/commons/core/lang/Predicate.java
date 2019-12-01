package me.hireny.commons.core.lang;

/**
 * @ClassName: Predicate
 * @Author: hireny
 * @Date: Create in 2019/11/07 21:50
 * @Description: TODO
 */
public interface Predicate<T> extends java.util.function.Predicate<T> {

    boolean apply(T input);

    boolean equals(Object object);

    @Override
    default boolean test(T t) {
        return apply(t);
    }
}
