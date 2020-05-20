package org.hotilsframework.jdbc;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName: JdbcTemplate
 * @Author: hireny
 * @Date: Create in 2019/12/11 14:00
 * @Description: TODO   JDBC操作模板
 */
public class JdbcTemplate extends JdbcAccessor implements JdbcOptions {

    public JdbcTemplate() {}

    public JdbcTemplate(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public <T> T execute(ConnectionCallback<T> action) throws DataAccessException {
        return null;
    }

    @Override
    public void execute(String sql) throws DataAccessException {

    }

    @Override
    public <T> T queryForObject(String sql, Class<T> requiredType) throws DataAccessException {
        return null;
    }

    @Override
    public Map<String, Object> queryForMap(String sql) throws DataAccessException {
        return null;
    }

    @Override
    public int update(String sql) throws DataAccessException {
        return 0;
    }

    @Override
    public int[] batchUpdate(String... sql) throws DataAccessException {
        return new int[0];
    }
}
