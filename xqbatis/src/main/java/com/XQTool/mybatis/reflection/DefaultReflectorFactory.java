package com.XQTool.mybatis.reflection;


import com.XQTool.mybatis.util.MapUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ClassName DefaultReflectorFactory
 * @Description TODO
 * @Author admin
 * @Date 2022/10/14 14:48
 * @Version 1.0
 **/
public class DefaultReflectorFactory implements ReflectorFactory {

    private boolean classCacheEnabled = true;

    private final ConcurrentMap<Class<?>,Reflector> reflectorMap =new ConcurrentHashMap<>();


    @Override
    public boolean isClassCacheEnabled() {
        return classCacheEnabled;
    }

    @Override
    public void setClassCacheEnabled(boolean classCacheEnabled) {
        this.classCacheEnabled = classCacheEnabled;
    }

    @Override
    public Reflector findForClass(Class<?> type) {
        if(classCacheEnabled){
            return MapUtil.computeIfAbsent(reflectorMap,type,Reflector::new);
        }else{
            return new Reflector(type);
        }
    }
}
