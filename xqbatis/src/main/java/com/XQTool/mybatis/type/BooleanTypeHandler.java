package com.XQTool.mybatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName BooleanTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 16:08
 * @Version 1.0
 **/
public class BooleanTypeHandler extends BaseTypeHandler<Boolean> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setBoolean(i, parameter);
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        boolean result = rs.getBoolean(columnName);
        return !result && rs.wasNull() ? null : result;
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        boolean result = rs.getBoolean(columnIndex);
        return !result && rs.wasNull() ? null : result;
    }

    @Override
    public Boolean getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        boolean result = cs.getBoolean(columnIndex);
        return !result && cs.wasNull() ? null : result;
    }
}
