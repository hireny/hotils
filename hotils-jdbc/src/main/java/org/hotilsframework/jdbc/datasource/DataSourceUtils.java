package org.hotilsframework.jdbc.datasource;

import org.hotilsframework.jdbc.JdbcConnectionException;
import org.hotilsframework.lang.Assert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: DataSourceUtils
 * @Author: hireny
 * @Date: Create in 2020/01/04 15:13
 * @Description: TODO   数据源工具
 */
public class DataSourceUtils {

    public static Connection getConnection(DataSource dataSource) {
        try {
            return doGetConnection(dataSource);
        } catch (SQLException e) {
            throw new JdbcConnectionException("Failed to obtain JDBC Connection", e);
        }
    }

    public static Connection doGetConnection(DataSource dataSource) throws SQLException {
        // 没有指定数据源
        Assert.notNull(dataSource, "No DataSource specified");
        return null;
    }
}
