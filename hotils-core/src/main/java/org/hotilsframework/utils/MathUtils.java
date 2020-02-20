package org.hotilsframework.utils;

import java.math.BigDecimal;

/**
 * 数学工具类
 * 主要是为了扩展 Math 类没有的一些方法
 * @className Maths
 * @author hireny
 * @create 2020-02-17 17:56
 */
public final class MathUtils {

    private MathUtils() {}

    /**
     * 设置限制范围，确保不超出范围；如果超出，则取最小值或最大值
     * @param src       源数值
     * @param min       最小值，如果小于最小值，则返回最小值
     * @param max       最大值，如果大于最大值，则返回最大值
     * @return
     */
    public static int limit(int src, int min, int max) {
        if (src >= max) {
            return max;
        } else if (src <= min) {
            return min;
        }
        return src;
    }

    /**
     * 设置限制范围，确保不超出范围；如果超出，则取最小值或最大值
     * @param src       源数值
     * @param min       最小值，如果小于最小值，则返回最小值
     * @param max       最大值，如果大于最大值，则返回最大值
     * @return
     */
    public static long limit(long src, long min, long max) {
        if (src >= max) {
            return max;
        } else if (src <= min) {
            return min;
        }
        return src;
    }

    /**
     * 设置限制范围，确保不超出范围；如果超出，则取最小值或最大值
     * @param src       源数值
     * @param min       最小值，如果小于最小值，则返回最小值
     * @param max       最大值，如果大于最大值，则返回最大值
     * @return
     */
    public static float limit(float src, float min, float max) {
        if (src >= max) {
            return max;
        } else if (src <= min) {
            return min;
        }
        return src;
    }

    /**
     * 设置限制范围，确保不超出范围；如果超出，则取最小值或最大值
     * @param src       源数值
     * @param min       最小值，如果小于最小值，则返回最小值
     * @param max       最大值，如果大于最大值，则返回最大值
     * @return
     */
    public static double limit(double src, double min, double max) {
        if (src >= max) {
            return max;
        } else if (src <= min) {
            return min;
        }
        return src;
    }


    //================================================================//
    // 数值计算
    //================================================================//

    /** 默认运算精度 */
    private static int DEFAULT_SCALE = 10;

    /**
     * 提供数据类型转换为BigDecimal
     *
     * @param object    原始数据
     * @return  BigDecimal
     */
    public static BigDecimal bigDecimal(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        if (object instanceof BigDecimal) {
            return (BigDecimal)object;
        }
        BigDecimal result;
        try {
            result = new BigDecimal(object.toString().replaceAll(",", ""));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Please give me a numeral.Not " + object);
        }
        return result;
    }

    /**
     * 提供(相对)精确的加法运算。
     *
     * @param num1 被加数
     * @param num2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(Number num1, Number num2) {
        BigDecimal result = bigDecimal(num1).add(bigDecimal(num2));
        return result.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供(相对)精确的减法运算。
     *
     * @param num1 被减数
     * @param num2 减数
     * @return 两个参数的差
     */
    public static BigDecimal subtract(Number num1, Number num2) {
        BigDecimal result = bigDecimal(num1).subtract(bigDecimal(num2));
        return result.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供(相对)精确的乘法运算。
     *
     * @param num1 被乘数
     * @param num2 乘数
     * @return 两个参数的积
     */
    public static BigDecimal multiply(Number num1, Number num2) {
        BigDecimal result = bigDecimal(num1).multiply(bigDecimal(num2));
        return result.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供(相对)精确的除法运算，当发生除不尽的情况时，精度为10位，以后的数字四舍五入。
     *
     * @param num1 被除数
     * @param num2 除数
     * @return 两个参数的商
     */
    public static BigDecimal divide(Number num1, Number num2) {
        return divide(num1, num2, DEFAULT_SCALE);
    }

    /**
     * 提供(相对)精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param num1 被除数
     * @param num2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static BigDecimal divide(Number num1, Number num2, Integer scale) {
        if (scale == null) {
            scale = DEFAULT_SCALE;
        }
        num2 = num2 == null || Math.abs(new Double(num2.toString())) == 0 ? 1 : num2;
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal result = bigDecimal(num1).divide(bigDecimal(num2), scale, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param num 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static BigDecimal round(Number num, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal result = bigDecimal(num).divide(bigDecimal("1"), scale, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    /**
     * 获取start到end区间的随机数,不包含start+end
     *
     * @param start
     * @param end
     * @return
     */
    public static BigDecimal getRandom(double start, double end) {
        return new BigDecimal(start + Math.random() * (end - start));
    }


    //===========================数学运算 end=====================================//
}
