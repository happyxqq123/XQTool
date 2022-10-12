package com.XQTool.mybatis.binding;

import com.XQTool.mybatis.exception.BindingException;
import com.XQTool.mybatis.io.ResolverUtil;
import com.XQTool.mybatis.session.Configuration;
import com.XQTool.mybatis.session.SqlSession;

import java.util.*;

/**
 * @ClassName MapperRegistry
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:33
 * @Version 1.0
 **/
public class MapperRegistry {

    private final Configuration config;

    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers =new HashMap<>();

    public MapperRegistry(Configuration config){this.config = config;}

    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        final MapperProxyFactory<T> mapperProxyFactory =(MapperProxyFactory<T>) knownMappers.get(type);
        if(mapperProxyFactory == null){
            throw new BindingException("Type " + type + " is not known to the MapperRegistry.");
        }
        try{
            return mapperProxyFactory.newInstance(sqlSession);
        }catch (Exception e){
            throw new BindingException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> boolean hasMapper(Class<T> type){
        return knownMappers.containsKey(type);
    }

    public <T> void addMapper(Class<T> type){
        if(type.isInterface()){
            if(hasMapper(type)){
                throw new BindingException("Type " + type + " is already known to the MapperRegistry.");
            }
            boolean loadCompleted = false;
            try{
                knownMappers.put(type,new MapperProxyFactory<>(type));

            }finally {
                if(!loadCompleted){
                    knownMappers.remove(type);
                }
            }
        }
    }

    public Collection<Class<?>> getMappers() {
        return Collections.unmodifiableCollection(knownMappers.keySet());
    }

    public void addMappers(String packageName, Class<?> superType) {
        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<>();
        resolverUtil.find(new ResolverUtil.IsA(superType), packageName);
        Set<Class<? extends Class<?>>> mapperSet = resolverUtil.getClasses();
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }

    public void addMappers(String packageName) {
        addMappers(packageName, Object.class);
    }
}
