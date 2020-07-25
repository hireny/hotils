package org.hotilsframework.io.unit;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * 数据大小测试
 * @author hireny
 * @className DataSizeTest
 * @create 2020-02-21 20:50
 */
public class DataSizeTest {

    @Test
    public void dataSizeTest() {
        DataSize dataSize = DataSize.ofBytes(4975532725L);
        System.out.println(dataSize.toBytes());
        System.out.println(dataSize.toKilobytes());
        System.out.println(dataSize.toMegabytes());
        System.out.println(dataSize.toGigabytes());
        System.out.println(dataSize.toTerabytes());
        System.out.println(dataSize.toString());
    }

    /**
     * 字节数与字节数的测试
     */
    @Test
    public void ofBytesToBytes() {
        assertEquals(DataSize.ofBytes(1024).toBytes(), 1024);
    }
}
