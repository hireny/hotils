package org.hotilsframework.core.security.crypto;

import org.hotilsframework.core.codec.Hex;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: CryptoUtils
 * @Author: hireny
 * @Date: Create in 2019/12/06 15:58
 * @Description: TODO   加密工具类
 */
public class CryptoUtils {

    /**
     * 获得字符串的md5值
     *
     * @param str 待加密的字符串
     * @return md5加密后的字符串
     */
    public static String getMD5String(String str) {
        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(str.getBytes("UTF-8"));
            return Hex.bytesToHex(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获得文件的md5值
     * @param file  文件对象
     * @return  文件的md5
     */
    public static String getFileMd5String(File file) {
        String result = "";
        try (
                FileInputStream in = new FileInputStream(file);
                FileChannel channel = in.getChannel()
                ) {
            ByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            result = Hex.bytesToHex(md5.digest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 效验文件的md5值
     * @param file  目标文件
     * @param md5   基准md5
     * @return  效验结果
     */
    public static boolean checkFileMd5(File file, String md5) {
        return getFileMd5String(file).equalsIgnoreCase(md5);
    }

    /**
     * 效验字符串的md5值
     * @param str   目标字符串
     * @param md5   基准md5
     * @return      效验结果
     */
    public static boolean checkMd5(String str, String md5) {
        return getMD5String(str).equalsIgnoreCase(md5);
    }
}
