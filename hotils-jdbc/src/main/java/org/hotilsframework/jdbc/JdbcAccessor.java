package org.hotilsframework.jdbc;

import org.hotilsframework.lang.Nullable;

import javax.sql.DataSource;

/**
 * Jdbc抽象处理类
 * @author hireny
 * @className JdbcAccessor
 * @create 2020-05-10 12:18
 */
public abstract class JdbcAccessor {

    @Nullable
    private DataSource dataSource;

    private boolean lazyInit = true;

    @Nullable
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }
}
