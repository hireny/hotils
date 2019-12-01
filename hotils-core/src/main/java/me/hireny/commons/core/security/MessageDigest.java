package me.hireny.commons.core.security;

import java.security.NoSuchAlgorithmException;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/03 20:02
 */
public abstract class MessageDigest {

    /**
     * 编码
     * @param data
     * @return
     */
    public abstract byte[] encrypt(byte[] data);

    /**
     * 加密
     * @param data
     * @param key
     * @return
     */
    protected byte[] encrypt(byte[] data, String key) {
        try {
            // 拿到一个MD5转换器（如果想要SHA1参数换成”Sha1Hash”）
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance(key);
            // inputByteArray是输入字符串转换得到的字节数组
            messageDigest.update(data);
            // 转换并返回结果，也是字节数组，包含16个元素
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

//    private static String byteArrayToHex(byte[] byteArray) {
//
//        // 首先初始化一个字符数组，用来存放每个16进制字符
//        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//                'A', 'B', 'C', 'D', 'E', 'F' };
//        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
//        char[] resultCharArray = new char[byteArray.length * 2];
//        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
//        int index = 0;
//        for (byte b : byteArray) {
//            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
//            resultCharArray[index++] = hexDigits[b & 0xf];
//        }
//        // 字符数组组合成字符串返回
//        return new String(resultCharArray);
//    }
}
