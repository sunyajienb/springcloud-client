package com.sun.springcloudclient.aop.annotation;

import com.sun.springcloudclient.aop.enums.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @annotation: Ds
 * @description: 数据源切换注解
 * @author: Jay Sun
 * @time: 2019-02-04 15:51
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Ds {
    /**
     * 切换数据源名称，默认是master
     */
    DataSourceType value() default DataSourceType.MASTER;
}
