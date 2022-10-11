package com.XQTool.mybatis.type;

import java.io.StringReader;
import java.sql.*;

/**
 * @ClassName ClobTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 16:10
 * @Version 1.0
 **/
public class ClobTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        StringReader reader = new StringReader(parameter);
        ps.setCharacterStream(i, reader, parameter.length());
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Clob clob = rs.getClob(columnName);
        return toString(clob);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        Clob clob = rs.getClob(columnIndex);
        return toString(clob);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Clob clob = cs.getClob(columnIndex);
        return toString(clob);
    }

    private String toString(Clob clob) throws SQLException {
        return clob == null ? null : clob.getSubString(1, (int) clob.length());
    }

}
