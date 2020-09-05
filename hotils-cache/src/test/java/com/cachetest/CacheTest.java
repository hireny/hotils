package com.cachetest;

import org.hotilsframework.cache.Cache;
import org.hotilsframework.cache.CacheBuilder;
import org.hotilsframework.cache.TimedCache;
import org.hotilsframework.time.DateUnit;
import org.junit.Test;

/**
 * CacheTest
 * 类描述
 *
 * @author hireny
 * @create 2020-08-12 18:15
 */
public class CacheTest {

    @Test
    public void cacheTest() {
        Cache<String, Object> cache = new CacheBuilder<String, Object>().policy(TimedCache.class).build();
        cache.put("key1", "value1", DateUnit.SECOND.getMillis() * 3);
        cache.put("key2", "value2", DateUnit.SECOND.getMillis() * 3);
        cache.put("key3", "value3", DateUnit.SECOND.getMillis() * 3);
        cache.put("key4", "value4", DateUnit.SECOND.getMillis() * 3);
        cache.put("key5", "value5", DateUnit.SECOND.getMillis() * 3);
        System.out.println(cache);
    }
}
