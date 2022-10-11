package com.XQTool.mybatis.mapping;

import com.XQTool.mybatis.reflection.MetaObject;
import com.XQTool.mybatis.session.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BoundSql
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 13:30
 * @Version 1.0
 **/
public class BoundSql {

    private final String sql;
    private final List<ParameterMapping> parameterMappings;
    private final Object parameterObject;
    private final Map<String,Object> additionalParameters;
    private final MetaObject metaParameters;

    public BoundSql(Configuration configuration, String sql, List<ParameterMapping> parameterMappings, Object parameterObject) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
        this.parameterObject = parameterObject;
        this.additionalParameters = new HashMap<>();
        this.metaParameters = null;
    }

    public String getSql() {
        return sql;
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public Object getParameterObject() {
        return parameterObject;
    }

    public boolean hasAdditionalParameter(String name) {
        return false;
    }


}
