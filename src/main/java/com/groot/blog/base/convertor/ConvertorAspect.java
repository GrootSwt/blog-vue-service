package com.groot.blog.base.convertor;

import com.groot.blog.base.bean.BaseEntity;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConvertorAspect {

    @Pointcut("execution(* com.groot.blog.base.convertor.BaseConvertor.toEntity(..))")
    public void pointCut() {

    }

    @AfterReturning(value = "pointCut()", returning = "entity")
    public void afterAdvice( BaseEntity entity) {
        if (entity.isNew()) {
            entity.setCreateProperty();
        }else {
            entity.setUpdateProperty();
        }
    }
}
