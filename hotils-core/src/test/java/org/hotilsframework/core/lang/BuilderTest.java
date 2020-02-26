package org.hotilsframework.core.lang;

import example.model.UserTestClass;
import org.junit.Test;

/**
 * 通用构建者的测试类
 * @author hireny
 * @className BuilderTest
 * @create 2020-02-26 23:40
 */
public class BuilderTest {

    @Test
    public void builderTest() {
        UserTestClass userTestClass = Builder.of(UserTestClass::new)
                .with(UserTestClass::setId, 33)
                .with(UserTestClass::setUsername, "小明")
                .with(UserTestClass::setGender, "男").build();

        System.out.println(userTestClass);
    }
}
