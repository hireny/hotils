package org.hotilsframework.core.lang;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @ClassName: EnumsTest
 * @Author: hireny
 * @Date: Created in 2020-01-30 13:36
 * @Version: 1.0
 */
public class EnumsTest {

    @Test
    public void enumFieldTest() {
        Field field = Enums.getField(Gender.Male);
        System.out.println(field);
    }
}
