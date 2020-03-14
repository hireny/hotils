package org.hotilsframework.math;

import org.hotilsframework.core.collection.Lists;
import org.hotilsframework.utils.ArrayUtils;
import org.hotilsframework.utils.Assert;
import org.hotilsframework.utils.NumberUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 数学工具类
 * 主要是为了扩展 Math 类没有的一些方法
 * @className Maths
 * @author hireny
 * @create 2020-02-17 17:56
 */
public final class Maths {

    private Maths() {}

    //================================================================//
    // 数值计算
    //================================================================//

    /** 默认运算精度 */
    private static int DEFAULT_SCALE = 10;

    public static double add(float v1, float v2) {
        return add(Float.toString(v1), Float.toString(v2)).doubleValue();
    }

    public static double add(float v1, double v2) {
        return add(Float.toString(v1), Double.toString(v2)).doubleValue();
    }

    /**
     * 提供双精度浮点数的加法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, float v2) {
        return add(Double.toString(v1), Float.toString(v2)).doubleValue();
    }

    /**
     * 提供双精度浮点数的加法运算
     * @param v1
     * @param v2
     * @return
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        BigDecimal result = b1.add(b2);
        return result.doubleValue();
    }

    /**
     * 提供(相对)精确的加法运算。
     *
     * @param v1    被加数
     * @param v2    加数
     * @return      两个参数的和
     */
    public static BigDecimal add(Number v1, Number v2) {
        return add(new Number[]{v1, v2});
    }

    /**
     * 提供(相对)精确的加法运算。
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values    多个值相加
     * @return          和
     */
    public static BigDecimal add(Number... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        Number value = values[0];
        BigDecimal result = new BigDecimal(null == value ? "0" : value.toString());
        for (int i = 0, len = values.length; i < len; i++) {
            value = values[i];
            if (null != value) {
                result = result.add(new BigDecimal(value.toString()));
            }
        }
        return result;
    }

