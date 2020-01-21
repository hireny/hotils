package org.hotilsframework.utils;

import java.util.function.Supplier;

/**
 * Assert
 * 断言
 * @Author: hireny
 * @Date: Create in 2019/10/03 22:33
 */
public class Assert {

    /**
     * check state 检查状态
     * Assert a boolean expression, throwing an {@code IllegalStateException}
     * 断言一个布尔表达式，抛出一个 IllegalStateException 异常
     * @param expression
     * @param message
     */
    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new IllegalStateException(message);
        }
    }

    /**
     *  Assert a boolean expression, throwing an {@code IllegalStateException}
     *  断言一个布尔表达式，抛出一个 IllegalStateExpression 异常
     * @param expression
     */
    public static void state(boolean expression) {
        state(expression, "[Assertion failed] - this state invariant must be true");
    }

    /**
     * check argument 检查参数是否异常
     * Assert a boolean expression, throwing an {@code IllegalArgumentException}
     * 断言一个布尔表达式，抛出一个 IllegalArgumentException 异常
     * @param expression
     * @param message
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert a boolean expression, throwing an {@code IllegalArgumentException}
     * 断言一个布尔表达式，抛出一个 IllegalArgumentExpression 异常
     * @param expression
     */
    public static void isTure(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    /**
     * 检查索引是否超出大小
     * @param index
     * @param size
     * @return
     */
    public static int checkElementIndex(int index, int size) {
        return checkElementIndex(index, size, "index");
    }

    /**
     * 检查索引是否超出大小
     * @param index
     * @param size
     * @param message
     * @return
     */
    public static int checkElementIndex(int index, int size,  String message) {
        if (index < 0 || index >= size) {
//            throw new IndexOutOfBoundsException(badElementIndex(index, size, message));
            throw new IndexOutOfBoundsException(message);
        }
        return index;
    }

    //    private static String badElementIndex(int index, int size,  String message) {
//        if (index < 0) {
//            return lenientFormat("%s (%s) must not be negative", message, index);
//        } else if (size < 0) {
//            throw new IllegalArgumentException("negative size: " + size);
//        } else { // index >= size
//            return lenientFormat("%s (%s) must be less than size (%s)", message, index, size);
//        }
//    }

    private static String badPositionIndex(int index, int size,  String desc) {
//        if (index < 0) {
//            return lenientFormat("%s (%s) must not be negative", desc, index);
//        } else if (size < 0) {
//            throw new IllegalArgumentException("negative size: " + size);
//        } else { // index > size
//            return lenientFormat("%s (%s) must not be greater than size (%s)", desc, index, size);
//        }
        return null;
    }

    /**
     * 检查开始与结束下标是否超出大小
     * @param start
     * @param end
     * @param size
     */
    public static void checkPositionIndexes(int start, int end, int size) {
        if (start < 0 || end < start || end > size) {
            throw new IndexOutOfBoundsException(badPositionIndexes(start, end, size));
        }
    }

    private static String badPositionIndexes(int start, int end, int size) {
        if (start < 0 || start > size) {
            return badPositionIndex(start, size, "start index");
        }
        if (end < 0 || end > size) {
            return badPositionIndex(end, size, "end index");
        }
        // end < start
//        return lenientFormat("end index (%s) must not be less than start index (%s)", end, start);
        return null;
    }

    /**
     * Assert that an object is {@code null}.
     * 断言一个对象，判断是否为空
     * @param object
     * @param message
     */
    public static void isNull( Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull( Object object, Supplier<String> messageSupplier) {
        if (object != null) {
            throw new IllegalArgumentException(nullSafeGet(messageSupplier));
        }
    }

    /**
     * Assert that an object is {@code null}
     * 断言一个对象是否为空
     * @param object
     */
    public static void isNull( Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    /**
     * Assert that an object is not {@code null}.
     * 断言一个对象是否不为空
     * @param reference
     */
    public static <T extends Object> T checkNotNull( T reference) {
        return checkNotNull(reference, "[Assertion failed] - this argument is required; it must not be null");
    }

    /**
     * Assert that an object is not {@code null}.
     * 断言一个对象是否不为空
     * @param reference
     * @param message
     */
    public static <T extends Object> T checkNotNull( T reference, String message) {
        if (reference == null) {
            throw new IllegalArgumentException(message);
        }
        return reference;
    }

    public static <T extends Object> T checkNotNull( T reference, Supplier<String> messageSupplier) {
        if (reference == null) {
            throw new IllegalArgumentException(nullSafeGet(messageSupplier));
        }
        return reference;
    }

    /**
     * Assert that the given String is not empty; that is, it must not be {@code null} and not the empty String.
     * 断言给定的字符串不是空的，也就是说，它必须不是 null，也不是空的字符串
     * @param text
     * @param message
     */
    public static void hasLength( String text, String message) {
        if (!StringUtils.hasLength(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that the given String is not empty; that is, it must not be {@code null} and not the empty String.
     * 断言给定的字符串不是空的，也就是说，它必须不是 null，也不是空的字符串
     * @param text
     */
    public static void hasLength( String text) {
        hasLength(text, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }


    /**
     * Assert that the given String contains valid text content; that is, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">Assert.hasText(name, "'name' must not be empty");</pre>
     * @param text the String to check
     * @param message the exception message to use if the assertion fails
     * @throws IllegalArgumentException if the text does not contain valid text content
     * @see StringUtils#hasText
     */
    public static void hasText(String text, String message) {
        if (StringUtils.hasText(text)) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * Assert that the given String contains valid text content; that is, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * <pre class="code">
     * Assert.hasText(name, () -&gt; "Name for account '" + account.getId() + "' must not be empty");
     * </pre>
     * @param text the String to check
     * @param messageSupplier a supplier for the exception message to use if the
     * assertion fails
     * @throws IllegalArgumentException if the text does not contain valid text content
     * @since 5.0
     * @see StringUtils#hasText
     */
    public static void hasText( String text, Supplier<String> messageSupplier) {
        if (StringUtils.hasText(text)) {
            throw new IllegalArgumentException(nullSafeGet(messageSupplier));
        }
    }

    /**
     * Assert that the given String contains valid text content; that is, it must not
     * be {@code null} and must contain at least one non-whitespace character.
     * @deprecated as of 4.3.7, in favor of {@link #hasText(String, String)}
     */
    @Deprecated
    public static void hasText( String text) {
        hasText(text,
                "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    
    private static String nullSafeGet( Supplier<String> messageSupplier) {
        return (messageSupplier != null ? messageSupplier.get() : null);
    }
}
