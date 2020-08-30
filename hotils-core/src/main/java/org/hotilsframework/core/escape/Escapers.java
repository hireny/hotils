package org.hotilsframework.core.escape;

import org.hotilsframework.lang.Assert;

/**
 * @ClassName: Escapers
 * @Author: hireny
 * @Date: Created in 2020-01-13 19:43
 * @Version: 1.0
 */
public final class Escapers {

    private Escapers() {}

    public static AbstractEscaper nullEscaper() {
        return NULL_ABSTRACT_ESCAPER;
    }

    private static final AbstractEscaper NULL_ABSTRACT_ESCAPER =
            new CharAbstractEscaper() {
                @Override
                public String escape(String string) {
                    return Assert.notNull(string);
                }

                @Override
                protected char[] escape(char c) {
                    // TODO: Fix tests not to call this directly and make it throw an error.
                    return null;
                }
            };
}
