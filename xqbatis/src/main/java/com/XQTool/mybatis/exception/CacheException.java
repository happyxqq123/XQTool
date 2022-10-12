package com.XQTool.mybatis.exception;

/**
 * @ClassName CacheException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 15:39
 * @Version 1.0
 **/
public class CacheException extends PersistenceException{

    public CacheException() {
        super();
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, Throwable cause) {
        super(message, cause);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }
}
