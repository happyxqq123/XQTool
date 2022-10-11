package com.XQTool.mybatis;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.xml.ws.Holder;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * @ClassName ParameterizedTypeTest
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 14:30
 * @Version 1.0
 **/
@Slf4j
public class ParameterizedTypeTest {
    private Map<String,ParameterizedTypeTest> map;
    private Set<String> setStr;
    private Class<?> clz;
    private Holder<String> holder;
    private List<String> listStr;
    private ArrayList<String> arrayList;
    private Map.Entry<String,String> entry;

    @Test
    public void test(){
        try{
            Field[] fields = ParameterizedTypeTest.class.getDeclaredFields();
            Arrays.stream(fields).forEach(item -> {
                if(item.getGenericType() instanceof ParameterizedType){
                    item.setAccessible(true);
                    ParameterizedType parameterizedType = (ParameterizedType)item.getGenericType();
                    log.info("{}:", item.getName());
                    log.info("getActualTypeArguments: {}", Arrays.asList(parameterizedType.getActualTypeArguments()));
                    log.info("getRawType: {}",parameterizedType.getRawType());
                    log.info("getOwnerType: {}",parameterizedType.getOwnerType());
                }else{
                    log.info("{} is not ParameterizedType", item.getName());
                }
            });

        }catch (Exception e){
            log.info("exception:",e);
        }
    }

}
