package com.ming.ppsg.tool.generate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2020/1/6 0006.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenerateMybatis {
    boolean isEffect() default true;//是否生效
    String tableName() default "";
    String classMapping() default "";
    String baseUrl() default "";//基础文件路径
    String engine() default "InnoDB";
    String charset() default "utf8";
}
