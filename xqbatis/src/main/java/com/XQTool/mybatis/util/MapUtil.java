package com.XQTool.mybatis.util;

import java.util.AbstractMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @ClassName MapUtil
 * @Description TODO
 * @Author admin
 * @Date 2022/10/13 14:55
 * @Version 1.0
 **/
public class MapUtil {

    public static <K,V> V computeIfAbsent(Map<K,V> map, K key, Function<K,V> mappingFunction){
        V value = map.get(key);
        if(value != null){
            return value;
        }
        return map.computeIfAbsent(key,mappingFunction);
    }

    public static <K, V> Map.Entry<K, V> entry(K key, V value) {
        return new AbstractMap.SimpleImmutableEntry<>(key, value);
    }

    private MapUtil() {
        super();
    }


}
