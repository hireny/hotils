package org.hotilsframework.core.generator;

import java.util.UUID;

/**
 * @ClassName: KeyGenerator
 * @Description: TODO   ID生成器
 * @Author: hireny
 * @Date: Created in 2020-01-08 21:54
 * @Version: 1.0
 */
public interface IdGenerator {

    /**
     * get nex id
     * @return
     */
    long nextId();

    /**
     * 生成ID
     * @return
     */
    UUID generateId();
}
