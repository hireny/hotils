package org.hotilsframework.utils;

import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
     * 获取随机数生产器
     * @param isSecure  是否为强随机数生成器 (RNG)
     * @return  {@link Random}
     */
    public static Random getRandom(boolean isSecure) {
        return isSecure ? getSecureRandom() : getThreadLocalRandom();
    }

    /**
     * 创建 {@link SecureRandom}，类提供加密的强随机数生成器 {RNG} <br>
     *
     * @param seed  随机种子
     * @return  {@link SecureRandom}
     */
    public static SecureRandom createSecureRandom(byte[] seed) {
        return (null == seed) ? new SecureRandom() : new SecureRandom(seed);
    }

    /**
     * 获取 {@link SecureRandom}，类提供加密的强随机数生成器 <br>
     *     注意：此方法获取的是伪随机序列发生器 PRNG(pseudo-random number generator)
     * 安全的随机数
     * @return
     */
    public static SecureRandom getSecureRandom() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new SecurityException(e);
        }
    }

    /**
     * 获取随机数生成器对象 <br>
     *     ThreadLocalRandom是 JDK 1.7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。
     * @return  {@link ThreadLocalRandom}
     */
    public static ThreadLocalRandom getThreadLocalRandom() {
        return ThreadLocalRandom.current();
    }

    /**
     * 获取随机Boolean值
     * @return  true or false
     */
    public static boolean randomBoolean() {
        return 0 == randomInt(2);
    }

    /**
     * 获取指定范围内的随机数
     * @param min   最小值（包含）
     * @param max   最大值（不包含）
     * @return      随机值
     */
    public static int randomInt(int min, int max) {
        return getThreadLocalRandom().nextInt(min, max);
    }

    /**
     * 获取指定范围内的随机数 [0, limit)
     * @param limit     限制随机数的范围，不包含这个数
     * @return          随机数
     */
    public static int randomInt(int limit) {
        return getThreadLocalRandom().nextInt(limit);
    }

    /**
     * 获取随机数[0,2^32)
     * @return  随机数
     */
    public static int randomInt() {
        return getThreadLocalRandom().nextInt();
    }

    /**
     * 获得指定范围内的随机数[min, max)
     *
     * @param min 最小数（包含）
     * @param max 最大数（不包含）
     * @return 随机数
     * @since 3.3.0
     */
    public static long randomLong(long min, long max) {
        return getThreadLocalRandom().nextLong(min, max);
    }

    /**
     * 获得随机数
     *
     * @return 随机数
     * @since 3.3.0
     */
    public static long randomLong() {
        return getThreadLocalRandom().nextLong();
    }

    /**
     * 获得指定范围内的随机数 [0,limit)
     *
     * @param limit 限制随机数的范围，不包括这个数
     * @return 随机数
     */
    public static long randomLong(long limit) {
        return getThreadLocalRandom().nextLong(limit);
    }

    /**
     * 获得指定范围内的随机数
     *
     * @param min 最小数（包含）
     * @param max 最大数（不包含）
     * @return 随机数
     * @since 3.3.0
     */
    public static double randomDouble(double min, double max) {
        return getThreadLocalRandom().nextDouble(min, max);
    }

    /**
     * 获得随机数[0, 1)
     *
     * @return 随机数
     * @since 3.3.0
     */
    public static double randomDouble() {
        return getThreadLocalRandom().nextDouble();
    }

    /**
     * 获得指定范围内的随机数 [0,limit)
     *
     * @param limit 限制随机数的范围，不包括这个数
     * @return 随机数
     * @since 3.3.0
     */
    public static double randomDouble(double limit) {
        return getThreadLocalRandom().nextDouble(limit);
    }

    /**
     * 随机bytes
     *
     * @param length 长度
     * @return bytes
     */
    public static byte[] randomBytes(int length) {
        byte[] bytes = new byte[length];
        getThreadLocalRandom().nextBytes(bytes);
        return bytes;
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
}
