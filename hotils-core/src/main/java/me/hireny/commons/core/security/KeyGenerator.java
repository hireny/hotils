package me.hireny.commons.core.security;

/**
 * @ClassName: KeyGenerator
 * @Description: TODO   ID生成器
 * @Author: hireny
 * @Date: Created in 2020-01-08 21:54
 * @Version: 1.0
 */
public interface KeyGenerator {

    /**
     * get nex id
     * @return
     */
    long nextId();
}
