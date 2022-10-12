package com.XQTool.mybatis.exception;

/**
 * @ClassName IncompleteElementException
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 14:55
 * @Version 1.0
 **/
public class IncompleteElementException extends BuilderException {
    private static final long serialVersionUID = -3697292286890900315L;

    public IncompleteElementException() {
        super();
    }

    public IncompleteElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncompleteElementException(String message) {
        super(message);
    }

    public IncompleteElementException(Throwable cause) {
        super(cause);
    }

}
