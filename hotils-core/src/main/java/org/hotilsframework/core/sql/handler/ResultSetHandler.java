package org.hotilsframework.core.sql.handler;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: ResultSetHandler
 * @Author: hireny
 * @Date: Create in 2020/01/04 14:37
 * @Description: TODO   结果集处理接口
 */
public interface ResultSetHandler<T> extends Serializable {

    /**
     * 处理结果集
     * 结果集处理后不需要关闭
     *
     * @param rs                结果集
     * @return                  处理后生成的对象
     * @throws SQLException     SQL异常
     */
    T handleResultSets(ResultSet rs) throws SQLException;
}
