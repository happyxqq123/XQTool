package com.XQTool.mybatis.exception;

/**
 * @ClassName TooManyResultsException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 15:09
 * @Version 1.0
 **/
public class TooManyResultsException extends PersistenceException{

    public TooManyResultsException() {
        super();
    }

    public TooManyResultsException(String message) {
        super(message);
    }

    public TooManyResultsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TooManyResultsException(Throwable cause) {
        super(cause);
    }
}
