package me.hireny.commons.jdbc;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * @ClassName: JdbcTest
 * @Author: hireny
 * @Date: Create in 2019/12/22 00:10
 * @Description: TODO   Jdbc原生操作
 */
public class JdbcTest {
//    com.mysql.cj.jdbc.Driver
//    jdbc:mysql://127.0.0.1:3306/db_test?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&autoReconnect=true&serverTimezone=UTC
//    root
//    HX1992@hireny~

    /**
     * 原生Jdbc测试查询功能
     */
    @Test
    public void jdbcTestQuery1() {
        // 1.获取连接
        Connection connection = getConnection();
        // 使用预编译语句
        PreparedStatement pstmt = null;
        // 获取的结果集
        ResultSet rs = null;
        // 设置的预编译语句格式
        String sql = "SELECT * FROM USER WHERE id=?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1);
            rs = pstmt.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setGender(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setTelephone(rs.getString(6));
                user.setIntroduce(rs.getString(7));
                user.setActiveCode(rs.getString(8));
                user.setState(rs.getInt(9));
                user.setRole(rs.getString(10));
                user.setRegistTime(rs.getTimestamp(11));
            }
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源,倒关
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试
     */
    @Test
    public void jdbcTestQuery2() {
        // 1.获取连接
        Connection connection = getConnection();
        // 使用预编译语句
        PreparedStatement pstmt = null;
        // 获取的结果集
        ResultSet rs = null;
        // 设置的预编译语句格式
        String sql = "SELECT * FROM USER WHERE id=?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 1);
            rs = pstmt.executeQuery();
            User user = new User();
            if (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setGender(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setTelephone(rs.getString(6));
                user.setIntroduce(rs.getString(7));
                user.setActiveCode(rs.getString(8));
                user.setState(rs.getInt(9));
                user.setRole(rs.getString(10));
                user.setRegistTime(rs.getTimestamp(11));
            }
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源,倒关
            try {
                if (rs!=null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取数据库的连接，和jdbc一样的方式
     * @return
     */
//    @Before
    private Connection getConnection() {
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
