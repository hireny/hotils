package me.hireny.commons.codec;

/**
 * CodecConstants
 * 编解码常量
 * @Author: hireny
 * @Date: Create in 2019/10/04 18:07
 */
public interface CodecConstants {
    /**
     * Base64规则匹配
     */
    String BASE64_PATTERN = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$";
}
