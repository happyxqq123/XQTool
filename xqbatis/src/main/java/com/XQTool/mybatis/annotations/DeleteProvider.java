package com.XQTool.mybatis.annotations;

import java.lang.annotation.*;

/**
 * @ClassName DeleteProvider
 * @Description TODO
 * @Author admin
 * @Date 2022/10/12 10:40
 * @Version 1.0
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(DeleteProvider.List.class)
public @interface DeleteProvider {

    /**
     * Specify a type that implements an SQL provider method.
     *
     * @return a type that implements an SQL provider method
     * @since 3.5.2
     * @see #type()
     */
    Class<?> value() default void.class;

    /**
     * Specify a type that implements an SQL provider method.
     * <p>
     * This attribute is alias of {@link #value()}.
     * </p>
     *
     * @return a type that implements an SQL provider method
     * @see #value()
     */
    Class<?> type() default void.class;

    /**
     * Specify a method for providing an SQL.
     *
     * <p>
     * Since 3.5.1, this attribute can omit.
     * If this attribute omit, the MyBatis will call a method that decide by following rules.
     * <ul>
     *   <li>
     *     If class that specified the {@link #type()} attribute implements the
     *     {@link org.apache.ibatis.builder.annotation.ProviderMethodResolver},
     *     the MyBatis use a method that returned by it
     *   </li>
     *   <li>
     *     If cannot resolve a method by {@link org.apache.ibatis.builder.annotation.ProviderMethodResolver}(= not implement it or it was returned {@code null}),
     *     the MyBatis will search and use a fallback method that named {@code provideSql} from specified type
     *   </li>
     * </ul>
     *
     * @return a method name of method for providing an SQL
     */
    String method() default "";

    /**
     * @return A database id that correspond this provider
     * @since 3.5.5
     */
    String databaseId() default "";

    /**
     * The container annotation for {@link DeleteProvider}.
     * @author Kazuki Shimizu
     * @since 3.5.5
     */
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface List {
        DeleteProvider[] value();
    }

}
