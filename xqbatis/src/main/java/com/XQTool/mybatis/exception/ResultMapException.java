package com.XQTool.mybatis.exception;

/**
 * @ClassName ResultMapException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 15:39
 * @Version 1.0
 **/
public class ResultMapException extends PersistenceException{

    public ResultMapException() {
    }

    public ResultMapException(String message) {
        super(message);
    }

    public ResultMapException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultMapException(Throwable cause) {
        super(cause);
    }
}
