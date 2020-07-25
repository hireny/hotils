package org.hotilsframework.core.types;

import org.hotilsframework.lang.Nullable;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Argument
 * Represents an argument to a method or constructor or type.
 *
 * 表示方法、构造函数或类型的参数。
 *
 * @author hireny
 * @create 2020-07-07 10:59
 */
public interface Argument<T> extends TypeVariableResolver, Type {

    /**
     * Constant for string argument.
     */
    Argument<String> STRING = Argument.of(String.class);

    /**
     * Constant for int argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Integer> INT = Argument.of(int.class);

    /**
     * Constant for long argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Long> LONG = Argument.of(long.class);

    /**
     * Constant for float argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Float> FLOAT = Argument.of(float.class);

    /**
     * Constant for double argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Double> DOUBLE = Argument.of(double.class);

    /**
     * Constant for void argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Void> VOID = Argument.of(void.class);

    /**
     * Constant for byte argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Byte> BYTE = Argument.of(byte.class);

    /**
     * Constant for boolean argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Boolean> BOOLEAN = Argument.of(boolean.class);

    /**
     * Constant char argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Character> CHAR = Argument.of(char.class);

    /**
     * Constant short argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Short> SHORT = Argument.of(short.class);

    /**
     * Constant representing zero arguments. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument[] ZERO_ARGUMENTS = new Argument[0];

    /**
     * Default Object argument. Used by generated code, do not remove.
     */
    @SuppressWarnings("unused")
    Argument<Object> OBJECT_ARGUMENT = of(Object.class);

    /**
     * Constant for List<String> argument.
     */
    Argument<List<String>> LIST_OF_STRING = Argument.listOf(String.class);


    Class<T> getType();

    /**
     *
     * @param other
     * @return
     */
    boolean equals(Argument<?> other);

    @Override
    int hashCode();

    /**
     *
     * @param type
     * @param name
     * @param typeParameters
     * @param <T>
     * @return
     */
    @Nullable
    static <T> Argument<T> of(Class<T> type, String name, Argument... typeParameters) {
        return null;
    }

    static <T> Argument<T> of(Class<T> type) {
        return null;
    }

    static <T> Argument<List<T>> listOf(Class<T> type) {
        return null;
    }
}
