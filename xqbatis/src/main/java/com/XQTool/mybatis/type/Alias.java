package com.XQTool.mybatis.type;

import java.lang.annotation.*;

/**
 * @ClassName Alias
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 14:04
 * @Version 1.0
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Alias {
    String value();
}
