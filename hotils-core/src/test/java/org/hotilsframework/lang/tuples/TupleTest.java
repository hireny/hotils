package org.hotilsframework.lang.tuples;

import example.model.PersonModel;
import org.junit.Test;

/**
 * 元组测试
 * @author hireny
 * @className TupleTest
 * @create 2020-04-10 9:58
 */
public class TupleTest {

    @Test
    public void tupleTest() {
        // 创建元组
        Tuple tuple = new Tuple(new Object(), Integer.MAX_VALUE, new PersonModel(), Double.MAX_VALUE, "tuple test");
        System.out.println(tuple.toString());
        PersonModel model = tuple.get(2);
        System.out.println(model);
        double d = tuple.get(3);
        System.out.println(d);
    }
}
