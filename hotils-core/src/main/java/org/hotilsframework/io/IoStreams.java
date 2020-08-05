package org.hotilsframework.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/**
 * IoStreams
 *
 * IO流处理工具
 *
 * @author hireny
 * @create 2020-07-07 10:29
 */
public final class IoStreams {

    private IoStreams() {
        throw new AssertionError("不可实例化");
    }

    public static void close(Closeable... closeables) throws IOException {
        close(Arrays.asList(closeables));
    }

    public static void close(Iterable<Closeable> closeables) throws IOException {
        for (Closeable closeable : closeables) {
            closeable.close();
        }
    }
}
