package com.XQTool.mybatis.mapper;

import com.XQTool.mybatis.annotations.Param;
import com.XQTool.mybatis.toolkit.Constants;

import java.io.Serializable;
import java.sql.Wrapper;
import java.util.Map;

/**
 * @ClassName BaseMapper
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 9:45
 * @Version 1.0
 **/
public interface BaseMapper<T> extends Mapper<T>{

    int inser(T entity);

    int deleteById(Serializable id);

    int deleteById(T entity);

    int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);


}
