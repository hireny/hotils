package org.hotilsframework.lang.primitives;

/**
 * @ClassName: Doubles
 * @Author: hireny
 * @Date: Created in 2020-01-30 13:44
 * @Version: 1.0
 */
public final class Doubles {

    private Doubles() {}

    /**
     * Return the same value as {@link Double#hashCode(double)}}.
     * @deprecated as of Spring Framework 5.0, in favor of the native JDK 8 variant
     */
    public static int hashCode(double dbl) {
        return Double.hashCode(dbl);
    }
}
