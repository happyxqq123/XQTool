package com.XQTool.mybatis.reflection.property;

import com.XQTool.mybatis.reflection.Reflector;

import java.lang.reflect.Field;

/**
 * @ClassName PropertyCopier
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 17:35
 * @Version 1.0
 **/
public final class PropertyCopier {
    private PropertyCopier(){

    }

    public static void copyBeanProperties(Class<?> type,Object sourceBean,Object destinationBean){
        Class<?> parent = type;
        while(parent != null){
            final Field[] fields = parent.getDeclaredFields();
            for(Field field : fields){
                try{
                    try{
                        field.set(destinationBean,field.get(sourceBean));
                    }catch (IllegalArgumentException e){
                        if (Reflector.canControlMemberAccessible()) {
                            field.setAccessible(true);
                            field.set(destinationBean, field.get(sourceBean));
                        } else {
                            throw e;
                        }
                    }

                }catch (Exception e){

                }
            }
            parent = parent.getSuperclass();
        }

    }
}
