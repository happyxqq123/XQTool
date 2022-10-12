package com.XQTool.mybatis.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Delete.List.class)
public @interface Delete {
    /**
     * Returns an SQL for deleting record(s).
     *
     * @return an SQL for deleting record(s)
     */
    String[] value();

    /**
     * @return A database id that correspond this statement
     * @since 3.5.5
     */
    String databaseId() default "";

    /**
     * The container annotation for {@link Delete}.
     * @author Kazuki Shimizu
     * @since 3.5.5
     */
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface List {
        Delete[] value();
    }

}
