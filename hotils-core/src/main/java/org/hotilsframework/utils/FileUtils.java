package org.hotilsframework.utils;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: FileUtils
 * @Description: TODO   文件工具类
 * @Author: hireny
 * @Date: Created in 2020-01-10 2:35
 * @Version: 1.0
 */
public class FileUtils {

    private static final String FOLDER_SEPARATOR = "/";
    private static final char EXTENSION_SEPARATOR = '.';

    /**
     * 文件列表
     * @param input     文件地址
     * @param recursive
     * @return
     */
    public static List<File> listFiles(File input, boolean recursive) {
        List<File> files = new ArrayList<>();
        scanFiles(input, recursive, (filename) -> true, files);
        return files;
    }

    public static List<File> listFiles(File input, boolean recursive, FileFilter filter) {
        List<File> files = new ArrayList<>();
        scanFiles(input, recursive, filter, files);
        return files;
    }

    private static void scanFiles(File input, boolean recursive, FileFilter filter, List<File> files) {
        if (input.isDirectory()) {
            File[] tmp = input.listFiles(filter);
            if (tmp == null) {
                return;
            }
            for (File f : tmp) {
                if (f.isFile()) {
                    files.add(f);
                } else if (recursive) {
                    // Directory()
                    scanFiles(f, recursive, filter, files);
                }
            }
        } else {
            files.add(input);
        }
    }

    /**
     * 判断指定文件路径是否存在，如果不存在根据参数决定是否新键
     * @param filePath  指定文件路径
     * @param isNew     是否新键
     * @return          存在返回true，不存在返回false
     */
    public static boolean isExist(String filePath, boolean isNew) {
        File file = new File(filePath);
        return isExist(file, isNew);
    }

    /**
     * 判断指定文件是否存在，如果不存在根据参数决定是否新键
     * @param file      指定文件
     * @param isNew     是否新键
     * @return          存在返回true，不存在返回false
     */
    public static boolean isExist(File file, boolean isNew) {
        if (!file.exists() && isNew) {
            return file.mkdirs();
        }
        return false;
    }
}
