package org.hotilsframework.core.codec.hash;

/**
 * Hashing
 * Hash算法帮助类
 *
 * 根据不同的Hash算法生成
 *
 * @author hireny
 * @create 2020-07-14 9:28
 */
public class Hashing {

    /**
     * 使用零值种子返回一个murmur3算法实现的32位hash值
     * @return
     */
    public HashFunc murmur3_32() {
        return null;
    }

    /**
     * 使用零值种子返回一个murmur3算法实现的128位的hash值
     * @return
     */
    public HashFunc murmur3_128() {
        return null;
    }

    /**
     * sipHash24算法
     * @return
     */
    public HashFunc sipHash24() {
        return null;
    }

    /**
     * md5加密算法
     * @return
     */
    public HashFunc md5() {
        return null;
    }

    /**
     * sha1加密算法
     * @return
     */
    public HashFunc sha1() {
        return null;
    }

    /**
     * sha256加密算法
     * @return
     */
    public HashFunc sha256() {
        return null;
    }

    /**
     * sha384加密算法
     * @return
     */
    public HashFunc sha384() {
        return null;
    }

    /**
     * sha512加密算法
     * @return
     */
    public HashFunc sha512() {
        return null;
    }

    /**
     * hmacMD5加密算法
     * @return
     */
    public HashFunc hmacMd5() {
        return null;
    }

    /**
     * hmacSHA1加密算法
     * @return
     */
    public HashFunc hmacSha1() {
        return null;
    }

    /**
     * hmacSha256加密算法
     * @return
     */
    public HashFunc hmacSha256() {
        return null;
    }

    /**
     * hmacSHA256加密算法
     * @return
     */
    public HashFunc hmacSha512() {
        return null;
    }

    /**
     * CRC32C效验算法
     * @return
     */
    public HashFunc crc32c() {
        return null;
    }

    /**
     * CRC32效验算法
     * @return
     */
    public HashFunc crc32() {
        return null;
    }

    /**
     * Adler-32效验算法
     * @return
     */
    public HashFunc adler32() {
        return null;
    }

    /**
     * 一致性Hash算法
     * @return
     */
    public HashFunc consistent() {
        return null;
    }

    /**
     * 将多个Hash值拼接在一起。
     *
     * 比如你想要1024位的一个hash，你就可以 concatenating(Hashing.sha512(), Hashing.sha512())
     * @param first
     * @param second
     * @param rest
     * @return
     */
    public HashFunc concatenating(HashFunc first, HashFunc second, HashFunc... rest) {
        return null;
    }
}
