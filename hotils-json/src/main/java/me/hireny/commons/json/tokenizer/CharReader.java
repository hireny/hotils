package me.hireny.commons.json.tokenizer;

import java.io.IOException;
import java.io.Reader;

/**
 * 读取字符
 *
 * @Author: hireny
 * @Date: Create in 2019/07/16 14:28
 */
public class CharReader {

    private static final int BUFFER_SIZE = 1024;
    private Reader reader;  //字符读取器
    private char[] buffer;  //缓冲池，存放字符读取器读取的字符的字符数组
    private int index;      //下标
    private int size;       //大小

    public CharReader(Reader reader) {
        this.reader = reader;
        buffer = new char[BUFFER_SIZE];
    }
    public char[] getBuffer() {
        return buffer;
    }

    /**
     * 返回 pos 下标处的字符，并返回
     * @return
     */
    public char peek() {
        if (index -1 >= size) {
            return (char) -1;
        }
        return buffer[Math.max(0, index - 1)];
    }

    /**
     * 返回 pos 下标处的字符，并将 pos + 1，最后返回字符下一个
     * @return
     * @throws IOException
     */
    public char next() throws IOException {
        if (!hasMore()) {
            return (char) -1;
        }
        return buffer[index++];
    }

    /**
     * 下标回退
     */
    public void back() {
        index = Math.max(0, --index);
    }

    /**
     * 判断流是否结束
     * @return  返回true表示未结束
     * @throws IOException
     */
    public boolean hasMore() throws IOException {
        if (index < size) {
            return true;
        }
        fillBuffer();
        return index < size;
    }

    /**
     * 填充buffer数组
     * @throws IOException
     */
    private void fillBuffer() throws IOException {
        int n = reader.read(buffer);
        if (n == -1) {
            return;
        }
        index = 0;
        size = n;
    }
}
