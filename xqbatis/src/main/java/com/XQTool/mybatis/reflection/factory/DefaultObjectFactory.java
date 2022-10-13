package com.XQTool.mybatis.reflection.factory;

import com.XQTool.mybatis.exception.ReflectionException;
import com.XQTool.mybatis.reflection.Reflector;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName DefaultObjectFactory
 * @Description TODO
 * @Author admin
 * @Date 2022/10/13 11:16
 * @Version 1.0
 **/
public class DefaultObjectFactory implements ObjectFactory, Serializable {

    @Override
    public <T> T create(Class<T> type) {
        return create(type,null,null);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        try{
            Constructor<T>constructor;
            if(constructorArgs == null || constructorArgTypes == null){
                constructor = type.getDeclaredConstructor();
                try{
                    return constructor.newInstance();
                }catch (IllegalAccessException e){
                    if(Reflector.canControlMemberAccessible()){
                        constructor.setAccessible(true);
                        return constructor.newInstance();
                    }else{
                        throw e;
                    }
                }
            }

            constructor = type.getDeclaredConstructor(constructorArgTypes.toArray(new Class[0]));
            try{
                return constructor.newInstance(constructorArgs.toArray());
            }catch (IllegalAccessException e){
                if(Reflector.canControlMemberAccessible()){
                    constructor.setAccessible(true);
                    return constructor.newInstance(constructorArgs.toArray());
                }else{
                    throw e;
                }
            }

        }catch (Exception e){
            String argTypes = Optional.ofNullable(constructorArgTypes).orElseGet(Collections::emptyList)
                    .stream().map(Class::getSimpleName).collect(Collectors.joining(","));
            String argValues = Optional.ofNullable(constructorArgs).orElseGet(Collections::emptyList)
                    .stream().map(String::valueOf).collect(Collectors.joining(","));

            throw new ReflectionException("Error instantating "+ type+" with invalid types("+argTypes+") or values ("+argValues+"). Cause"+e,e);
        }
    }

    protected Class<?> resolveInterface(Class<?> type) {
        Class<?> classToCreate;
        if(type == List.class || type == Collection.class || type == Iterable.class){
            return ArrayList.class;
        }else if(type == Map.class){
            return HashMap.class;
        }else if(type == SortedSet.class){
            classToCreate = TreeSet.class;
        }else if(type == Set.class){
            classToCreate = HashSet.class;
        }else{
            classToCreate = type;
        }
        return classToCreate;
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }
}
