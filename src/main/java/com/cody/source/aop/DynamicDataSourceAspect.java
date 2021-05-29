package com.cody.source.aop;

import com.cody.source.annotation.CUSTOMDS;
import com.cody.source.context.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * ClassName: DynamicDataSourceAspect
 *
 * @author WQL
 * @Description:
 * @date: 2021/5/29 16:55
 * @since JDK 1.8
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.cody.source.annotation.CUSTOMDS)")
    public void dataSourcePointcutCut() {}

    @Around("dataSourcePointcutCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String dsKey = getCUSTOMDSAnnotation(joinPoint).value();
        DynamicDataSourceContextHolder.setContextKey(dsKey);
        try {
            return joinPoint.proceed();
        } finally {
            DynamicDataSourceContextHolder.removeContextKey();
        }
    }

    private CUSTOMDS getCUSTOMDSAnnotation(ProceedingJoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        CUSTOMDS dsAnnotation = targetClass.getAnnotation(CUSTOMDS.class);
        // 先判断类的注解，再判断方法注解
        if (Objects.nonNull(dsAnnotation)) {
            return dsAnnotation;
        } else {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            return methodSignature.getMethod().getAnnotation(CUSTOMDS.class);
        }
    }


}
