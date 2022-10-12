package com.XQTool.mybatis.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Select.List.class)
public @interface Select {
    /**
     * Returns an SQL for retrieving record(s).
     *
     * @return an SQL for retrieving record(s)
     */
    String[] value();

    /**
     * @return A database id that correspond this statement
     * @since 3.5.5
     */
    String databaseId() default "";

    /**
     * The container annotation for {@link Select}.
     * @author Kazuki Shimizu
     * @since 3.5.5
     */
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface List {
        Select[] value();
    }

}
