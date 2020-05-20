package org.hotilsframework.lang;

import org.hotilsframework.core.collect.Lists;
import org.hotilsframework.utils.Assert;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
        Assert.notNull(separator);
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
        Assert.notNull(cs);

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

    /**
     * 分离
     * @param cs
     * @return
     */
    public List<String> splitToList(CharSequence cs) {
        Assert.notNull(cs);

        Iterator<String> iterator = splittingIterator(cs);
        List<String> result = Lists.newArrayList();

        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        return Collections.unmodifiableList(result);
    }

    /**
     * 分离
     * @param cs
     * @return
     */
    public String[] splitToArray(CharSequence cs) {
        Assert.notNull(cs);

        List<String> list = splitToList(cs);
        return (String[]) list.toArray();
    }


    private interface Strategy {
        Iterator<String> iterator(Splitter splitter, CharSequence toSplit);
    }
}
