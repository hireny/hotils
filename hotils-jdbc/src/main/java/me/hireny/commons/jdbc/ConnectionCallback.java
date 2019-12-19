package me.hireny.commons.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName: ConnectionCallback
 * @Author: hireny
 * @Date: Create in 2019/12/11 13:58
 * @Description: TODO   连接处理
 */
public interface ConnectionCallback<T> {
    T doInConnection(Connection connection) throws SQLException, DataAccessException;
}
