package org.hotilsframework.utils;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

/**
 * 随机数生成工具类
 * @ClassName: RandomUtils
 * @Author: hireny
 * @Date: Created in 2020-01-22 13:49
 * @Version: 1.0
 */
public final class RandomUtils {
    private RandomUtils() {}

    /**
     * 伪随机数
     * @return
     */
    public static Random getRandom() {
        return new Random();
    }

    /**
     * 安全的随机数
     * @return
     */
    public static SecureRandom getSecureRandom() {
        return new SecureRandom();
    }

    /**
     * 生成随机数
     * @return
     */
    public static String generateSecureRandom(int length) {
        SecureRandom random = getSecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        String salt = Arrays.toString(Base64.getEncoder().encode(bytes));
        return salt;
    }

    /**
     * 获取随机数[0,2^32)
     * @return  随机数
     */
    public static int randomInt() {
        return getRandom().nextInt();
    }
}
