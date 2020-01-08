package me.hireny.commons.core.codec;

/**
 * Encoder
 * 编码
 * @Author: hireny
 * @Date: Create in 2019/10/03 14:17
 */
public interface Encoder {
    /**
     * 获取编码对象
     * @return
     */
    Encoder getEncoder();

    /**
     * 编码
     * @param data
     * @return
     */
    byte[] encoder(byte[] data);
}
