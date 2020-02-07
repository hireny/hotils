package org.hotilsframework.core.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: MultiValueMapTest
 * @Author: hireny
 * @Date: Create in 2019/12/24 14:46
 * @Description: TODO
 */
public class MultiValueMapTest {

    @Test
    public void linkedMultiValueMapTest() {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("测试多值Map","第一个值就是这样");
        multiValueMap.add("测试多值Map", "第二个值就是这样");
        multiValueMap.add("测试多值Map", "第三个值就是这样");

        multiValueMap.add("2019-12-24", "这是今天的日期");
        multiValueMap.add("2019-12-24", "这是明天的日期");
        multiValueMap.add("2019-12-24", "这是昨天的日期");

        // 打印所有值
        for (Map.Entry<String, List<String>> entry : multiValueMap.entrySet()) {
            System.out.println("key="+ entry.getKey() + ", value=" + entry.getValue());
        }

        for (String s : multiValueMap.keySet()) {
            List<String> values = multiValueMap.get(s);
            System.out.println("key=" + s + ", values="+ Arrays.toString(values.toArray()));
        }
    }
}
