package me.hireny.commons.core.escape;

import java.util.function.Function;

/**
 * @ClassName: Escaper
 * @Author: hireny
 * @Date: Created in 2020-01-13 19:43
 * @Version: 1.0
 */
public abstract class Escaper {

    protected Escaper() {}

    public abstract String escape(String string);

    private final Function<String, String> asFunction =
            from -> escape(from);
    // from -> escape(from) 相当于
    //new Function<String, String>() {
    //    @Override
    //    public String apply(String from) {
    //        return escape(from);
    //    }
    //};

    public final Function<String, String> asFunction() {
        return asFunction;
    }
}
