package com.XQTool.mybatis.exception;

/**
 * @ClassName BuilderException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 14:35
 * @Version 1.0
 **/
public class BuilderException extends PersistenceException{

    public BuilderException() {
        super();
    }

    public BuilderException(String message) {
        super(message);
    }

    public BuilderException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuilderException(Throwable cause) {
        super(cause);
    }
}
