package com.sun.springcloudclient.aop;

import com.sun.springcloudclient.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @class: DsAspect
 * @description: aop 数据源
 * @author: Jay Sun
 * @time: 2019-02-04 16:01
 **/
@Aspect
@Order(1)
@Component
public class DsAspect {

    @Pointcut("@annotation(com.sun.springcloudclient.aop.Ds)")
    public void dsPointCut() {
    }

    @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Ds dataSource = method.getAnnotation(Ds.class);
        if (dataSource != null) {
            DynamicDataSourceContextHolder.setDateSoureType(dataSource.value().name());
        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDateSoureType();
        }
    }

}
