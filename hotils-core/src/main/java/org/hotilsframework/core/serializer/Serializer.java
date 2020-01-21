package org.hotilsframework.core.serializer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author: hireny
 * @Date: Create in 2019/08/04 19:29
 */
@FunctionalInterface
public interface Serializer<T> {

    /**
     * 序列化
     * Write an object of type T to the given OutputStream.
     * 将类型为T的对象写入给定的OutputStream
     * @param object
     * @param outputStream
     * @throws IOException
     */
    void serialize(T object, OutputStream outputStream) throws IOException;
}