    /**
     * 提供精确的加法运算
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values    多个被加值
     * @return          和
     */
    public static BigDecimal add(String... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }
        String value = values[0];
        BigDecimal result = new BigDecimal(null == value ? "0" : value);
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.add(new BigDecimal(value));
            }
        }
        return result;
    }

    /**
     * 提供精确的加法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被加值
     * @return 和
     * @since 4.0.0
     */
    public static BigDecimal add(BigDecimal... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        BigDecimal value = values[0];
        BigDecimal result = null == value ? BigDecimal.ZERO : value;
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.add(value);
            }
        }
        return result;
    }

    /**
     * 提供精确的减法运算
     * @param v1    被减数
     * @param v2    减数
     * @return      差
     */
    public static double subtract(float v1, float v2) {
        return subtract(Float.toString(v1), Float.toString(v2)).doubleValue();
    }

    /**
     * 提供精确的减法运算
     * @param v1    被减数
     * @param v2    减数
     * @return      差
     */
    public static double subtract(float v1, double v2) {
        return subtract(Float.toString(v1), Double.toString(v2)).doubleValue();
    }

    /**
     * 提供精确的减法运算
     * @param v1    被减数
     * @param v2    减数
     * @return      差
     */
    public static double subtract(double v1, float v2) {
        return subtract(Double.toString(v1), Float.toString(v2)).doubleValue();
    }

    /**
     * 提供精确的减法运算
     * @param v1    被减数
     * @param v2    减数
     * @return      差
     */
    public static double subtract(double v1, double v2) {
        return subtract(Double.toString(v1), Double.toString(v2)).doubleValue();
    }

    /**
     * 提供(相对)精确的减法运算。
     *
     * @param v1    被减数
     * @param v2    减数
     * @return 两个参数的差
     */
    public static BigDecimal subtract(Number v1, Number v2) {
        return subtract(new Number[]{v1, v2});
    }

    /**
     * 提供(相对)精确的减法运算。
     *
     * @param values    多个被减值
     * @return          差
     */
    public static BigDecimal subtract(Number... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }
        Number value = values[0];
        BigDecimal result = new BigDecimal(null == value ? "0" : value.toString());
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.subtract(new BigDecimal(value.toString()));
            }
        }
        return result;
    }

    /**
     * 提供精确的减法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被减值
     * @return 差
     * @since 4.0.0
     */
    public static BigDecimal subtract(String... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        String value = values[0];
        BigDecimal result = new BigDecimal(null == value ? "0" : value);
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.subtract(new BigDecimal(value));
            }
        }
        return result;
    }

    /**
     * 提供精确的减法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被减值
     * @return 差
     * @since 4.0.0
     */
    public static BigDecimal subtract(BigDecimal... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        BigDecimal value = values[0];
        BigDecimal result = null == value ? BigDecimal.ZERO : value;
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.subtract(value);
            }
        }
        return result;
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double multiply(float v1, float v2) {
        return multiply(Float.toString(v1), Float.toString(v2)).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double multiply(float v1, double v2) {
        return multiply(Float.toString(v1), Double.toString(v2)).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double multiply(double v1, float v2) {
        return multiply(Double.toString(v1), Float.toString(v2)).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double multiply(double v1, double v2) {
        return multiply(Double.toString(v1), Double.toString(v2)).doubleValue();
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static double multiply(Double v1, Double v2) {
        //noinspection RedundantCast
        return multiply((Number) v1, (Number) v2).doubleValue();
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 积
     */
    public static BigDecimal multiply(Number v1, Number v2) {
        return multiply(new Number[]{v1, v2});
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被乘值
     * @return 积
     * @since 4.0.0
     */
    public static BigDecimal multiply(Number... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        Number value = values[0];
        BigDecimal result = new BigDecimal(null == value ? "0" : value.toString());
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.multiply(new BigDecimal(value.toString()));
            }
        }
        return result;
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被乘值
     * @return 积
     * @since 4.0.0
     */
    public static BigDecimal multiply(String... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        String value = values[0];
        BigDecimal result = new BigDecimal(null == value ? "0" : value);
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.multiply(new BigDecimal(value));
            }
        }
        return result;
    }

    /**
     * 提供精确的乘法运算<br>
     * 如果传入多个值为null或者空，则返回0
     *
     * @param values 多个被乘值
     * @return 积
     * @since 4.0.0
     */
    public static BigDecimal multiply(BigDecimal... values) {
        if (ArrayUtils.isEmpty(values)) {
            return BigDecimal.ZERO;
        }

        BigDecimal value = values[0];
        BigDecimal result = null == value ? BigDecimal.ZERO : value;
        for (int i = 1; i < values.length; i++) {
            value = values[i];
            if (null != value) {
                result = result.multiply(value);
            }
        }
        return result;
    }

    /**
     * 提供(相对)精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @param roundingMode 保留小数的模式
     * @return 两个参数的商
     */
    public static double divide(float v1, float v2, int scale, RoundingMode roundingMode) {
        return divide(Float.toString(v1), Float.toString(v2), scale, roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @param roundingMode 保留小数的模式
     * @return 两个参数的商
     */
    public static double divide(float v1, double v2, int scale, RoundingMode roundingMode) {
        return divide(Float.toString(v1), Double.toString(v2), scale, roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @param roundingMode 保留小数的模式
     * @return 两个参数的商
     */
    public static double divide(double v1, float v2, int scale, RoundingMode roundingMode) {
        return divide(Double.toString(v1), Float.toString(v2), scale, roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @param roundingMode 保留小数的模式
     * @return 两个参数的商
     */
    public static double divide(double v1, double v2, int scale, RoundingMode roundingMode) {
        return divide(Double.toString(v1), Double.toString(v2), scale, roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @param roundingMode 保留小数的模式
     * @return 两个参数的商
     */
    public static double divide(Double v1, Double v2, int scale, RoundingMode roundingMode) {
        return divide((Number) v1, (Number) v2, scale, roundingMode).doubleValue();
    }

    /**
     * 提供(相对)精确的除法运算。 当发生除不尽的情况时，由scale参数指定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @param roundingMode 保留小数的模式
     * @return 两个参数的商
     */
    public static BigDecimal divide(Number v1, Number v2, int scale, RoundingMode roundingMode) {
        return divide(v1.toString(), v2.toString(), scale, roundingMode);
    }

    /**
     * 提供（相对）精确的除数运算，当发生除不尽的情况下，由scale指定精确度
     *
     * @param v1            被除数
     * @param v2            除数
     * @param scale         精确度，如果为负值，取绝对值
     * @param roundingMode  保留小数的模式 {@link RoundingMode}
     * @return              两个参数的值
     */
    public static BigDecimal divide(String v1, String v2, int scale, RoundingMode roundingMode) {
        return divide(new BigDecimal(v1), new BigDecimal(v2), scale, roundingMode);
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况下，由scale指定精确度
     *
     * @param v1            被除数
     * @param v2            除数
     * @param scale         精确度，如果为负数，取绝对值
     * @param roundingMode  保留小数的模式 {@link RoundingMode}
     * @return              两个参数的商
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2, int scale, RoundingMode roundingMode) {
        // 除数必须不为空
        Assert.notNull(v2, "Divisor must be not null.");
        if (null == v1) {
            return BigDecimal.ZERO;
        }
        if (scale < 0) {
            scale = -scale;
        }
        return v1.divide(v2, scale, roundingMode);
    }

    /**
     * 保留固定位数小数
     * @param value         数字值的字符串表现形式
     * @param scale         保留小数位数，如果传入小于0，则默认0
     * @return              新值
     */
    public static BigDecimal round(String value, int scale) {
        return round(value, scale, RoundingMode.HALF_UP);
    }

    /**
     * 保留固定位数小数
     * @param value         数字值
     * @param scale         保留小数位数，如果传入小于0，则默认0
     * @return              新值
     */
    public static BigDecimal round(BigDecimal value, int scale) {
        return round(value, scale, RoundingMode.HALF_UP);
    }

    /**
     * 保留固定位数小数
     * @param v             值
     * @param scale         保留小数位数，如果传入小于0，则默认0
     * @param roundingMode  保留小数的模式 {@link RoundingMode}    如果传入null则默认四舍五入
     * @return              新值
     */
    public static BigDecimal round(double v, int scale, RoundingMode roundingMode) {
        return round(Double.toString(v), scale, roundingMode);
    }

    /**
     * 保留固定位数小数
     * @param value         数字值的字符串表现形式
     * @param scale         保留小数位数，如果传入小于0，则默认0
     * @param roundingMode  保留小数的模式 {@link RoundingMode}    如果传入null则默认四舍五入
     * @return              新值
     */
    public static BigDecimal round(String value, int scale, RoundingMode roundingMode) {
        Assert.notBlank(value);
        return round(NumberUtils.parseNumber(value, BigDecimal.class), scale, roundingMode);
    }

    /**
     * 保留固定位数小数
     * @param value         数字值
     * @param scale         保留小数位数，如果传入小于0，则默认0
     * @param roundingMode  保留小数的模式 {@link RoundingMode}    如果传入null则默认四舍五入
     * @return              新值
     */
    public static BigDecimal round(BigDecimal value, int scale, RoundingMode roundingMode) {
        if (Objects.isNull(value)) {
            value = BigDecimal.ZERO;
        }
        if (scale < 0) {
            scale = 0;
        }
        if (Objects.isNull(roundingMode)) {
            roundingMode = RoundingMode.HALF_UP;
        }

        return value.setScale(scale, roundingMode);
    }

    /**
     * 获取start到end区间的随机数,不包含start+end
     *
     * @param start
     * @param end
     * @return
     */
    public static BigDecimal random(double start, double end) {
        return new BigDecimal(start + Math.random() * (end - start));
    }


    //===========================数学运算 end=====================================//

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


    //=================================================
    //  数学计算公式
    //=================================================

    //=================================================
    //  对素数(质数)进行处理
    //  质数是指在大于1的自然数中，除了1和它本身以外不在有其它因数的自然数。
    //  质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其它自然数整除的树叫做质数；否则称为合数。
    //=================================================

    /**
     * 检查一个数是否是素数
     * @param value     整型数值
     * @return          是否是素数
     */
    public static boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }
        int i;
        // Math.sqrt(long a)
        // 返回正确舍入的一个double值的正平方根。
        // Math.sqrt(9) = 3.0   Math.sqrt(25) = 5.0
        double legalBoundary = Math.sqrt(value);
        for (i = 2; i < legalBoundary; i++) {
            if (value % 2 == 0) {
                break;
            }
        }
        return i > legalBoundary;
    }

    /**
     * 带边界的质数数组
     * @param start
     * @param end
     * @return
     */
    public static int[] primesByBoundary(int start, int end) {
        int[] primeNumbers = new int[1];
        int primeIndex = 0;

        for (int num = start; num <= end; num++) {
            if (isPrime(num)) {
                if (primeIndex >= primeNumbers.length) {
                    primeNumbers = Arrays.copyOf(primeNumbers, primeIndex + 1);
                }
                primeNumbers[primeIndex++] = num;
            }
        }
        return primeNumbers;
    }

    /**
     * 输出指定个数的素数
     * @param count     素数个数
     * @return          素数数组
     */
    public static int[] primesByCount(int count) {
        int[] primeNumbers = new int[count];
        int primeIndex = 0;

        int num = 2;
        while (primeIndex < count) {
            if (isPrime(num)) {
                primeNumbers[primeIndex++] = num;
            }
            num++;
        }
        return primeNumbers;
    }

    /**
     * 统计一个数的所有因子
     *
     * 假设整数n除以m，结果是无余数的整数，那么我们称m就是n的因子。
     * 需要注意的是，唯有被除数，除数，商皆为整数，余数为零时，此关系才成立。反过来说，我们称n为m的倍数。
     * @param n
     * @return
     */
    public static Integer[] factors(int n) {
        if (0 >= n) {
            return null;
        }
        List<Integer> factors = Lists.newArrayList();
        int half = n / 2;
        for (int i = 1; i <= half; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        Integer[] result = new Integer[factors.size()];
        factors.toArray(result);
        return result;
    }

    //=================================================
    //  公约数与公倍数
    //=================================================

    /**
     * 求最大公约数
     *
     * 辗转相除法与因式分解法
     *
     * 使用辗转相除法实现
     * @param num1  数字1
     * @param num2  数字2
     * @return      最大公约数
     */
    public static int gcd(int num1, int num2) {
        return (0 == num1 % num2) ? num2 : gcd(num2, num1 % num2);
    }

    /**
     * 最小公倍数
     *
     * 两数相乘除以最大公约数即为最小公倍数
     * @param num1  数字1
     * @param num2  数字2
     * @return      最小公倍数
     */
    public static int lcm(int num1, int num2) {
        return num1 * num2 / gcd(num1, num2);
    }


    //=================================================
    //  斐波那契数列
    //=================================================

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
