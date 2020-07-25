package org.hotilsframework.security.crypto;

/**
 * @ClassName: Encryptor
 * @Author: hireny
 * @Date: Create in 2020/01/06 11:02
 * @Description: TODO   加密机
 */
public interface Encryptor {

    /**
     * 加密
     * @param key               密钥
     * @param content           需要加密的内容
     * @return                  加密结果
     * @throws CryptoException  加密异常
     */
    byte[] encrypt(String key, byte[] content) throws CryptoException;

    /**
     * 解密
     * @param key               密钥
     * @param content           需要解密的内容
     * @return                  解密结果
     * @throws CryptoException  解密异常
     */
    byte[] decrypt(String key, byte[] content) throws CryptoException;
}
