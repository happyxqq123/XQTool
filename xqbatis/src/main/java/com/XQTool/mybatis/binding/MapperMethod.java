package com.XQTool.mybatis.binding;

import com.XQTool.mybatis.exception.BindingException;

import java.util.HashMap;

/**
 * @ClassName MapperMethod
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:27
 * @Version 1.0
 **/
public class MapperMethod {

    public static class ParamMap<V> extends HashMap<String, V> {

        private static final long serialVersionUID = -2212268410512043556L;

        @Override
        public V get(Object key) {
            if (!super.containsKey(key)) {
                throw new BindingException("Parameter '" + key + "' not found. Available parameters are " + keySet());
            }
            return super.get(key);
        }

    }

}
