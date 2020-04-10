package org.hotilsframework.core;

/**
 * 别名注册接口
 * @author hireny
 * @className AliasRegistry
 * @create 2020-04-09 17:57
 */
public interface AliasRegistry {
    /**
     * 别名注册
     * @param name      名字
     * @param alias     别名
     */
    void registerAlias(String name, String alias);

    /**
     * 根据别名进行删除
     * @param alias 名称
     */
    void removeAlias(String alias);

    /**
     * 确定给定的名称是否定义了别名
     * @param name  名称
     * @return
     */
    boolean isAlias(String name);

    /**
     * 根据给定的名称获取所有与该名称有关的别名
     * @param name  名称
     * @return
     */
    String[] getAliases(String name);
}
