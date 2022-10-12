package com.XQTool.mybatis.reflection.invoker;

import com.XQTool.mybatis.reflection.Reflector;

import java.lang.reflect.Field;

/**
 * @ClassName GetFieldInvoker
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 17:53
 * @Version 1.0
 **/
public class GetFieldInvoker implements Invoker {
    private final Field field;

    public GetFieldInvoker(Field field) {
        this.field = field;
    }

    @Override
    public Object invoke(Object target, Object[] args) throws IllegalAccessException {
        try {
            return field.get(target);
        } catch (IllegalAccessException e) {
            if (Reflector.canControlMemberAccessible()) {
                field.setAccessible(true);
                return field.get(target);
            } else {
                throw e;
            }
        }
    }

    @Override
    public Class<?> getType() {
        return field.getType();
    }
}
