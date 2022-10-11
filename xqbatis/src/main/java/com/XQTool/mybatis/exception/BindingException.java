package com.XQTool.mybatis.exception;

/**
 * @ClassName BindingException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/11 17:27
 * @Version 1.0
 **/
public class BindingException  extends PersistenceException{


    public BindingException() {
        super();
    }

    public BindingException(String message) {
        super(message);
    }

    public BindingException(String message, Throwable cause) {
        super(message, cause);
    }

    public BindingException(Throwable cause) {
        super(cause);
    }

}
