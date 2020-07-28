package org.hotilsframework.core.types;

import example.model.Generic;
import org.junit.Test;

/**
 * TypeLiteralTest
 * 类描述
 *
 * @author hireny
 * @create 2020-07-28 21:56
 */
public class TypeLiteralTest {

    @Test
    public void test1() {

        Generic<String> g = new Generic<>("generic is string type");

        TypeLiteral<?> t = new TypeLiteral<Generic<String>>() {};
        System.out.println(t.rawType);
        System.out.println(t.type);
    }
}
