package org.hotilsframework.core.codec;

import java.io.UnsupportedEncodingException;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/04 10:27
 */
public interface Codec {


    /**
     * 编码类
     */
    public interface Encoder {

        byte[] encoder(byte[] data);
    }

    /**
     * 解码类
     */
    public interface Decoder {
        /**
         * 解码
         * @param data
         * @return
         */
        byte[] decoder(byte[] data) throws UnsupportedEncodingException;
    }


}
