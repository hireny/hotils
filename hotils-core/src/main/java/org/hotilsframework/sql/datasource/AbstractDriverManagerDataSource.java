package org.hotilsframework.sql.datasource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName: AbstractDriverManagerDataSource
 * @Author: hireny
 * @Date: Create in 2019/12/11 13:35
 * @Description: TODO   数据库驱动管理
 */
public abstract class AbstractDriverManagerDataSource extends AbstractDataSource {

    /**
     * 数据库驱动配置项
     */
    private DriverManagerProperties properties;

    public AbstractDriverManagerDataSource() {}

    public AbstractDriverManagerDataSource(String url, String username, String password) {
        this.properties = new DriverManagerProperties();
        this.properties.setUrl(url);
        this.properties.setUsername(username);
        this.properties.setPassword(password);
    }

    public DriverManagerProperties getProperties() {
        return properties;
    }

    public void setProperties(DriverManagerProperties properties) {
        this.properties = properties;
    }

    /**
     * 进行数据库的连接
     * @return
     * @throws SQLException
     */
    @Override
    public Connection getConnection() throws SQLException {
        return getConnection(properties.getUsername(), properties.getPassword());
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return getConnectionFromDriver(username, password);
    }

    /**
     * 数据库驱动连接
     * @param username      用户名
     * @param password      密码
     * @return
     */
    public Connection getConnectionFromDriver(String username, String password) throws SQLException {
        // 合并后的配置
        Properties mergedProps = new Properties();
        // 连接的配置
        Properties connProp = properties.getConnectionProperties();
        if (connProp != null) {
            mergedProps.putAll(connProp);
        }
        if (username != null) {
            mergedProps.setProperty("user", username);
        }
        if (password != null) {
            mergedProps.setProperty("password", password);
        }
        Connection connection = getConnectionFromDriver(mergedProps);
        return connection;
    }

    protected abstract Connection getConnectionFromDriver(Properties props) throws SQLException;
}
