package org.hotilsframework.jdbc.handler;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ResultSetHandler
 *
 * 结果集处理器
 *
 * @author hireny
 * @date Create in 2020/01/04 14:37
 */
@FunctionalInterface
public interface ResultSetHandler<T> extends Serializable {

    /**
     * 处理结果集
     * 结果集处理后不需要关闭
     *
     * @param rs                结果集
     * @return                  处理后生成的对象
     * @throws SQLException     SQL异常
     */
    T handle(ResultSet rs) throws SQLException;
}
