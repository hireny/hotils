package org.hotilsframework.lang.primitives;

import org.hotilsframework.lang.enums.Sex;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 字符测试类
 * @ClassName: CharsTest
 * @Author: hireny
 * @Date: Created in 2020-02-04 13:20
 * @Version: 1.0
 */
public class CharsTest {

    @Test
    public void isAsciiTest() {
        System.out.println("测试字符是否为ASCII字符");
        System.out.println(Chars.of('a').isAscii());
        System.out.println(Chars.of('A').isAscii());
        System.out.println(Chars.of('3').isAscii());
        System.out.println(Chars.of('-').isAscii());
        System.out.println(Chars.of('\n').isAscii());
        // 这里会包错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isAscii());
    }

    @Test
    public void isAsciiPrintableTest() {
        System.out.println("测试字符是否为可见ASCII字符");
        System.out.println(Chars.of('a').isAsciiPrintable());
        System.out.println(Chars.of('A').isAsciiPrintable());
        System.out.println(Chars.of('3').isAsciiPrintable());
        System.out.println(Chars.of('-').isAsciiPrintable());
        System.out.println(Chars.of('\n').isAsciiPrintable());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isAsciiPrintable());
    }

    @Test
    public void isAsciiControlTest() {
        System.out.println("测试字符是否为ASCII控制符");
        System.out.println(Chars.of('a').isAsciiControl());
        System.out.println(Chars.of('A').isAsciiControl());
        System.out.println(Chars.of('3').isAsciiControl());
        System.out.println(Chars.of('-').isAsciiControl());
        System.out.println(Chars.of('\n').isAsciiControl());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isAsciiControl());
    }

    @Test
    public void isLetterTest() {
        System.out.println("测试字符是否为字母：");
        System.out.println(Chars.of('a').isLetter());
        System.out.println(Chars.of('A').isLetter());
        System.out.println(Chars.of('3').isLetter());
        System.out.println(Chars.of('-').isLetter());
        System.out.println(Chars.of('\n').isLetter());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isLetter());
    }

    @Test
    public void isLetterUpperTest() {
        System.out.println("测试字符是否为大写字母：");
        System.out.println(Chars.of('a').isLetterUpper());
        System.out.println(Chars.of('A').isLetterUpper());
        System.out.println(Chars.of('3').isLetterUpper());
        System.out.println(Chars.of('-').isLetterUpper());
        System.out.println(Chars.of('\n').isLetterUpper());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isLetterUpper());
    }

    @Test
    public void isLetterLowerTest() {
        System.out.println("测试字符是否为小写字母：");
        System.out.println(Chars.of('a').isLetterLower());
        System.out.println(Chars.of('A').isLetterLower());
        System.out.println(Chars.of('3').isLetterLower());
        System.out.println(Chars.of('-').isLetterLower());
        System.out.println(Chars.of('\n').isLetterLower());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isLetterLower());
    }

    @Test
    public void isNumberTest() {
        System.out.println("测试字符是否为数字：");
        System.out.println(Chars.of('a').isNumber());
        System.out.println(Chars.of('A').isNumber());
        System.out.println(Chars.of('3').isNumber());
        System.out.println(Chars.of('-').isNumber());
        System.out.println(Chars.of('\n').isNumber());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isNumber());
    }

    @Test
    public void isHexTest() {
        System.out.println("测试字符是否为16进制规范的字符：");
        System.out.println(Chars.of('a').isHex());
        System.out.println(Chars.of('A').isHex());
        System.out.println(Chars.of('3').isHex());
        System.out.println(Chars.of('g').isHex());
        System.out.println(Chars.of('-').isHex());
        System.out.println(Chars.of('\n').isHex());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isHex());
    }

    @Test
    public void isLetterOrNumberTest() {
        System.out.println("测试字符是否为字母或者数字：");
        System.out.println(Chars.of('a').isLetterOrNumber());
        System.out.println(Chars.of('A').isLetterOrNumber());
        System.out.println(Chars.of('3').isLetterOrNumber());
        System.out.println(Chars.of('-').isLetterOrNumber());
        System.out.println(Chars.of('\n').isLetterOrNumber());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').isLetterOrNumber());
    }

    @Test
    public void toStringTest() {
        System.out.println("测试字符转换为字符串：");
        System.out.println(Chars.of('a').toString());
        System.out.println(Chars.of('A').toString());
        System.out.println(Chars.of('3').toString());
        System.out.println(Chars.of('\n').toString());
        System.out.println(Chars.of('-').toString());
        // 这里会报错误，字符文字中的字符太多
//        System.out.println(Chars.of('&copy;').toString());
    }

    @Test
    public void isCharClassTest() {
        System.out.println("测试类名是否为字符类：");
        System.out.println(Chars.isCharClass(int.class));
        System.out.println(Chars.isCharClass(Float.class));
        System.out.println(Chars.isCharClass(char.class));
        System.out.println(Chars.isCharClass(Character.class));
        System.out.println(Chars.isCharClass(Sex.class));
    }

    @Test
    public void isCharTest() {
        System.out.println("测试对象对应的类是否为字符类：");
        System.out.println(Chars.isChar(123));
        System.out.println(Chars.isChar("Hello World!"));
        System.out.println(Chars.isChar('a'));
        System.out.println(Chars.isChar('\n'));
        System.out.println(Chars.isChar(new ArrayList<>()));
    }

    @Test
    public void isBlankCharTest() {
        System.out.println("测试字符是否为空白符：");
        System.out.println(Chars.of('a').isBlankChar());
        System.out.println(Chars.of(' ').isBlankChar());
        System.out.println(Chars.of('3').isBlankChar());
    }

    @Test
    public void isFileSeparatorTest() {
        System.out.println("测试字符是否为文件分隔符：");
        System.out.println(Chars.of('/').isFileSeparator());
        System.out.println(Chars.of('\\').isFileSeparator());
        System.out.println(Chars.of('a').isFileSeparator());
        System.out.println(Chars.of('3').isFileSeparator());
        System.out.println(Chars.of('\n').isFileSeparator());
    }

    @Test
    public void equalsTest() {
        System.out.println("测试字符是否相等：");
        System.out.println(Chars.of('a').equals('b'));
        System.out.println(Chars.of('a').equals('a'));
        System.out.println(Chars.of('\n').equals('c'));
        System.out.println(Chars.of('a').equals(Chars.of('a')));
        System.out.println(Chars.of('a').equals(Chars.of('A')));
    }

    @Test
    public void equalsIgnoreCase() {
        System.out.println("测试字符是否相等（忽略大小写）：");
        System.out.println(Chars.of('a').equalsIgnoreCase('b'));
        System.out.println(Chars.of('a').equalsIgnoreCase('a'));
        System.out.println(Chars.of('\n').equalsIgnoreCase('c'));
        System.out.println(Chars.of('a').equalsIgnoreCase(Chars.of('a')));
        System.out.println(Chars.of('a').equalsIgnoreCase(Chars.of('A')));
    }
}
