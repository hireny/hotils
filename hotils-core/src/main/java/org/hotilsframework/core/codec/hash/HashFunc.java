package org.hotilsframework.core.codec.hash;

/**
 * HashFunction
 * Hash算法对象，用于自定义Hash算法
 *
 * @author hireny
 * @create 2020-07-14 9:29
 */
public interface HashFunc {
    /**
     *
     * @return  获取一个Hasher
     */
    Hasher newHasher();

    /**
     *
     * @param expectedInputSize 预计输入的大小
     * @return  获取一个Hasher
     */
    Hasher newHasher(int expectedInputSize);


    Long hash(Object key);
}
