package com.XQTool.mybatis.reflection;

import com.XQTool.mybatis.reflection.factory.DefaultObjectFactory;
import com.XQTool.mybatis.reflection.factory.ObjectFactory;
import com.XQTool.mybatis.reflection.wrapper.DefaultObjectWrapperFactory;
import com.XQTool.mybatis.reflection.wrapper.ObjectWrapperFactory;

/**
 * @ClassName SystemMetaObject
 * @Description TODO
 * @Author admin
 * @Date 2022/10/19 10:43
 * @Version 1.0
 **/
public final class SystemMetaObject {

    public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

    public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    public static final MetaObject NULL_META_OBJECT = MetaObject.forObject(new NullObject(),DEFAULT_OBJECT_FACTORY,DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());

    private SystemMetaObject(){

    }

    private static class NullObject{

    }

    public static MetaObject forObject(Object object){
        return MetaObject.forObject(object,DEFAULT_OBJECT_FACTORY,DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());
    }

}
