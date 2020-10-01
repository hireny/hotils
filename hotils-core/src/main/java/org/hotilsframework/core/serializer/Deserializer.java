package org.hotilsframework.core.serializer;

import java.io.IOException;
import java.io.InputStream;

/**
 * 反序列化
 * @author hireny
 * @date Create in 2019/08/04 19:31
 */
@FunctionalInterface
public interface Deserializer<T> {

    /**
     * 反序列化
     * Read (assemble) an object of type T from the given InputStream.
     * 从给定的InputStream中读取(组装)一个类型为T的对象
     * @param inputStream
     * @return
     * @throws IOException
     */
    T deserialize(InputStream inputStream) throws IOException;
}
