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
        // 2.实例化statementhandler
//        StatementHandler statementHandler = new DefaultStatementHandler(statement);
        // 3.获取prepareStatement
//        PreparedStatement preparedStatement = statementHandler.prepare(connection);
        // 4.实例化prepareHandler对象，sql语句占位符
//        ParameterHandler parameterHandler = new DefaultParameterHandler(paramter);
//        parameterHandler.setParameters(preparedStatement);
        // 5.查询
//        ResultSet resultset = statementHandler.query(preparedStatement);
        // 对resultSet进行处理
//        ResultSetHandler resultSetHandler = new DefaultResultSetHandler(statement);
//        return resultSetHandler.handleResultSets(resultset);
    }

    /**
     * 获取数据库的连接，和jdbc一样的方式
     * @return
     */
    @Before
    private Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName(configuration.getDbDriver());
//            connection = DriverManager.getConnection(configuration.getDbUrl(),
//                    configuration.getDbUserName(), configuration.getDbPassWord());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
        return null;
    }
}
