package org.hotilsframework.lang;


import org.hotilsframework.utils.Assert;

import java.io.IOException;
import java.util.Iterator;

/**
 * Joiner
 * 连接器
 * @Author: hireny
 * @Date: Create in 2019/10/24 00:49
 */
public class Joiner {
    /**
     * 返回一个连接器，该连接器自动在连续元素之间放置分隔符
     * @param separator
     * @return
     */
    public static Joiner on(String separator) {
        return new Joiner(separator);
    }

    public static Joiner on(char separator) {
        return on(String.valueOf(separator));
    }

    /**
     * 分隔符
     */
    private final String separator;

    private Joiner(String separator) {
        Assert.notNull(separator);
        this.separator = separator;
    }

    private Joiner(Joiner prototype) {
        this.separator = prototype.separator;
    }

    public <A extends Appendable> A appendTo(A appendable, Iterator<?> parts) throws IOException {
        Assert.notNull(appendable);
        if (parts.hasNext()) {
            appendable.append(toString(parts.next()));
            while (parts.hasNext()) {
                appendable.append(separator);
                appendable.append(toString(parts.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder appendTo(StringBuilder builder, Iterator<?> parts) {
        try {
            appendTo((Appendable) builder, parts);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        return builder;
    }

    /**
     * 连接
     * @param parts
     * @return
     */
    public final String join(Iterator<?> parts) {
        return  appendTo(new StringBuilder(), parts).toString();
    }

    CharSequence toString(Object part) {
        Assert.notNull(part);
        return (part instanceof CharSequence) ? (CharSequence) part : part.toString();
    }
}
