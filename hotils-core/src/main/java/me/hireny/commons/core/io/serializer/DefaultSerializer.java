package me.hireny.commons.core.io.serializer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * @Author: hireny
 * @Date: Create in 2019/08/04 19:32
 */
public class DefaultSerializer implements Serializer<Object> {
    @Override
    public void serialize(Object object, OutputStream outputStream) throws IOException {
        if (!(object instanceof Serializable)) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " requires a Serializable payload " +
                    "but received an object of type [" + object.getClass().getName() + "]");
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
    }
}
