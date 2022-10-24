package com.XQTool.mybatis.reflection.wrapper;

import com.XQTool.mybatis.reflection.MetaObject;

public interface ObjectWrapperFactory {

    boolean hasWrapperFor(Object object);

    ObjectWrapper getWrapperFor(MetaObject metaObject,Object object);
}
