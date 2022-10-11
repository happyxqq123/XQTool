package com.XQTool.mybatis.mapping;

import com.XQTool.mybatis.session.Configuration;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName ParameterMap
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 13:38
 * @Version 1.0
 **/
public class ParameterMap {

    private String id;
    private Class<?> type;
    private List<ParameterMapping> parameterMappings;

    private ParameterMap(){

    }

    public static class Builder{
        private ParameterMap parameterMap = new ParameterMap();

        public Builder(Configuration configuration, String id,Class<?> type, List<ParameterMapping> parameterMappings){
            parameterMap.id = id;
            parameterMap.type = type;
            parameterMap.parameterMappings =parameterMappings;
        }

        public Class<?> type(){
            return parameterMap.type;
        }

        public ParameterMap build(){
            parameterMap.parameterMappings = Collections.unmodifiableList(parameterMap.parameterMappings);
            return parameterMap;
        }
    }

}
