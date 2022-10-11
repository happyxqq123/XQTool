package com.XQTool.mybatis.type;


import com.XQTool.mybatis.exception.TypeException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName TypeReference
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 14:17
 * @Version 1.0
 **/
public abstract class TypeReference<T> {

    private final Type rawType;

    protected TypeReference(){
        rawType = getSuperclassTypeParameter(getClass());
    }

    Type getSuperclassTypeParameter(Class<?> clazz){
        Type genericSuperclass = clazz.getGenericSuperclass();
        if(genericSuperclass instanceof Class){
            if(TypeReference.class != genericSuperclass){
                return getSuperclassTypeParameter(clazz.getSuperclass());
            }
            throw new TypeException("'" + getClass() + "' extends TypeReference but misses the type parameter. "
                    + "Remove the extension or add a type parameter to it.");
        }
        Type rawType =((ParameterizedType)genericSuperclass).getActualTypeArguments()[0];

        if(rawType instanceof  ParameterizedType){
            rawType = ((ParameterizedType) rawType).getRawType();
        }

        return rawType;
    }

    public final Type getRawType() {
        return rawType;
    }

    @Override
    public String toString() {
        return rawType.toString();
    }
}
