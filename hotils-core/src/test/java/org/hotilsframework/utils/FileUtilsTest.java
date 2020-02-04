package org.hotilsframework.utils;

import org.junit.Test;

import java.util.List;

/**
 * 文件工具测试类
 * @ClassName: FileUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-01-22 14:18
 * @Version: 1.0
 */
public class FileUtilsTest {

    @Test
    public void getListFile() {
        String s = "C:\\Users\\hireny\\Projects\\HIAVEN";
        List list = FileUtils.listFiles(s, true);
        list.forEach(System.out::println);
    }

    /**
     * 判断文件是否存在
     */
    @Test
    public void fileIsExist() {
        String s = "C:\\Users\\hireny\\Downloads\\spring-framework-master\\spring-core\\src\\main\\java\\org\\springframework\\util\\SerializationUtils.java";
        System.out.println(FileUtils.isExist(s, false));
    }

    /**
     * 文件大小
     */
    @Test
    public void fileSizeTest() {
        String s = "C:\\Users\\hireny\\Downloads\\spring-framework-master\\spring-core\\src\\main\\java\\org\\springframework\\util\\SerializationUtils.java";
        long size = FileUtils.size(s);
        System.out.println(size);
        System.out.println(FileUtils.byteUnits(size));
    }

    /**
     * 文件删除
     */
    @Test
    public void fileDeleteTest() {
        String fileName = "C:\\Users\\hireny\\Documents\\新简历2.docx";
        FileUtils.delete(fileName);
    }

    @Test
    public void fileCopyTest() {
        String sourceFileName = "C:\\Users\\hireny\\Documents\\新简历.docx";
        String targetFileName = "C:\\Users\\hireny\\Documents\\新简历2.docx";
        FileUtils.copy(sourceFileName, targetFileName, true);
    }

    /**
     * 文件重命名
     */
    @Test
    public void fileRenameTest() {
        String oldFileName = "C:\\Users\\hireny\\Documents\\简历.docx";
        String newFileName = "C:\\Users\\hireny\\Documents\\新简历.docx";
        boolean isDel = FileUtils.renameTo(oldFileName, newFileName);
        System.out.println("是否删除="+isDel);
    }
}
