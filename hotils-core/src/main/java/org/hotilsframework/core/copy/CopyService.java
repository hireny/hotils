package org.hotilsframework.core.copy;

/**
 * 复制服务
 * @ClassName: CopierService
 * @Author: hireny
 * @Date: Created in 2020-02-07 15:45
 * @Version: 1.0
 */
public interface CopyService {

    /**
     * 是否能转换
     * @param sourceType
     * @param targetType
     * @return
     */
    boolean canCopy(Class<?> sourceType, Class<?> targetType);

    /**
     * 转换
     * @param source        源对象
     * @param targetType    目标类型
     * @param <T>           目标泛型
     * @return              目标对象
     */
    <T> T copy(Object source, Class<T> targetType);
}
