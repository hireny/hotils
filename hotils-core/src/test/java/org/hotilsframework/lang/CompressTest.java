package org.hotilsframework.lang;

import org.hotilsframework.io.Compress;
import org.junit.Test;

/**
 * @ClassName: CompressUtilsTest
 * @Author: hireny
 * @Date: Created in 2020-01-29 15:33
 * @Version: 1.0
 */
public class CompressTest {

    @Test
    public void zipTest() {
        String zipName = "C:\\Users\\hireny\\Documents\\新简历1.docx";
        String zipDirec = "C:\\Users\\hireny\\Documents\\新简历1";
        Compress.zip(zipName, zipDirec);
    }
}
