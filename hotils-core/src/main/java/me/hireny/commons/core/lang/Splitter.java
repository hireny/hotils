package me.hireny.commons.core.lang;

import me.hireny.commons.utils.Assert;

import java.util.Iterator;

/**
 * Splitter
 * 分离器
 * @Author: hireny
 * @Date: Create in 2019/10/24 00:50
 */
public final class Splitter {

    public static Splitter on(final char separator) {
        return on(separator);
    }

    public static Splitter on(final CharSequence separator) {
        Assert.checkNotNull(separator);
        return new Splitter(separator);
    }

    /**
     * 分隔符
     */
    private final CharSequence separator;


    private Splitter(CharSequence separator) {
        this.separator = separator;
    }

    public Splitter limit(int maxItems) {
        Assert.isTrue(maxItems > 0, "must be greater than zero: " + maxItems);
//        return new Splitter();
        return this;
    }

    /**
     * 分隔
     * @param cs
     * @return
     */
    public Iterable<String> split(final CharSequence cs) {
        Assert.checkNotNull(cs);

        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return splittingIterator(cs);
            }

            @Override
            public String toString() {
                return super.toString();
            }
        };
    }

    private Iterator<String> splittingIterator(CharSequence cs) {
        return null;
    }
}
