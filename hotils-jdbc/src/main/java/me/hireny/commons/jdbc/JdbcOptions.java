package me.hireny.commons.jdbc;

import java.util.Map;

/**
 * @ClassName: JdbcOptions
 * @Author: hireny
 * @Date: Create in 2019/12/11 13:57
 * @Description: TODO   JDBC操作
 */
public interface JdbcOptions {

    /**
     * 操作执行
     * @param action
     * @param <T>
     * @return
     * @throws DataAccessException
     */
    <T> T execute(ConnectionCallback<T> action) throws DataAccessException;

    /**
     * 操作执行
     * @param sql
     * @throws DataAccessException
     */
    void execute(String sql) throws DataAccessException;

//    <T> T query(String sql, ResultSetExtractor<T> res) throws DataAccessException;
//
//    void query(String sql, RowCallbackHandler rch) throws DataAccessException;
//
//    <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException;
//
//    <T> T queryForObject(String sql, RowMapper<T> rowMapper) throws DataAccessException;

    /**
     * 查询
     * @param sql
     * @param requiredType
     * @param <T>
     * @return
     * @throws DataAccessException
     */
    <T> T queryForObject(String sql, Class<T> requiredType) throws DataAccessException;

    /**
     * 查询
     * @param sql
     * @return
     * @throws DataAccessException
     */
    Map<String, Object> queryForMap(String sql) throws DataAccessException;

    /**
     * 更新
     * @param sql
     * @return
     * @throws DataAccessException
     */
    int update(String sql) throws DataAccessException;

    /**
     * 批量更新
     * @param sql
     * @return
     * @throws DataAccessException
     */
    int[] batchUpdate(String... sql) throws DataAccessException;
}
