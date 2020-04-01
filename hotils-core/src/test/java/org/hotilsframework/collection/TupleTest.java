package org.hotilsframework.collection;

import example.model.UserTestClass;
import org.hotilsframework.tuple.Tuple;
import org.junit.Test;

/**
 * 元组测试
 * @ClassName: TupleTest
 * @Author: hireny
 * @Date: Created in 2020-01-15 0:43
 * @Version: 1.0
 */
public class TupleTest {

    @Test
    public void tupleTest1() {
        Tuple tuple = new Tuple(1, "32", "ok", 2.1, new UserTestClass());
        System.out.println(tuple);
    }
}
