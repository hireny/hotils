package org.hotilsframework.jdbc;

import org.junit.Test;

import java.sql.*;

import static org.hotilsframework.jdbc.DBConnections.getConnection;

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


}
