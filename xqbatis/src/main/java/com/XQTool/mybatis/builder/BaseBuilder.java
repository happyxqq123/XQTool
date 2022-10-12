package com.XQTool.mybatis.builder;

import com.XQTool.mybatis.exception.BuilderException;
import com.XQTool.mybatis.mapping.ParameterMode;
import com.XQTool.mybatis.mapping.ResultSetType;
import com.XQTool.mybatis.session.Configuration;
import com.XQTool.mybatis.type.JdbcType;
import com.XQTool.mybatis.type.TypeAliasRegistry;
import com.XQTool.mybatis.type.TypeHandler;
import com.XQTool.mybatis.type.TypeHandlerRegistry;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @ClassName BaseBuilder
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 10:58
 * @Version 1.0
 **/
public abstract class BaseBuilder {

    @Getter
    protected final Configuration configuration;

    protected final TypeAliasRegistry typeAliasRegistry;
    protected final TypeHandlerRegistry typeHandlerRegistry;

    public BaseBuilder(Configuration configuration){
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
        this.typeHandlerRegistry = this.configuration.getTypeHandlerRegistry();
    }

    protected Pattern parseExpression(String regex, String defaultValue) {
        return Pattern.compile(regex == null ? defaultValue : regex);
    }

    protected Boolean booleanValueOf(String value, Boolean defaultValue) {
        return value == null ? defaultValue : Boolean.valueOf(value);
    }

    protected Integer integerValueOf(String value, Integer defaultValue) {
        return value == null ? defaultValue : Integer.valueOf(value);
    }

    protected Set<String> stringSetValueOf(String value, String defaultValue) {
        value = value == null ? defaultValue : value;
        return new HashSet<>(Arrays.asList(value.split(",")));
    }

    protected JdbcType resolveJdbcType(String alias){
        if(alias == null){
            return null;
        }
        try{
            return JdbcType.valueOf(alias);
        }catch (IllegalArgumentException e){
            throw new BuilderException("Error resolving JdbcType. Cause: " + e, e);
        }
    }

    protected ResultSetType resolveResultSetType(String alias){
        if(alias == null){
            return null;
        }
        try{
            return ResultSetType.valueOf(alias);
        }catch (IllegalArgumentException e){
            throw new BuilderException("Error resolving ResultSetType. Cause: " + e, e);
        }
    }

    protected ParameterMode resolveParameterMode(String alias) {
        if (alias == null) {
            return null;
        }
        try {
            return ParameterMode.valueOf(alias);
        } catch (IllegalArgumentException e) {
            throw new BuilderException("Error resolving ParameterMode. Cause: " + e, e);
        }
    }

    protected Object createInstance(String alias){
        Class<?> clazz = resolveClass(alias);
        if (clazz == null) {
            return null;
        }
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new BuilderException("Error creating instance. Cause: " + e, e);
        }
    }

    protected <T> Class<? extends T> resolveClass(String alias){
        if(alias == null){
            return null;
        }
        try{
            return resolveAlias(alias);
        }catch (Exception e){
            throw new BuilderException("Error resolving class. Cause: " + e, e);
        }
    }

    protected TypeHandler<?> resolveTypeHandler(Class<?> javaType, String typeHandlerAlias) {
        if (typeHandlerAlias == null) {
            return null;
        }
        Class<?> type = resolveClass(typeHandlerAlias);
        if (type != null && !TypeHandler.class.isAssignableFrom(type)) {
            throw new BuilderException("Type " + type.getName() + " is not a valid TypeHandler because it does not implement TypeHandler interface");
        }
        Class<? extends TypeHandler<?>> typeHandlerType = (Class<? extends TypeHandler<?>>) type;
        return resolveTypeHandler(javaType, typeHandlerType);
    }

    protected TypeHandler<?> resolveTypeHandler(Class<?> javaType, Class<? extends TypeHandler<?>> typeHandlerType) {
        if (typeHandlerType == null) {
            return null;
        }
        // javaType ignored for injected handlers see issue #746 for full detail
        TypeHandler<?> handler = typeHandlerRegistry.getMappingTypeHandler(typeHandlerType);
        if (handler == null) {
            // not in registry, create a new one
            handler = typeHandlerRegistry.getInstance(javaType, typeHandlerType);
        }
        return handler;
    }

    protected <T> Class<? extends T> resolveAlias(String alias) {
        return typeAliasRegistry.resolveAlias(alias);
    }


}
