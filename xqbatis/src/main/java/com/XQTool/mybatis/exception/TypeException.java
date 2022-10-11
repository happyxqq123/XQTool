package com.XQTool.mybatis.exception;

/**
 * @ClassName TypeException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 15:18
 * @Version 1.0
 **/
public class TypeException extends PersistenceException{

    public TypeException() {
        super();
    }

    public TypeException(String message) {
        super(message);
    }

    public TypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeException(Throwable cause) {
        super(cause);
    }
}
