package com.XQTool.mybatis.reflection.invoker;

import com.XQTool.mybatis.reflection.Reflector;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName MethodInvoker
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 17:45
 * @Version 1.0
 **/
public class MethodInvoker implements Invoker{

    @Getter
    private final Class<?> type;

    private final Method method;

    public MethodInvoker(Method method){
        this.method = method;
        if(method.getParameterTypes().length == 1){
            type = method.getParameterTypes()[0];
        }else{
            type = method.getReturnType();
        }
    }

    @Override
    public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
        try{
            return method.invoke(target,args);
        }catch(IllegalAccessException e){
            if(Reflector.canControlMemberAccessible()){
                method.setAccessible(true);
                return method.invoke(target,args);
            }else{
                throw e;
            }
        }
    }


}
