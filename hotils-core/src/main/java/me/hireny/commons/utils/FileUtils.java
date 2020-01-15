package me.hireny.commons.utils;

import java.io.File;
import java.io.FileFilter;
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
}
