package com.XQTool.mybatis.reflection.invoker;

import com.XQTool.mybatis.reflection.Reflector;

import java.lang.reflect.Field;

/**
 * @ClassName SetFieldInvoker
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 17:54
 * @Version 1.0
 **/
public class SetFieldInvoker implements Invoker {
    private final Field field;

    public SetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws IllegalAccessException {
        try {
            field.set(target, args[0]);
        } catch (IllegalAccessException e) {
            if (Reflector.canControlMemberAccessible()) {
                field.setAccessible(true);
                field.set(target, args[0]);
            } else {
                throw e;
            }
        }
        return null;
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
