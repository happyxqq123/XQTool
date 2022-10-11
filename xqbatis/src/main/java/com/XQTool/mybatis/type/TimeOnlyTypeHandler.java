package com.XQTool.mybatis.type;

import java.sql.*;
import java.util.Date;

/**
 * @ClassName TimeOnlyTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:20
 * @Version 1.0
 **/
public class TimeOnlyTypeHandler extends BaseTypeHandler<Date> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setTime(i, new Time(parameter.getTime()));
    }

    @Override
    public Date getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        Time sqlTime = rs.getTime(columnName);
        if (sqlTime != null) {
            return new Date(sqlTime.getTime());
        }
        return null;
    }

    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        Time sqlTime = rs.getTime(columnIndex);
        if (sqlTime != null) {
            return new Date(sqlTime.getTime());
        }
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        Time sqlTime = cs.getTime(columnIndex);
        if (sqlTime != null) {
            return new Date(sqlTime.getTime());
        }
        return null;
    }
}
