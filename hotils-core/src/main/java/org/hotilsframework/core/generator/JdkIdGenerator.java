package org.hotilsframework.core.generator;

import java.util.UUID;

/**
 * @ClassName: JdkIdGenerator
 * @Author: hireny
 * @Date: Created in 2020-01-16 0:15
 * @Version: 1.0
 */
public class JdkIdGenerator implements IdGenerator {
    @Override
    public long nextId() {
        throw new IdGeneratorException("Id generator exception");
    }

    @Override
    public UUID generateId() {
        return UUID.randomUUID();
    }
}
