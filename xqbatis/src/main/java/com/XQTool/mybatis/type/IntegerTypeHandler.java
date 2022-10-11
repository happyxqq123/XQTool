package com.XQTool.mybatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName IntegerTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:16
 * @Version 1.0
 **/
public class IntegerTypeHandler extends BaseTypeHandler<Integer> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter);
    }

    @Override
    public Integer getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        int result = rs.getInt(columnName);
        return result == 0 && rs.wasNull() ? null : result;
    }

    @Override
    public Integer getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        int result = rs.getInt(columnIndex);
        return result == 0 && rs.wasNull() ? null : result;
    }

    @Override
    public Integer getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        int result = cs.getInt(columnIndex);
        return result == 0 && cs.wasNull() ? null : result;
    }
}
