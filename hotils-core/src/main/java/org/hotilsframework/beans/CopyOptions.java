package org.hotilsframework.beans;

import org.hotilsframework.collection.Lists;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: CopyOptions
 * @Author: hireny
 * @Date: Create in 2019/12/19 14:17
 * @Description: TODO   属性拷贝选项
 *
 * 包括：
 *      1. 限制的类或接口，必须为目标对象的实现接口或父类，用于限制拷贝的属性，例如一个类我只想复制其父类的一些属性，就可以将editable设置为父类<br>
 *      2. 是否忽略空值，当源对象的值为null时，true: 忽略而不注入此值，false: 注入null<br>
 *      3. 忽略的属性列表，设置一个属性列表，不拷贝这些属性值<br>
 */
public class CopyOptions implements Serializable {

    private static final long serialVersionUID = -5649406277601803761L;

    private List<String> ignoreFields = Lists.newArrayList();



    /**
     * 创建拷贝选项
     * @return
     */
    public static CopyOptions create() {
        return new CopyOptions();
    }
}
