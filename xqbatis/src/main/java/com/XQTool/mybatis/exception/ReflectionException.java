package com.XQTool.mybatis.exception;

/**
 * @ClassName ReflectionException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 17:52
 * @Version 1.0
 **/
public class ReflectionException extends PersistenceException {


    public ReflectionException() {
        super();
    }

    public ReflectionException(String message) {
        super(message);
    }

    public ReflectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReflectionException(Throwable cause) {
        super(cause);
    }

}
