package org.hotilsframework.lang;

import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * JavaTypeTest
 *
 * Java类型测试
 *
 * @author hireny
 * @create 2020-09-10 12:13
 */
public class JavaTypesTest {

    /**
     * 获取所有基本类型测试
     */
    @Test
    public void allPrimitiveTypesTest() {
        System.out.println(JavaTypes.allPrimitiveTypes().toString());
    }

    /**
     * 获取所有包装类型测试
     */
    @Test
    public void allWrapperTypesTest() {
        System.out.println(JavaTypes.allWrapperTypes().toString());
    }

    /**
     * 获取标准数字类型
     */
    @Test
    public void testAllStandardNumberType() {
        Set<Class<?>> allStandardNumberType = JavaTypes.allStandardNumberTypes();
        System.out.println(allStandardNumberType.toString());
    }

    @Test
    public void testPrimitiveTypeNameMap() {
        Map<String, Class<?>> primitiveTypeNames = JavaTypes.getPrimitiveTypeNameMap();
        System.out.println(primitiveTypeNames);
    }
}
