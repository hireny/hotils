package org.hotilsframework.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper
 *
 * 行映射 <br>
 *
 * 用于实现每行记录之间的映射关系
 *
 * @author hireny
 * @create 2020-10-11 21:12
 */
public interface RowMapper<T> {
    /**
     * 映射行
     * @param rs
     * @param rowNum
     * @return
     * @throws SQLException
     */
    T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
