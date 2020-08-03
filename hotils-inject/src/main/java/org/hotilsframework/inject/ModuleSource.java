package org.hotilsframework.inject;

import org.hotilsframework.inject.internal.StackTraceElements;

import java.util.Arrays;

/**
 * Modules
 *
 * 用于存储模块信息的容器
 *
 * @author hireny
 * @create 2020-08-02 20:27
 */
public final class ModuleSource {

    /**
     * 存储的模块的名称
     *
     * 可以根据模块名称获取
     */
    private final String moduleName;

    private final StackTraceElements.InMemoryStackTraceElement[] partialCallStack;

    /**
     * 创建一个具有 {@literal null} 父级的 {@link ModuleSource} 类
     * @param moduleClass
     * @param partialCallStack
     */
    public ModuleSource(Class<?> moduleClass, StackTraceElement[] partialCallStack) {
        this.moduleName = moduleClass.getName();
        this.partialCallStack = StackTraceElements.convertToInMemoryStackTraceElement(partialCallStack);
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModuleSource{");
        sb.append("moduleName='").append(moduleName).append('\'');
        sb.append(", partialCallStack=").append(Arrays.toString(partialCallStack));
        sb.append('}');
        return sb.toString();
    }
}
