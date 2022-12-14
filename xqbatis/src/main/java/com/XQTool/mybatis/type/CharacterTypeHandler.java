package com.XQTool.mybatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName CharacterTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 16:10
 * @Version 1.0
 **/
public class CharacterTypeHandler extends BaseTypeHandler<Character> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Character parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    @Override
    public Character getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        if (columnValue != null && !columnValue.isEmpty()) {
            return columnValue.charAt(0);
        } else {
            return null;
        }
    }

    @Override
    public Character getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        if (columnValue != null && !columnValue.isEmpty()) {
            return columnValue.charAt(0);
        } else {
            return null;
        }
    }

    @Override
    public Character getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String columnValue = cs.getString(columnIndex);
        if (columnValue != null && !columnValue.isEmpty()) {
            return columnValue.charAt(0);
        } else {
            return null;
        }
    }
}

