package com.XQTool.mybatis.mapping;

import com.XQTool.mybatis.session.Configuration;
import com.XQTool.mybatis.type.JdbcType;
import com.XQTool.mybatis.type.TypeHandler;

/**
 * @ClassName ParameterMapping
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 13:30
 * @Version 1.0
 **/
public class ParameterMapping {
    private Configuration configuration;
    private String property;
    private ParameterMode mode;
    private Class<?> javaType = Object.class;
    private JdbcType jdbcType;
    private Integer numericScale;
    private TypeHandler<?> typeHandler;
    private String resultMapId;
    private String jdbcTypeName;
    private String expression;

    private ParameterMapping(){
    }

    public static class Builder{
        private ParameterMapping parameterMapping = new ParameterMapping();
        public Builder(Configuration configuration,String property, TypeHandler<?> typeHandler){
            parameterMapping.configuration = configuration;
            parameterMapping.property = property;
            parameterMapping.typeHandler = typeHandler;
            parameterMapping.mode = ParameterMode.IN;
        }

        public Builder(Configuration configuration,String property,Class<?> javaType){
            parameterMapping.configuration = configuration;
            parameterMapping.property = property;
            parameterMapping.javaType = javaType;
            parameterMapping.mode = ParameterMode.IN;
        }

        public Builder mode(ParameterMode mode) {
            parameterMapping.mode = mode;
            return this;
        }

        public Builder javaType(Class<?> javaType) {
            parameterMapping.javaType = javaType;
            return this;
        }

        public Builder jdbcType(JdbcType jdbcType) {
            parameterMapping.jdbcType = jdbcType;
            return this;
        }

        public Builder numericScale(Integer numericScale) {
            parameterMapping.numericScale = numericScale;
            return this;
        }

        public Builder resultMapId(String resultMapId) {
            parameterMapping.resultMapId = resultMapId;
            return this;
        }

        public Builder typeHandler(TypeHandler<?> typeHandler) {
            parameterMapping.typeHandler = typeHandler;
            return this;
        }

        public Builder jdbcTypeName(String jdbcTypeName) {
            parameterMapping.jdbcTypeName = jdbcTypeName;
            return this;
        }

        public Builder expression(String expression) {
            parameterMapping.expression = expression;
            return this;
        }

        public ParameterMapping build() {
            resolveTypeHandler();
            //validate();
            return parameterMapping;
        }

        private void resolveTypeHandler(){
            if(parameterMapping.typeHandler == null && parameterMapping.javaType != null){
                Configuration configuration = parameterMapping.configuration;
            }
        }


    }

}
