package me.hireny.commons.utils.patterns;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/17 00:19
 */
public abstract class CommonsPattern {
    public abstract boolean matches();

    public abstract boolean find();

    public abstract boolean find(int index);

    public abstract String replaceAll(String replacement);

    public abstract int end();

    public abstract int start();
}
