package me.hireny.commons.core.codec.binary;


import me.hireny.commons.core.codec.Codec;
import me.hireny.commons.core.codec.CodecConstants;
import me.hireny.commons.utils.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/04 10:24
 */
public class Base64 {

    // 根据rfc 4648 和 rfc 2045 base64编码字符数组
    private static final char[] base64EncodeChars = new char[]{'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'};

    private static final byte[] base64DecodeChars = new byte[]{-1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59,
            60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1,
            -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
            38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1,
            -1, -1};
    /**
     * 编码对象
     */
    private static Encoder encoder;
    /**
     * 解码对象
     */
    private static Decoder decoder;


    /**
     * 判断编码字符串是否是Base64编码
     *
     * @param encoder
     * @return
     */
    public boolean isBase64(String encoder) {
        if (StringUtils.isEmpty(encoder)) {
            return false;
        }
        if (encoder.length() % 4 != 0) {
            return false;
        }
        return Pattern.matches(CodecConstants.BASE64_PATTERN, encoder);
    }

//    /**
//     * 编码
//     *
//     * @param data
//     * @param key
//     * @return
//     */
//    public byte[] encoder(byte[] data, String key) {
//        StringBuffer sb = new StringBuffer();
//        int len = data.length;
//        int i = 0;
//        int b1, b2, b3;
//        while (i < len) {
//            b1 = data[i++] & 0xff;
//            if (i == len) {
//                sb.append(base64EncodeChars[b1 >>> 2]);
//                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
//                sb.append("==");
//                break;
//            }
//            b2 = data[i++] & 0xff;
//            if (i == len) {
//                sb.append(base64EncodeChars[b1 >>> 2]);
//                sb.append(base64EncodeChars[((b1 & 0x03) << 4)
//                        | ((b2 & 0xf0) >>> 4)]);
//                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
//                sb.append("=");
//                break;
//            }
//            b3 = data[i++] & 0xff;
//            sb.append(base64EncodeChars[b1 >>> 2]);
//            sb.append(base64EncodeChars[((b1 & 0x03) << 4)
//                    | ((b2 & 0xf0) >>> 4)]);
//            sb.append(base64EncodeChars[((b2 & 0x0f) << 2)
//                    | ((b3 & 0xc0) >>> 6)]);
//            sb.append(base64EncodeChars[b3 & 0x3f]);
//        }
//        return sb.toString().getBytes();
//    }
//
//    /**
//     * 解码
//     *
//     * @param data
//     * @param key
//     * @return
//     * @throws UnsupportedEncodingException
//     */
//    public byte[] decoder(byte[] data, String key) throws UnsupportedEncodingException {
//        StringBuffer sb = new StringBuffer();
////        byte[] data =  str.getBytes("US-ASCII");
//        int len = data.length;
//        int i = 0;
//        int b1, b2, b3, b4;
//        while (i < len) {
//
//            do {
//                b1 = base64DecodeChars[data[i++]];
//            } while (i < len && b1 == -1);
//            if (b1 == -1)
//                break;
//
//            do {
//                b2 = base64DecodeChars[data[i++]];
//            } while (i < len && b2 == -1);
//            if (b2 == -1)
//                break;
//            sb.append((char) ((b1 << 2) | ((b2 & 0x30) >>> 4)));
//
//            do {
//                b3 = data[i++];
//                if (b3 == 61)
//                    return sb.toString().getBytes("iso8859-1");
//                b3 = base64DecodeChars[b3];
//            } while (i < len && b3 == -1);
//            if (b3 == -1)
//                break;
//            sb.append((char) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));
//
//            do {
//                b4 = data[i++];
//                if (b4 == 61)
//                    return sb.toString().getBytes("iso8859-1");
//                b4 = base64DecodeChars[b4];
//            } while (i < len && b4 == -1);
//            if (b4 == -1)
//                break;
//            sb.append((char) (((b3 & 0x03) << 6) | b4));
//        }
//        return sb.toString().getBytes("iso8859-1");
//    }


    public static class Encoder implements Codec.Encoder {

        public String encoder(String str) {
            return new String(this.encoder(str.getBytes()));
        }

//        public byte[] encoder(String str) {
//            return this.encoder(str.getBytes());
//        }
//
//        public static String encode(byte[] bytes) {
//            String strArr[] = new String[bytes.length];
//            for (int i = 0; i < bytes.length; i++) {
//                strArr[i] = DecimalConversion.decimalToOther(2, String.valueOf((byte) bytes[i] & 0xff));//& 0xff(1111 1111)实际上是将负数转为显示成不考虑符号位的负数的补码形式,正数不受影响
//            }
//            String encodeByte = encode0(strArr);
//            return encodeByte;
//        }
//
//        public static byte[] encodeByte(String str) {
//            return encode(str).getBytes();
//        }
//
//        public static byte[] encodeByte(byte[] b) {
//            return encode(b).getBytes();
//        }

