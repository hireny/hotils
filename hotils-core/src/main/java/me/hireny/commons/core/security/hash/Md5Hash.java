package me.hireny.commons.core.security.hash;

import me.hireny.commons.core.security.MessageDigest;
import me.hireny.commons.core.security.MessageDigestConstants;

/**
 * Md5Hash
 * MD5 哈希算法
 * @Author: hireny
 * @Date: Create in 2019/10/08 00:07
 */
public class Md5Hash extends MessageDigest {

    /**
     * MD5编码
     * @param data
     * @return
     */
    @Override
    public byte[] encrypt(byte[] data) {
        return this.encrypt(data, MessageDigestConstants.MD5_KEY);
    }
}
