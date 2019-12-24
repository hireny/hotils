package me.hireny.commons.core.collect;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ListsTest
 * @Author: hireny
 * @Date: Create in 2019/12/22 23:35
 * @Description: TODO   列表集合测试
 */
public class ListsTest {

    @Test
    public void newArrayListTest() {
        List<String> list1 = Lists.newArrayList();
        list1.add("abcdefg");
        list1.add("pawefty");

        System.out.println(list1);
        System.out.println(Arrays.toString(list1.toArray()));
        System.out.println("列表长度="+list1.size());

        List<String> list2 = Lists.newArrayList();
        list2.add("dbgrfsd");
        list2.add("fdsfewfs");
        System.out.println(list2);
        System.out.println(Arrays.toString(list2.toArray()));

        System.out.println(list1 == list2);

        List<String> list3 = new ArrayList<>();
        list3.add("dfsdfewfwe");
        list3.add("plowwqeq");
        System.out.println(list3);
    }
}
