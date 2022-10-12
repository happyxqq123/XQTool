package com.XQTool.mybatis.annotations;

import java.lang.annotation.*;

/**
 * @ClassName SelectProvider
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 10:35
 * @Version 1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(SelectProvider.List.class)
public @interface SelectProvider {

    Class<?> value() default  void.class;

    Class<?> type() default void.class;

    String method() default "";

    String databaseId() default "";

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface List{
        SelectProvider[] value();
    }
}
