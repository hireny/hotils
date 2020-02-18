package org.hotilsframework.core.logging;

import java.io.IOException;

/**
 * @author hireny
 * @className ConsoleAppender
 * @create 2020-02-18 0:23
 */
public class ConsoleAppender extends AbstractAppender {


    @Override
    protected void doAppend(String body) {
        try {
            System.out.write(body.getBytes(encoding));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
