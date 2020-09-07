package org.hotilsframework.io;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/**
 * 输入输出流工具
 * @author hireny
 * @className StreamUtils
 * @create 2020-06-16 21:00
 */
public final class StreamUtils {
    /**
     * The default buffer size used why copying bytes.
     * 用于复制字节的默认缓冲区大小
     */
    public static final int BUFFER_SIZE = 4096;

    public static final byte[] EMPTY_CONTENT = new byte[0];

    private StreamUtils() {
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
