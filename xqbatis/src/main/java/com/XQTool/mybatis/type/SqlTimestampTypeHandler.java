package com.XQTool.mybatis.type;

import java.sql.*;

/**
 * @ClassName SqlTimestampTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:21
 * @Version 1.0
 **/
public class SqlTimestampTypeHandler extends BaseTypeHandler<Timestamp> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Timestamp parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setTimestamp(i, parameter);
    }

    @Override
    public Timestamp getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return rs.getTimestamp(columnName);
    }

    @Override
    public Timestamp getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return rs.getTimestamp(columnIndex);
    }

    @Override
    public Timestamp getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return cs.getTimestamp(columnIndex);
    }
}
