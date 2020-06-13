package org.hotilsframework.collect;

import org.junit.Test;

import java.util.Map;

/**
 * @ClassName: MapsTest
 * @Author: hireny
 * @Date: Created in 2020-02-07 19:03
 * @Version: 1.0
 */
public class MapsTest {

    @Test
    public void newHashMapTest() {
        Map<String, String> map1 = Maps.newHashMap();
        map1.put("小明","2");


        Map<String, String> map2 = Maps.newHashMap();
        map2.put("小张", "24");

        System.out.println(map1);
        System.out.println(map2);
        System.out.println(map1 == map2);
        System.out.println(map1.getClass() == map2.getClass());
        System.out.println(map1.toString());
    }
}
