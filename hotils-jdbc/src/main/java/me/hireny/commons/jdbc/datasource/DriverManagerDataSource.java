package me.hireny.commons.jdbc.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName: DriverManagerDataSource
 * @Author: hireny
 * @Date: Create in 2019/12/11 13:47
 * @Description: TODO
 */
public class DriverManagerDataSource extends AbstractDriverManagerDataSource {

    public DriverManagerDataSource() {}

    public DriverManagerDataSource(String url, String username, String password) {
        super(url, username, password);
    }

    public void setDriverClassName(String driverClassName) {
        String driverClassNameToUse = driverClassName.trim();
        try {
            Class.forName(driverClassNameToUse);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Could not load JDBC driver class [" + driverClassName + "]", e);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Loaded JDBC driver: " + driverClassNameToUse);
        }
    }

    @Override
    protected Connection getConnectionFromDriver(Properties props) throws SQLException {
        String url = getProperties().getUrl();
        if (logger.isDebugEnabled()) {
            logger.debug("Creating new JDBC DriverManager Connection to [" + url + "]");
        }
        return getConnectionFromDriverManager(url, props);
    }

    protected Connection getConnectionFromDriverManager(String url, Properties props) throws SQLException {
        return DriverManager.getConnection(url, props);
    }
}
