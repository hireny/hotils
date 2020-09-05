package org.hotilsframework.lang;

import example.model.Gender;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @ClassName: EnumsTest
 * @Author: hireny
 * @Date: Created in 2020-01-30 13:36
 * @Version: 1.0
 */
public class EnumUtilsTest {

    @Test
    public void enumFieldTest() {
        Field field = EnumUtils.getField(Gender.Male);
        System.out.println(field);
    }
}
