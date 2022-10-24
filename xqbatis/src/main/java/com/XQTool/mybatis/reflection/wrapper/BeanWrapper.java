package com.XQTool.mybatis.reflection.wrapper;

import com.XQTool.mybatis.exception.ReflectionException;
import com.XQTool.mybatis.reflection.MetaClass;
import com.XQTool.mybatis.reflection.MetaObject;
import com.XQTool.mybatis.reflection.factory.ObjectFactory;
import com.XQTool.mybatis.reflection.invoker.Invoker;
import com.XQTool.mybatis.reflection.property.PropertyTokenizer;

import java.util.List;

/**
 * @ClassName BeanWrapper
 * @Description TODO
 * @Author admin
 * @Date 2022/10/19 10:18
 * @Version 1.0
 **/
public class BeanWrapper extends BaseWrapper{

    private final Object object;

    private final MetaClass metaClass;

    public BeanWrapper(MetaObject metaObject,Object object){
        super(metaObject);
        this.object = object;
        this.metaClass = MetaClass.forClass(object.getClass(),metaObject.getReflectorFactory());
    }


    @Override
    public Object get(PropertyTokenizer prop) {
        if(prop.getIndex() != null){
            Object collection = resolveCollection(prop,object);
            return getCollectionValue(prop,collection);
        }else{
            return null;
        }
    }

    @Override
    public void set(PropertyTokenizer prop, Object value) {

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

    private Object getBeanProperty(PropertyTokenizer prop, Object object){
        try{

        }catch (RuntimeException e){
            throw e;
        }catch (Throwable t){
            throw new ReflectionException("Could not get property '" + prop.getName() + "' from " + object.getClass() + ".  Cause: " + t.toString(), t);
        }
        return null;
    }
}
