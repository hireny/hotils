package org.hotilsframework.inject;

import java.lang.reflect.Member;

/**
 * InjectedPoint
 *
 * 注入的节点
 *
 * @author hireny
 * @create 2020-08-03 21:16
 */
public class InjectedPoint {
    /**
     * 注入位置
     *
     * 字段，方法，构造
     */
    private final Member member;

    public InjectedPoint(Member member) {
        this.member = member;
    }
}
