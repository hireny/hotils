package org.hotilsframework.core.sql.datasource;

import java.util.Properties;

/**
 * @ClassName: DriverManagerProperties
 * @Author: hireny
 * @Date: Create in 2019/12/11 13:40
 * @Description: TODO   数据库驱动配置
 */
public class DriverManagerProperties {

    /**
     * 链接地址
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 数据库密码
     */
    private String password;
    /**
     * 连接配置
     */
    private Properties connectionProperties;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Properties getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(Properties connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        DriverManagerProperties that = (DriverManagerProperties) object;

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return connectionProperties != null ? connectionProperties.equals(that.connectionProperties) : that.connectionProperties == null;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (connectionProperties != null ? connectionProperties.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DriverManagerProperties{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", connectionProperties=" + connectionProperties +
                '}';
    }
}
