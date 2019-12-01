package me.hireny.commons.core.io.serializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * @Author: hireny
 * @Date: Create in 2019/08/04 19:33
 */
public class DefaultDeserializer implements Deserializer<Object> {

    private final ClassLoader classLoader;

    public DefaultDeserializer() {
        this(null);
    }

    public DefaultDeserializer(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

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
