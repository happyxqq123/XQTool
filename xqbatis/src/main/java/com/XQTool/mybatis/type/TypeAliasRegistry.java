package com.XQTool.mybatis.type;


import com.XQTool.mybatis.exception.TypeException;
import com.XQTool.mybatis.io.ResolverUtil;
import com.XQTool.mybatis.io.Resources;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.*;

/**
 * @ClassName TypeAliasRegistry
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 10:59
 * @Version 1.0
 **/
public class TypeAliasRegistry {

    private final Map<String,Class<?>> typeAliases = new HashMap<>();

    public TypeAliasRegistry(){

        registerAlias("string", String.class);

        registerAlias("byte", Byte.class);
        registerAlias("long", Long.class);
        registerAlias("short", Short.class);
        registerAlias("int", Integer.class);
        registerAlias("integer", Integer.class);
        registerAlias("double", Double.class);
        registerAlias("float", Float.class);
        registerAlias("boolean", Boolean.class);

        registerAlias("byte[]", Byte[].class);
        registerAlias("long[]", Long[].class);
        registerAlias("short[]", Short[].class);
        registerAlias("int[]", Integer[].class);
        registerAlias("integer[]", Integer[].class);
        registerAlias("double[]", Double[].class);
        registerAlias("float[]", Float[].class);
        registerAlias("boolean[]", Boolean[].class);

        registerAlias("_byte", byte.class);
        registerAlias("_long", long.class);
        registerAlias("_short", short.class);
        registerAlias("_int", int.class);
        registerAlias("_integer", int.class);
        registerAlias("_double", double.class);
        registerAlias("_float", float.class);
        registerAlias("_boolean", boolean.class);

        registerAlias("_byte[]", byte[].class);
        registerAlias("_long[]", long[].class);
        registerAlias("_short[]", short[].class);
        registerAlias("_int[]", int[].class);
        registerAlias("_integer[]", int[].class);
        registerAlias("_double[]", double[].class);
        registerAlias("_float[]", float[].class);
        registerAlias("_boolean[]", boolean[].class);

        registerAlias("date", Date.class);
        registerAlias("decimal", BigDecimal.class);
        registerAlias("bigdecimal", BigDecimal.class);
        registerAlias("biginteger", BigInteger.class);
        registerAlias("object", Object.class);

        registerAlias("date[]", Date[].class);
        registerAlias("decimal[]", BigDecimal[].class);
        registerAlias("bigdecimal[]", BigDecimal[].class);
        registerAlias("biginteger[]", BigInteger[].class);
        registerAlias("object[]", Object[].class);

        registerAlias("map", Map.class);
        registerAlias("hashmap", HashMap.class);
        registerAlias("list", List.class);
        registerAlias("arraylist", ArrayList.class);
        registerAlias("collection", Collection.class);
        registerAlias("iterator", Iterator.class);

        registerAlias("ResultSet", ResultSet.class);

    }

    public <T> Class<T> resolveAlias(String string){
        try{
            if(string == null){
                return null;
            }
            String key = string.toLowerCase(Locale.ENGLISH);
            Class<T> value;
            if(typeAliases.containsKey(key)){
                value = (Class<T>) typeAliases.get(key);
            }else{
                value = (Class<T>) Resources.classForName(string);
            }
            return value;

        }catch (ClassNotFoundException e){
            throw new TypeException("Could not resolve type alias '"+string+"'. Cause: "+e,e);
        }
    }

    public void registerAliases(String packageName) {
        registerAliases(packageName, Object.class);
    }

    public void registerAliases(String packageName,Class<?> superType){
        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<>();
        resolverUtil.find(new ResolverUtil.IsA(superType),packageName);
        Set<Class<? extends Class<?>>> typeSet = resolverUtil.getClasses();
        for(Class<?> type : typeSet){
            if(!type.isAnonymousClass() && !type.isInterface() && !type.isMemberClass()){
                registerAlias(type);
            }
        }
    }

    public void registerAlias(Class<?> type){
        String alias = type.getSimpleName();
        Alias aliasAnnotation = type.getAnnotation(Alias.class);
        if(aliasAnnotation != null){
            alias = aliasAnnotation.value();
        }
        registerAlias(alias,type);
    }

    public void registerAlias(String alias,Class<?> value){
        if(alias == null){
            throw new TypeException("The parameter alias cannot be null");
        }
        String key = alias.toLowerCase(Locale.ENGLISH);
        if(typeAliases.containsKey(key) && typeAliases.get(key) != null && !typeAliases.get(key).equals(value)){
            throw new TypeException("The alias '" + alias + "' is already mapped to the value '" + typeAliases.get(key).getName() + "'.");
        }
        typeAliases.put(key,value);
    }


    public void registerAlias(String alias,String value){
        try{
            registerAlias(alias,Resources.classForName(value));
        }catch (ClassNotFoundException e){
            throw new TypeException("Error registering type alias " + alias + " for " + value + ". Cause: " + e, e);
        }
    }

    public Map<String,Class<?>> getTypeAliases(){
        return Collections.unmodifiableMap(typeAliases);
    }
}
