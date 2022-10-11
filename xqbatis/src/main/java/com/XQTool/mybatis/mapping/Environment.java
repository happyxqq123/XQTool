package com.XQTool.mybatis.mapping;

import javax.sql.DataSource;

/**
 * @ClassName Environment
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 11:26
 * @Version 1.0
 **/
public class Environment {

    private final String id;

    private final DataSource dataSource;

    public Environment(String id, DataSource dataSource){
        this.id = id;
        this.dataSource = dataSource;
    }

    public static class Builder{
        private final String id;

        private DataSource dataSource;

        public Builder(String id){this.id = id;}

        public Builder transactionFactory(DataSource dataSource){
            this.dataSource = dataSource;
            return this;
        }
        public Environment build(){
            return new Environment(this.id,this.dataSource);
        }
    }

    public DataSource getDataSource(){
        return this.dataSource;
    }



}
