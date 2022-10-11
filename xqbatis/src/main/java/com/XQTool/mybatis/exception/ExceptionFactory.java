package com.XQTool.mybatis.exception;

import com.XQTool.mybatis.executor.ErrorContext;

/**
 * @ClassName ExceptionFactory
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 15:09
 * @Version 1.0
 **/
public class ExceptionFactory {

    private ExceptionFactory() {
        // Prevent Instantiation
    }

    public static RuntimeException wrapException(String message, Exception e) {
        return new PersistenceException(ErrorContext.instance().message(message).cause(e).toString(), e);
    }

}
