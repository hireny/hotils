package org.hotilsframework.codec;

/**
 * ByteDefinition
 *
 * 字节定义
 *
 * @author hireny
 * @create 2021-05-20 21:25
 */
public interface ByteDefinition {
    /**
     * Returns the wrapped byte array.
     *
     * @return the wrapped byte array.
     */
    byte[] getBytes();

    /**
     * 返回字节数组的格式化字符串表示形式
     * @return
     */
    String toHex();

    /**
     * 返回字节数组的Base64的格式化字符串表示形式
     * @return
     */
    String toBase64();

    /**
     * 判断字节资源是否为空
     * @return
     */
    boolean isEmpty();
}
