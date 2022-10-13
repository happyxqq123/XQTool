package com.XQTool.mybatis.builder.annotation;

import com.XQTool.mybatis.annotations.*;
import com.XQTool.mybatis.builder.BaseBuilder;
import com.XQTool.mybatis.cache.Cache;
import com.XQTool.mybatis.exception.BuilderException;
import com.XQTool.mybatis.exception.IncompleteElementException;
import com.XQTool.mybatis.executor.ErrorContext;
import com.XQTool.mybatis.session.Configuration;

import java.lang.annotation.Annotation;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName MapperAnnotationBuilder
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 10:30
 * @Version 1.0
 **/
public class MapperAnnotationBuilder extends BaseBuilder {

    private String currentNamespace;

    private final String resource;

    private Cache currentCache;

    private boolean unresolvedCacheRef;


    private static final Set<Class<? extends Annotation>> statementAnnotationTypes = Stream.of(
            Select.class, Update.class, Insert.class, Delete.class, UpdateProvider.class,
            InsertProvider.class,DeleteProvider.class).collect(Collectors.toSet());


    public MapperAnnotationBuilder(Configuration configuration, String resource) {
        super(configuration);
        ErrorContext.instance().resource(resource);
        this.resource = resource;
    }
    public String getCurrentNamespace() {
        return currentNamespace;
    }

    public void setCurrentNamespace(String currentNamespace) {
        if (currentNamespace == null) {
            throw new BuilderException("The mapper element requires a namespace attribute to be specified.");
        }

        if (this.currentNamespace != null && !this.currentNamespace.equals(currentNamespace)) {
            throw new BuilderException("Wrong namespace. Expected '"
                    + this.currentNamespace + "' but found '" + currentNamespace + "'.");
        }

        this.currentNamespace = currentNamespace;
    }

    public String applyCurrentNamespace(String base, boolean isReference){
        if(base == null){
            return null;
        }
        if(isReference){
            if(base.contains(".")){
                return base;
            }
        }else{
            if (base.startsWith(currentNamespace + ".")) {
                return base;
            }
            if (base.contains(".")) {
                throw new BuilderException("Dots are not allowed in element names, please remove it from " + base);
            }
        }
        return currentNamespace + "." + base;
    }

    public Cache useCacheRef(String namespace){
        if(namespace == null){
            throw new BuilderException("cache-ref element requires a namespace attribute.");
        }
        try{
            unresolvedCacheRef = true;
            Cache cache = configuration.getCache(namespace);
            if(cache == null){
                throw new IncompleteElementException("No cache for namespace '" + namespace + "' could be found.");
            }
            currentCache = cache;
            unresolvedCacheRef = false;
            return cache;
        }catch (IllegalArgumentException e){
            throw new IncompleteElementException("No cache for namespace '" + namespace + "' could be found.", e);
        }
    }

    public Cache useNewCache(Class<? extends Cache> typeClass,
                             Class<? extends  Cache> evictionClass,
                             Long flushInterval,
                             Integer size,
                             boolean readWrite,
                             boolean blocking,
                             Properties props){
        return null;

    }

}
