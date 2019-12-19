//package me.hireny.commons.core.beans;
//
///**
// * @ClassName: BeanUtils
// * @Author: hireny
// * @Date: Create in 2019/12/09 01:25
// * @Description: TODO   Bean工具类
// */
//public final class BeanUtils {
//
//    private BeanUtils() {}
//
//
//    //****************Bean copyProperties********************//
//
//    /**
//     * 复制Bean对象属性
//     * @param source    源Bean对象
//     * @param target    目标Bean对象
//     */
//    public static void copyProperties(Object source, Object target) {
//        copyProperties(source, target, CopyOptions.create());
//    }
//
//    /**
//     * 复制Bean对象属性
//     * 限制类用于限制拷贝的属性，例如一个类我只想复制其父类的一些属性，就可以将editable设置为父类
//     *
//     * @param source                源Bean对象
//     * @param target                目标Bean对象
//     * @param ignoreProperties      不拷贝的属性列表
//     */
//    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
//        copyProperties(source, target, CopyOptions.create().setIgnoreProperties(ignoreProperties));
//    }
//
//    /**
//     * 复制Bean对象属性
//     * @param source                源Bean对象
//     * @param target                目标Bean对象
//     * @param ignoreCase            是否忽略大小写
//     */
//    public static void copyProperties(Object source, Object target, boolean ignoreCase) {
//        BeanOptions.create(source, target, CopyOptions.create().setIgnoreCase(ignoreCase)).copy();
//    }
//
//    /**
//     * 复制Bean对象属性
//     * 限制类用于限制拷贝的属性，例如一个类我只想复制其父类的一些属性，就可以将editable设置为父类
//     *
//     * @param source            源Bean对象
//     * @param target            目标Bean对象
//     * @param copyOptions       拷贝选项
//     */
//    public static void copyProperties(Object source, Object target, CopyOptions copyOptions) {
//        if (null == copyOptions) {
//            copyOptions = new CopyOptions();
//        }
//        BeanOptions.create(source, target, copyOptions).copy();
//    }
//}