        /**
         * Base 64 编码规则:
         * --:错误1.将byte数组中的值转为二进制,将所有二进制数的长度相加,看长度是否为8的倍数,如果不足,则在每个数组元素的二进制前面补0,直到长度满足8的倍数
         * 1. 将byte数组的值转为二进制并放入数组,将数组中的每个元素的长度变成8个bit位,(即如果长度是6,则在值前面补两个0),最后按顺序拼接成一个完整的字符串
         * 2.将字符串以6位分组,不足的,要在末尾补0,达到6的倍数(记下补0的次数)
         * 3.将 每个分组的字符串拿出来,转为十进制以这个为下标,去查表,取得所需的对应编码值
         * 4.将值(可以拼接成字符串,也可以byte数组的形式返回)如果第二部在末尾补0了,每补"00",就在值后拼接一个'='
         *
         * @param data
         * @return
         */
        @Override
        public byte[] encoder(byte[] data) {//二进制字符串   //int类型最大是32位
            StringBuffer sb = new StringBuffer();
            int len = data.length;
            int i = 0;
            int b1, b2, b3;
            while (i < len) {
                b1 = data[i++] & 0xff;
                if (i == len) {
                    sb.append(base64EncodeChars[b1 >>> 2]);
                    sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                    sb.append("==");
                    break;
                }
                b2 = data[i++] & 0xff;
                if (i == len) {
                    sb.append(base64EncodeChars[b1 >>> 2]);
                    sb.append(base64EncodeChars[((b1 & 0x03) << 4)
                            | ((b2 & 0xf0) >>> 4)]);
                    sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                    sb.append("=");
                    break;
                }
                b3 = data[i++] & 0xff;
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4)
                        | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[((b2 & 0x0f) << 2)
                        | ((b3 & 0xc0) >>> 6)]);
                sb.append(base64EncodeChars[b3 & 0x3f]);
            }
            return sb.toString().getBytes(StandardCharsets.UTF_8);

        }
    }

    public static class Decoder implements Codec.Decoder {

        public byte[] decoder(String str) throws UnsupportedEncodingException {
            return this.decoder(str.getBytes(StandardCharsets.US_ASCII));
        }

//        /**
//         *4. 将前面得到的字符串进行按8分组,并去除前面多余的0(不去也行)
//         *5. 将每个二进制元素转为十进制,并放入byte数组,(可以直接返回数组,也可以拼接成字符串返回)
//         *
//         * @param str
//         */
//         public static byte[] decodeByte(String str){
//            String longStr = decode0(str);
//            //按8分组
//            String[] binaryEightStr = StringUtil.splitForLength(longStr, 8);
////            System.out.println("字符串转数组,按8补0后:"+ArrayUtils.toString(binaryEightStr));
//            byte [] b = new byte[binaryEightStr.length];
//            for (int i = 0; i < binaryEightStr.length; i++) {
//                binaryEightStr[i] = StringUtil.removeStartingNumStr(binaryEightStr[i], 0);//去除前面多余的0
//                //转为十进制
//                int decimalValue = Integer.valueOf(DecimalConversion.otherToDecimal(2, binaryEightStr[i]));
//                b[i] = (byte) decimalValue;
//            }
////            System.out.println("字符串转数组:"+ArrayUtils.toString(binaryEightStr));
////            System.out.println("待解码的文字的字节数组:"+ArrayUtils.toString(b));
//            return b;
//            //return new Strng(b);//TODO //不能随便new String,必须先getBytes(),然后在new String(),不然得到的字节数组前后会不一致,不然会出现异想不到的后果
//        }
//        
//                
//                
//                public static byte[] decodeByte(byte[] b){
//            return decodeByte(new String(b));
//        }
//        
//                
//                
//                /**
//          * 1. 去除字符串中的"=",并记录下"="出现的次数
//          * 2. 去除后的字符串,分成字符串数组,每个值去查 base64标准表,得到对应的下标索引,放入到一个数组中
//          * 3. 将数组拼接成一个完整的二进制字符串,并且去除末尾多余的0(通过"="出现的次数*2)
//          * @param bytes
//          * @return
//          */

        @Override
        public byte[] decoder(byte[] data) throws UnsupportedEncodingException {
            StringBuffer sb = new StringBuffer();
//            byte[] data =  str.getBytes(StandardCharsets.US_ASCII);
            int len = data.length;
            int i = 0;
            int b1, b2, b3, b4;
            while (i < len) {

                do {
                    b1 = base64DecodeChars[data[i++]];
                } while (i < len && b1 == -1);
                if (b1 == -1)
                    break;

                do {
                    b2 = base64DecodeChars[data[i++]];
                } while (i < len && b2 == -1);
                if (b2 == -1)
                    break;
                sb.append((char) ((b1 << 2) | ((b2 & 0x30) >>> 4)));

                do {
                    b3 = data[i++];
                    if (b3 == 61)
                        return sb.toString().getBytes("iso8859-1");
                    b3 = base64DecodeChars[b3];
                } while (i < len && b3 == -1);
                if (b3 == -1)
                    break;
                sb.append((char) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));

                do {
                    b4 = data[i++];
                    if (b4 == 61)
                        return sb.toString().getBytes("iso8859-1");
                    b4 = base64DecodeChars[b4];
                } while (i < len && b4 == -1);
                if (b4 == -1)
                    break;
                sb.append((char) (((b3 & 0x03) << 6) | b4));
            }
            return sb.toString().getBytes("iso8859-1");
        }
    }
}
