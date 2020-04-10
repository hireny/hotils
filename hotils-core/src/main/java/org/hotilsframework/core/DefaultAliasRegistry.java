package org.hotilsframework.core;

/**
 * @author hireny
 * @className DefaultAliasRegistry
 * @create 2020-04-09 17:59
 */
public class DefaultAliasRegistry implements AliasRegistry {
    @Override
    public void registerAlias(String name, String alias) {

    }

    @Override
    public void removeAlias(String alias) {

    }

    @Override
    public boolean isAlias(String name) {
        return false;
    }

    @Override
    public String[] getAliases(String name) {
        return new String[0];
    }
}
