package com.XQTool.mybatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.OffsetTime;

/**
 * @ClassName OffsetTimeTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:25
 * @Version 1.0
 **/
public class OffsetTimeTypeHandler extends BaseTypeHandler<OffsetTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OffsetTime parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setObject(i, parameter);
    }

    @Override
    public OffsetTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getObject(columnName, OffsetTime.class);
    }

    @Override
    public OffsetTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getObject(columnIndex, OffsetTime.class);
    }

    @Override
    public OffsetTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getObject(columnIndex, OffsetTime.class);
    }

}
