package com.XQTool.mybatis.reflection.invoker;

import com.XQTool.mybatis.exception.ReflectionException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName AmbiguousMethodInvoker
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 17:51
 * @Version 1.0
 **/
public class AmbiguousMethodInvoker extends MethodInvoker {
    private final String exceptionMessage;

    public AmbiguousMethodInvoker(Method method, String exceptionMessage) {
        super(method);
        this.exceptionMessage = exceptionMessage;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException {
        throw new ReflectionException(exceptionMessage);
    }
}
