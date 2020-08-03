package org.hotilsframework.inject;

import org.hotilsframework.inject.binder.ModuleBinder;

import java.util.Arrays;
import java.util.List;

/**
 * Bindings
 *
 * 根据模块信息获取绑定元素
 *
 * @author hireny
 * @create 2020-08-02 18:33
 */
public class Bindings {

    public static List<Binding<?>> getBindings(Module... modules) {
        return getBindings(Arrays.asList(modules));
    }

    public static List<Binding<?>> getBindings(Iterable<? extends Module> modules) {
        ModuleBinder binder = new ModuleBinder();
        modules.forEach(binder::install);
        return binder.getElements();
    }
}
