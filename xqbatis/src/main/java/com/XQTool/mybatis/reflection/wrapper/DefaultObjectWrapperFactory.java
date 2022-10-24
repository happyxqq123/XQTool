package com.XQTool.mybatis.reflection.wrapper;

import com.XQTool.mybatis.exception.ReflectionException;
import com.XQTool.mybatis.reflection.MetaObject;

/**
 * @ClassName DefaultObjectWrapperFactory
 * @Description TODO
 * @Author admin
 * @Date 2022/10/14 10:55
 * @Version 1.0
 **/
public class DefaultObjectWrapperFactory implements ObjectWrapperFactory{
    @Override
    public boolean hasWrapperFor(Object object) {
        return false;
    }

    @Override
    public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
        throw new ReflectionException("The DefaultObjectWrapperFactory should never be called to provide an ObjectWrapper.");
    }
}
