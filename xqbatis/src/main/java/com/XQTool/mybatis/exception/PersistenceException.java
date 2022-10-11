package com.XQTool.mybatis.exception;

/**
 * @ClassName PersistenceException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 15:08
 * @Version 1.0
 **/
public class PersistenceException extends RuntimeException{
    public PersistenceException() {
        super();
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(Throwable cause) {
        super(cause);
    }
}
