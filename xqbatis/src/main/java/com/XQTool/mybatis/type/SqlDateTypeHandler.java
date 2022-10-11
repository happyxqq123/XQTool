package com.XQTool.mybatis.type;

import java.sql.*;

/**
 * @ClassName SqlDateTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:21
 * @Version 1.0
 **/
public class SqlDateTypeHandler extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setDate(i, parameter);
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return rs.getDate(columnName);
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return rs.getDate(columnIndex);
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return cs.getDate(columnIndex);
    }
}
