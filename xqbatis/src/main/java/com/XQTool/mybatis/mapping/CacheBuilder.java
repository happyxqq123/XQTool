package com.XQTool.mybatis.mapping;

import com.XQTool.mybatis.cache.Cache;
import com.XQTool.mybatis.exception.CacheException;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName CacheBuilder
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 15:31
 * @Version 1.0
 **/
public class CacheBuilder {
    private final String id;
    private Class<? extends Cache> implementation;
    private final List<Class<? extends Cache>> decorators;
    private Integer size;
    private Long clearInterval;
    private boolean readWrite;
    private Properties properties;
    private boolean blocking;

    public CacheBuilder(String id) {
        this.id = id;
        this.decorators = new ArrayList<>();
    }

    public CacheBuilder implementation(Class<? extends Cache> implementation) {
        this.implementation = implementation;
        return this;
    }

    public CacheBuilder addDecorator(Class<? extends Cache> decorator) {
        if (decorator != null) {
            this.decorators.add(decorator);
        }
        return this;
    }

    public CacheBuilder size(Integer size) {
        this.size = size;
        return this;
    }

    public CacheBuilder clearInterval(Long clearInterval) {
        this.clearInterval = clearInterval;
        return this;
    }

    public CacheBuilder readWrite(boolean readWrite) {
        this.readWrite = readWrite;
        return this;
    }

    public CacheBuilder blocking(boolean blocking) {
        this.blocking = blocking;
        return this;
    }

    public CacheBuilder properties(Properties properties) {
        this.properties = properties;
        return this;
    }


}
