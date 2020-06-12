package org.hotilsframework.core.generator;

import java.util.UUID;

/**
 * GuidSequence
 * GUID序列，UUID生成的实现
 * @Author: hireny
 * @Date: Create in 2019/11/02 13:21
 */
public class GuidGenerator implements IdGenerator {
    @Override
    public long nextId() {
        return 0;
    }

    @Override
    public UUID generateId() {
        return null;
    }
}
