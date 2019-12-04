package me.hireny.commons.core.security.hash;

import me.hireny.commons.core.security.MessageDigestConstants;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Md5Hash
 * MD5 哈希算法
 * @Author: hireny
 * @Date: Create in 2019/10/08 00:07
 */
public class Md5Hash {

    /**
     * MD5编码
     * @param data
     * @return
     */
    public byte[] encrypt(byte[] data) {
        try {
            // 拿到一个MD5转换器（如果想要SHA1参数换成”Sha1Hash”）
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestConstants.MD5_KEY);
            // inputByteArray是输入字符串转换得到的字节数组
            messageDigest.update(data);
            // 转换并返回结果，也是字节数组，包含16个元素
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
