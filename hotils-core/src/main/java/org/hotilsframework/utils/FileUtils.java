package org.hotilsframework.utils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @ClassName: FileUtils
 * @Description: TODO   文件工具类
 * @Author: hireny
 * @Date: Created in 2020-01-10 2:35
 * @Version: 1.0
 */
public class FileUtils {

    /**
     * 类Unix路径分隔符
     */
    private static final char UNIX_SEPARATOR = '/';
    /**
     * Windows路径分隔符
     */
    private static final char WINDOWS_SEPARATOR = '\\';
    /**
     * Windows下文件名中的无效字符
     */
    private static Pattern FILE_NAME_INVALID_PATTERN_WIN = Pattern.compile("[\\\\/:*?\"<>|]");
    private static final String FOLDER_SEPARATOR = "/";
    private static final char EXTENSION_SEPARATOR = '.';

    /**
     * 判断文件是否为空
     * 目录：里面没有文件时为空 文件：文件大小为0时为空
     *
     * @param file  文件
     * @return      是否为空，当提供非目录时，返回false
     */
    public static boolean isEmpty(File file) {
        if (null == file) {
            return true;
        }
        if (file.isDirectory()) {
            String[] subFiles = file.list();
            return ArrayUtils.isEmpty(subFiles);
        } else if (file.isFile()) {
            return file.length() <= 0;
        }
        return false;
    }

    /**
     * 文件列表
     * @param input         文件地址
     * @param recursive     是否递归
     * @return
     */
    public static List<File> listFiles(String input, boolean recursive) {
        File file = new File(input);
        return listFiles(file, recursive);
    }

    /**
     * 文件列表
     * @param input     文件地址
     * @param recursive 是否递归
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
            // 新键文件夹
            return file.mkdirs();
        }
        return file.exists();
    }

    public static String byteUnits(long size) {
        // 如果字节数少于1024，则直接以B为单位，否则先除以1024，后3位因太少无意义
        if (size < 1024) {
            return size + "B";
        } else {
            size = size / 1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位
        //因为还没有到达要使用另一个单位的时候
        //接下去以此类推
        if (size < 1024) {
            return size + "KB";
        } else {
            size = size / 1024;
        }
        if (size < 1024) {
            //因为如果以MB为单位的话，要保留最后1位小数，
            //因此，把此数乘以100之后再取余
            size = size * 100;
            return size / 100 + "."
                    + size % 100 + "MB";
        } else {
            //否则如果要以GB为单位的，先除于1024再作同样的处理
            size = size * 100 / 1024;
            return size / 100 + "."
                    + size % 100 + "GB";
        }
    }

    /**
     * 获取文件大小
     * @param filePath
     * @return
     */
    public static long size(String filePath) {
        return size(new File(filePath));
    }

    /**
     * 获取文件大小
     * @param file
     * @return
     */
    public static long size(File file) {
        return sizeOfFile(file);
    }

    private static long sizeOfDirectory(final File directory) {
        final File[] files = directory.listFiles();
        if (files == null) {
            return 0L;
        }

        long size = 0;

        for (final File file : files) {
            if (!isSymlink(file)) {
                size += sizeOfFile(file);
                if (size < 0) {
                    break;
                }
            }
        }
        return size;
    }

    private static long sizeOfFile(File file) {
        if (file.isDirectory()) {
            return sizeOfDirectory(file);
        }
        return file.length();
    }

    /**
     * 是否是链接
     * @param file
     * @return
     */
    public static boolean isSymlink(final File file) {
        return Files.isSymbolicLink(file.toPath());
    }

    /**
     * 删除文件/文件夹
     * @param filePath  文件路径
     */
    public static void delete(String filePath) {
        delete(new File(filePath));
    }

    /**
     * 删除文件/文件夹
     * @param file      文件
     */
    public static void delete(File file) {
        if (!file.exists()) {
            // 目录不存在退出
            throw new IllegalArgumentException("File Path not found.");
        }
        if (file.isFile()) {
            // 如果是文件删除
            file.delete();
            return;
        }
        File[] files = file.listFiles();    //如果目录中有文件递归删除文件
        for (int i = 0; i < files.length; i++) {
            delete(files[i].getAbsolutePath());
        }
        file.delete();
    }

    /**
     * 文件重命名
     * @param oldFilePath   旧文件地址
     * @param newFilePath   新文件地址
     * @return
     */
    public static boolean renameTo(String oldFilePath, String newFilePath) {
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);

        return oldFile.renameTo(newFile);
    }

    /**
     * 复制文件或文件夹
     * @param sourceFilePath        源文件地址
     * @param targetFilePath        目标文件地址
     * @param isOverWrite           是否覆盖
     */
    public static void copy(String sourceFilePath, String targetFilePath, boolean isOverWrite) {
        copy(new File(sourceFilePath), new File(targetFilePath), isOverWrite);
    }

    /**
     * 复制文件或文件夹
     * @param sourceFile        源文件
     * @param targetFile        目标文件
     * @param isOverWrite       是否覆盖
     */
    public static void copy(File sourceFile, File targetFile, boolean isOverWrite) {
        if (!sourceFile.exists()) {
            throw new RuntimeException(sourceFile.getPath() + "源目录不存在!");
        }
        if (sourceFile.isFile()) {
            // 文件
            doCopy(sourceFile, targetFile, isOverWrite);
        } else {
            // 文件夹
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            // 循环子文件夹
            for (File child : sourceFile.listFiles()) {
                doCopy(child, new File(targetFile.getPath() + "/" + child.getName()), isOverWrite);
            }
        }
    }

    /**
     * 复制文件
     * @param sourceFile        源文件
     * @param targetFile        目标文件
     * @param isOverWrite       是否覆盖
     */
    private static void doCopy(File sourceFile, File targetFile, boolean isOverWrite) {
        if (targetFile.exists() && isOverWrite) {
            // 可以覆盖
            if (!targetFile.delete()) {
                // 无法覆盖
                throw new RuntimeException(targetFile.getPath() + "Can't cover!");
            }
        }
        // 创建输入输出流对象
        try (
                InputStream is = new FileInputStream(sourceFile);
                OutputStream os = new FileOutputStream(targetFile)
        ) {
            // 创建搬运工具
            byte[] buffer = new byte[1024 * 8];
            // 创建长度
            int length = 0;
            // 循环读取数据
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
