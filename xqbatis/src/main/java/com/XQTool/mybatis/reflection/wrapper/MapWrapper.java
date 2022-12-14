package com.XQTool.mybatis.reflection.wrapper;

import com.XQTool.mybatis.reflection.MetaObject;
import com.XQTool.mybatis.reflection.factory.ObjectFactory;
import com.XQTool.mybatis.reflection.property.PropertyTokenizer;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MapWrapper
 * @Description TODO
 * @Author admin
 * @Date 2022/10/13 16:53
 * @Version 1.0
 **/
public class MapWrapper extends BaseWrapper{

    private final Map<String,Object> map;

    public MapWrapper(MetaObject metaObject,Map<String,Object> map){
        super(metaObject);
        this.map = map;
    }


    @Override
    public Object get(PropertyTokenizer prop) {
        if(prop.getIndex() != null){
            Object collection = resolveCollection(prop,map);
            return getCollectionValue(prop,collection);
        }else{
            return map.get(prop.getName());
        }
    }

    @Override
    public void set(PropertyTokenizer prop, Object value) {
        if(prop.getIndex() != null){
            Object collection = resolveCollection(prop,map);
        }
    }

    @Override
    public String findProperty(String name, boolean useCamelCaseMapping) {
        return null;
    }

    @Override
    public String[] getGetterNames() {
        return new String[0];
    }

    @Override
    public String[] getSetterNames() {
        return new String[0];
    }

    @Override
    public Class<?> getSetterType(String name) {
        return null;
    }

    @Override
    public Class<?> getGetterType(String name) {
        return null;
    }

    @Override
    public boolean hasSetter(String name) {
        return false;
    }

    @Override
    public boolean hasGetter(String name) {
        return false;
    }

    @Override
    public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
        return null;
    }

    @Override
    public boolean isCollection() {
        return false;
    }

    @Override
    public void add(Object element) {

    }

    @Override
    public <E> void addAll(List<E> element) {

    }
}
