package com.XQTool.mybatis.session;

import com.XQTool.mybatis.mapping.Environment;
import com.XQTool.mybatis.type.TypeHandlerRegistry;
import lombok.Getter;

/**
 * @ClassName Configuration
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 11:26
 * @Version 1.0
 **/
public class Configuration {

    protected Environment environment;

    @Getter
    protected final TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry(this);



}
