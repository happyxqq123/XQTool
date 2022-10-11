package com.XQTool.mybatis.type;

import java.sql.*;

/**
 * @ClassName SqlxmlTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:22
 * @Version 1.0
 **/
public class SqlxmlTypeHandler extends BaseTypeHandler<String> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
            throws SQLException {
        SQLXML sqlxml = ps.getConnection().createSQLXML();
        try {
            sqlxml.setString(parameter);
            ps.setSQLXML(i, sqlxml);
        } finally {
            sqlxml.free();
        }
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return sqlxmlToString(rs.getSQLXML(columnName));
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return sqlxmlToString(rs.getSQLXML(columnIndex));
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return sqlxmlToString(cs.getSQLXML(columnIndex));
    }

    protected String sqlxmlToString(SQLXML sqlxml) throws SQLException {
        if (sqlxml == null) {
            return null;
        }
        try {
            return sqlxml.getString();
        } finally {
            sqlxml.free();
        }
    }

}