package org.hotilsframework.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hireny
 * @className JdbcUtils
 * @create 2020-07-04 7:47
 */
public class DBConnections {



    /**
     * 获取数据库的连接，和jdbc一样的方式
     * @return
     */
    protected static Connection getConnection() {
        // 设置驱动
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        //  设置连接路径
        String url = "jdbc:mysql://127.0.0.1:3306/db_test?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&serverTimezone=UTC";
        // 设置数据库用户名
        String username = "root";
        // 设置数据库连接密码
        String password = "HX1992@hireny~";
        // 连接
        Connection connection = null;

        try {
            // 执行驱动
            Class.forName(driverClassName);
            // 获取连接
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
