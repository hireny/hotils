package org.hotilsframework.utils;

import java.io.*;

/**
 * 序列化工具类
 * @ClassName: SerializationUtils
 * @Author: hireny
 * @Date: Created in 2020-01-25 20:39
 * @Version: 1.0
 */
public final class SerializationUtils {

    /**
     * 序列化
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to serialize object of type: " + object.getClass(), e);
        }
        return baos.toByteArray();
    }

    /**
     * 反序列化
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes))) {
            return ois.readObject();
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to deserialize object", e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Failed to deserialize object type", e);
        }
    }
}
