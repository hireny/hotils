package org.hotilsframework.core.serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 *
 * JDK反序列化
 *
 * @author hireny
 * @date Create in 2019/08/04 19:33
 */
public class JdkDeserializer implements ObjectDeserializer<Object> {

    private final ClassLoader classLoader;

    public JdkDeserializer() {
        this(null);
    }

    public JdkDeserializer(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /**
     * 从提供的 {@code InputStream} 中读取并反序列化内容
     * @param inputStream
     * @return
     * @throws IOException
     */
    @Override
    public Object deserialize(InputStream inputStream) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        try {
            return objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Failed to deserialize object type", e);
        }
    }
}
