package org.hotilsframework.lang.primitives;

/**
 * @ClassName: Floats
 * @Author: hireny
 * @Date: Created in 2020-01-30 13:45
 * @Version: 1.0
 */
public final class Floats {

    /**
     * Return the same value as {@link Float#hashCode(float)}}.
     * @deprecated as of Spring Framework 5.0, in favor of the native JDK 8 variant
     */
    public static int hashCode(float flt) {
        return Float.hashCode(flt);
    }
}
