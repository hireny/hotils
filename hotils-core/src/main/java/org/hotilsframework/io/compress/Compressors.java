package org.hotilsframework.io.compress;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩工具
 * @author hireny
 * @className Compressors
 * @create 2020-06-12 18:01
 */
public class Compressors {
    /**
     * ZIP压缩后缀名
     */
    private static final String ZIP_FILE_SUFFIX = ".zip";

    /**
     * ZIP压缩文件
     * @param sourcePath        源文件地址
     * @param targetPath        目标文件地址
     */
    public static void zip(String sourcePath, String targetPath) {
        zip(new File(sourcePath), new File(targetPath));
    }

    /**
     * ZIP压缩文件
     * @param sourceFile        源文件
     * @param targetFile        目标文件
     */
    public static void zip(File sourceFile, File targetFile) {
        // 源文件不存在，报错
        if (!sourceFile.exists()) {
            throw new IllegalArgumentException("source not found.");
        }
        // 目的文件不存在，则新键
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 文件名
        String targetName = sourceFile.getName() + ZIP_FILE_SUFFIX;
        try (
                OutputStream os = new FileOutputStream(targetFile.getAbsolutePath() + "/" + targetName);
                ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(os))
        ) {
            compress(zos, sourceFile, "");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void compress(ZipOutputStream zos, File file, String directory) {
        try (
                InputStream is = new FileInputStream(file)
        ) {
            // 文件夹
            if (file.isDirectory()) {
                // 得到文件列表信息
                File[] files = file.listFiles();
                // 将文件夹添加到下一级打包目录
                zos.putNextEntry(new ZipEntry(directory + "/"));
                directory = directory.length() == 0 ? "" : directory + "/";
                // 循环将文件夹中的文件打包
                for (int i = 0; i < files.length; i++) {
                    // 递归处理
                    compress(zos, files[i], directory + files[i].getName());
                }
            } else {
                // 如果是文件则打包处理
                zos.putNextEntry(new ZipEntry(directory));
                // 进行写操作
                int length = 0;
                byte[] buffer = new byte[1024 * 8];
                while ((length = is.read(buffer)) != -1) {
                    zos.write(buffer, 0 , length);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
