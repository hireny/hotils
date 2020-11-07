package org.hotilsframework.utils;

import org.hotilsframework.web.HtmlUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: HtmlUtilsTest
 * @Author: hireny
 * @Date: Create in 2020/01/07 15:25
 * @Description: TODO
 */
public class HtmlUtilsTest {

    @Test
    public void escapeTest() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src/test/resources/test.txt"), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
            br = null;
            System.out.println(HtmlUtils.htmlEscape(sb.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void htmlEscape1() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("src/test/resources/test.txt"), "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
            br = null;
            System.out.println(HtmlUtils.htmlEscape(sb.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
