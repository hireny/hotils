package me.hireny.commons.core.security.hash;

import java.util.BitSet;

/**
 * @ClassName: BloomFilter
 * @Author: hireny
 * @Date: Create in 2019/12/03 15:37
 * @Description: TODO   布隆过滤器
 */
public class BloomFilter<T> {


    /**
     * 位数组的大小
     */
    private final int size = 2 << 24;
    private int count;
    /**
     * 位数组，数组中的元素只能是0或者1
     */
    private BitSet bits;
    /**
     * 存放包含hash函数的类的数组
     */
    private Hash[] func;
    /**
     * 通过这个数组可以创建6个不同的hash函数
     */
    private final int[] seeds = new int[]{3, 5, 7, 11, 13, 31, 37, 61};

    /**
     * 初始化多个包含 hash 函数的数组，每个类中的hash函数都不一样
     */
    public BloomFilter() {
        bits = new BitSet(size);
        func = new Hash[seeds.length];
        // 初始化多个不同的 Hash 函数
        for (int i = 0, len = seeds.length; i < len; i++) {
            func[i] = new Hash(size, seeds[i]);
        }
    }

    /**
     * 添加元素到位数组
     * @param value
     */
    public void add(Object value) {
        if (!"".equals(value) && !contains(value)) {
            for (Hash f : func) {
                bits.set(f.hash(value), true);
            }
            count++;
        }
    }

    /**
     * 判断指定元素是否存在于位数组
     * @param value
     * @return
     */
    public boolean contains(Object value) {
        if ("".equals(value)) {
            return false;
        }
        boolean ret = true;
        for (Hash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    public int getCount() {
        return count;
    }

    public static <T> BloomFilter<T> create(int expectedInsertions, double fpp) {
        return new BloomFilter<>();
    }


    /**
     * 静态内部类，用于 hash 操作
     */
    private static class Hash {
        private int cap;
        private int seed;

        public Hash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * 计算 hash 值
         * @param value
         * @return
         */
        private int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
//            int result = 0;
//            int len = value.length();
//            for (int i = 0; i < len; i++) {
//                result = seed * result + value.charAt(i);
//            }
//            return (cap - 1) & result;
        }
    }

    public static void main(String[] args) {

        System.out.println("************测试一********************");

        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        BloomFilter filter = new BloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));


        System.out.println("***************测试二*********************");


        Integer value3 = 13423;
        Integer value4 = 22131;
        BloomFilter filter2 = new BloomFilter();
        System.out.println(filter2.contains(value3));
        System.out.println(filter.contains(value4));
        filter.add(value3);
        filter.add(value4);
        System.out.println(filter.contains(value3));
        System.out.println(filter.contains(value4));
    }
}
