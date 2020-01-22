package org.hotilsframework.utils;

import java.security.SecureRandom;
import java.util.Base64;

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
     * 生成随机数
     * @return
     */
    public static String generateRandom(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        String salt = Base64.getEncoder().encode(bytes).toString();
        return salt;
    }
}
