package org.hotilsframework.core.lang.primitives;

/**
 * @ClassName: Longs
 * @Author: hireny
 * @Date: Created in 2020-01-30 13:46
 * @Version: 1.0
 */
public class Longs {

    /**
     * Return the same value as {@link Long#hashCode(long)}}.
     * @deprecated as of Spring Framework 5.0, in favor of the native JDK 8 variant
     */
    @Deprecated
    public static int hashCode(long lng) {
        return Long.hashCode(lng);
    }
}
