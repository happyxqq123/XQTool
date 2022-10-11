package com.XQTool.mybatis.type;

import com.XQTool.mybatis.type.BaseTypeHandler;
import com.XQTool.mybatis.type.JdbcType;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName BigDecimalTypeHandler
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 16:02
 * @Version 1.0
 **/
public class BigDecimalTypeHandler extends BaseTypeHandler<BigDecimal> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BigDecimal parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setBigDecimal(i, parameter);
    }

    @Override
    public BigDecimal getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return rs.getBigDecimal(columnName);
    }

    @Override
    public BigDecimal getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        return rs.getBigDecimal(columnIndex);
    }

    @Override
    public BigDecimal getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        return cs.getBigDecimal(columnIndex);
    }
}
