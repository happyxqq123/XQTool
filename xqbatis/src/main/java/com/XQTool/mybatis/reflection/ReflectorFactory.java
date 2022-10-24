package com.XQTool.mybatis.reflection;

/**
 * @ClassName ReflectorFactory
 * @Description TODO
 * @Author admin
 * @Date 2022/10/14 14:47
 * @Version 1.0
 **/
public interface ReflectorFactory {

    boolean isClassCacheEnabled();

    void setClassCacheEnabled(boolean classCacheEnabled);

    Reflector findForClass(Class<?> type);

}
