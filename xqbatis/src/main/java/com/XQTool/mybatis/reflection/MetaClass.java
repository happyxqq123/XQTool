package com.XQTool.mybatis.reflection;

import com.XQTool.mybatis.reflection.invoker.GetFieldInvoker;
import com.XQTool.mybatis.reflection.invoker.Invoker;
import com.XQTool.mybatis.reflection.invoker.MethodInvoker;
import com.XQTool.mybatis.reflection.property.PropertyTokenizer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @ClassName MetaClass
 * @Description TODO
 * @Author admin
 * @Date 2022/10/14 14:46
 * @Version 1.0
 **/
public class MetaClass {

    private final ReflectorFactory reflectorFactory;

    private final Reflector reflector;

    private MetaClass(Class<?> type,ReflectorFactory reflectorFactory){
        this.reflectorFactory = reflectorFactory;
        this.reflector = reflectorFactory.findForClass(type);
    }

    public static MetaClass forClass(Class<?> type,ReflectorFactory reflectorFactory){
        return new MetaClass(type,reflectorFactory);
    }

    public MetaClass metaClassForProperty(String name){
        Class<?> propType =reflector.getGetterType(name);
        return MetaClass.forClass(propType,reflectorFactory);
    }

    public String findProperty(String name){
        StringBuilder prop = buildProperty(name,new StringBuilder());
        return prop.length()>0?prop.toString():null;
    }

    public String findProperty(String name,boolean userCamelCaseMapping){
        if(userCamelCaseMapping){
            name = name.replace("_","");
        }
        return findProperty(name);
    }

    public String[] getGetterNames() {
        return reflector.getGetablePropertyNames();
    }

    public String[] getSetterNames() {
        return reflector.getSetablePropertyNames();
    }

    public Class<?> getSetterType(String name){
        PropertyTokenizer prop = new PropertyTokenizer(name);
        if(prop.hasNext()){
            MetaClass metaProp = metaClassForProperty(prop.getName());
            return metaProp.getSetterType(prop.getChildren());
        } else {
            return reflector.getSetterType(prop.getName());
        }
    }

    private MetaClass metaClassForProperty(PropertyTokenizer prop){
        return null;
    }

    public StringBuilder buildProperty(String name,StringBuilder builder){
        PropertyTokenizer prop = new PropertyTokenizer(name);
        if(prop.hasNext()){
            String propertyName = reflector.findPropertyName(prop.getName());
            if(propertyName != null){
                builder.append(propertyName);
                builder.append(".");
                MetaClass metaProp = metaClassForProperty(propertyName);
                metaProp.buildProperty(prop.getChildren(),builder);
            }
        }else{
            String propertyName = reflector.findPropertyName(name);
            if(propertyName != null){
                builder.append(propertyName);
            }
        }
        return builder;
    }

    private Class<?> getGetterType(PropertyTokenizer prop){
        Class<?> type = reflector.getGetterType(prop.getName());
        if(prop.getIndex() != null && Collection.class.isAssignableFrom(type)){
        }
        return null;
    }

    private Type getGenericGetterType(String propertyName){
        try{
            Invoker invoker = reflector.getGetInvoker(propertyName);
            if(invoker instanceof MethodInvoker){
                Field declaredMethod =MethodInvoker.class.getDeclaredField("method");
                declaredMethod.setAccessible(true);
                Method method = (Method) declaredMethod.get(invoker);
                return TypeParameterResolver.resolveReturnType(method,reflector.getType());
            }else if(invoker instanceof GetFieldInvoker){
                Field declaredField = GetFieldInvoker.class.getDeclaredField("field");
                declaredField.setAccessible(true);
                Field field = (Field) declaredField.get(invoker);
                return TypeParameterResolver.resolveFieldType(field,reflector.getType());
            }

        }catch(NoSuchFieldException | IllegalAccessException e){
            //Ignored
        }
        return null;
    }



}
