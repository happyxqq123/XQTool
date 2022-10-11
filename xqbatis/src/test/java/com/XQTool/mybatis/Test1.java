package com.XQTool.mybatis;

import com.XQTool.mybatis.type.ArrayTypeHandler;
import com.XQTool.mybatis.type.BigDecimalTypeHandler;
import com.XQTool.mybatis.type.JdbcType;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.EnumMap;
import java.util.Map;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 11:00
 * @Version 1.0
 **/
public class Test1 {

    private static Logger logger = LoggerFactory.getLogger(Test1.class);

    @Test
    public void testLog(){
        logger.info("info");
        logger.debug("debug");
    }

    @Test
    public void test2(){

        Map<JdbcType,String> map = new EnumMap<JdbcType, String>(JdbcType.class);
        System.out.println(map.size());
        System.out.println(map.values().size());

    }

    @Test
    public void test3(){
        float [] f = new float[3];
        Object o = f;
        System.out.println(o instanceof Array);
        Class<?> clazz =  o.getClass().getComponentType();
    }

    @Test
    public void test4(){
        BigDecimalTypeHandler bigDecimalTypeHandler = new BigDecimalTypeHandler();
        System.out.println(bigDecimalTypeHandler.getRawType());
    }

}
