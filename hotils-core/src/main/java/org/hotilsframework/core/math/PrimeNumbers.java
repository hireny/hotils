package org.hotilsframework.core.math;

import java.util.Arrays;

/**
 * 对素数(质数)进行处理
 *
 * 质数是指在大于1的自然数中，除了1和它本身以外不在有其它因数的自然数。
 *
 * 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其它自然数整除的树叫做质数；否则称为合数。
 * @author hireny
 * @className PrimeNumbers
 * @create 2020-02-21 21:30
 */
public class PrimeNumbers {

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
                if (primeIndex >= primeNumbers.length) {
                    primeNumbers = Arrays.copyOf(primeNumbers, primeIndex + 1);
                }
                primeNumbers[primeIndex++] = num;
            }
            num++;
        }
        return primeNumbers;
    }
}
