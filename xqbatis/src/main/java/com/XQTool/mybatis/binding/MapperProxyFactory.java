package com.XQTool.mybatis.binding;


import com.XQTool.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName MapperProxyFactory
 * @Description TODO
 * @Author xqq
 * @Date 2022/10/11 10:18
 * @Version 1.0
 **/
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    private final Map<Method, MapperProxy.MapperMethodInvoker> methodCache = new ConcurrentHashMap<>();

    public MapperProxyFactory(Class<T> mapperInterface){
        this.mapperInterface = mapperInterface;
    }
    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public Map<Method, MapperProxy.MapperMethodInvoker> getMethodCache() {
        return methodCache;
    }

    protected T newInstance(MapperProxy<T> mapperProxy){
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }

    public T newInstance(SqlSession sqlSession){
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession,mapperInterface,methodCache);
        return newInstance(mapperProxy);
    }

}
