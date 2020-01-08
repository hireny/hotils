package me.hireny.commons.core.codec;

import java.io.UnsupportedEncodingException;

/**
 * Decoder
 * 解码
 * @Author: hireny
 * @Date: Create in 2019/10/03 14:17
 */
public interface Decoder {
    /**
     * 获取解码对象
     * @return
     */
    Decoder getDecoder();
    /**
     * 解码
     * @param data
     * @return
     */
    byte[] decoder(byte[] data) throws UnsupportedEncodingException;
}
