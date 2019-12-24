package me.hireny.commons.core.collect;

import com.sun.deploy.util.StringUtils;
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
        MultiMap<String, String> multiMap = new LinkedMultiValueMap<>();
        multiMap.add("测试多值Map","第一个值就是这样");
        multiMap.add("测试多值Map", "第二个值就是这样");
        multiMap.add("测试多值Map", "第三个值就是这样");

        multiMap.add("2019-12-24", "这是今天的日期");
        multiMap.add("2019-12-24", "这是明天的日期");
        multiMap.add("2019-12-24", "这是昨天的日期");

        // 打印所有值
        for (Map.Entry<String, List<String>> entry : multiMap.entrySet()) {
            System.out.println("key="+ entry.getKey() + ", value=" + entry.getValue());
        }

        for (String s : multiMap.keySet()) {
            List<String> values = multiMap.get(s);
            System.out.println("key=" + s + ", values="+ Arrays.toString(values.toArray()));
        }
    }
}
