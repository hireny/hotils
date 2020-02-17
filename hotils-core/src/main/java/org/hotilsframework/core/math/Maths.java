package org.hotilsframework.core.math;

/**
 * 数学工具类
 * 主要是为了扩展 Math 类没有的一些方法
 * @className Maths
 * @auther hireny
 * @create 2020-02-17 17:56
 */
public final class Maths {

    private Maths() {}

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
}
