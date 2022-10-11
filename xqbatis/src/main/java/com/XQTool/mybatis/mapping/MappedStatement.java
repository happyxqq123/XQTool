package com.XQTool.mybatis.mapping;

import com.XQTool.mybatis.cache.Cache;
import com.XQTool.mybatis.session.Configuration;

import java.sql.ResultSet;

/**
 * @ClassName MappedStatement
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 11:38
 * @Version 1.0
 **/
public class MappedStatement {

    private String resource;
    private Configuration configuration;
    private String id;
    private Integer fetchSize;
    private Integer timeout;
    private StatementType statementType;
    private ResultSetType resultSetType;
    private SqlSource sqlSource;
    private Cache cache;
}
