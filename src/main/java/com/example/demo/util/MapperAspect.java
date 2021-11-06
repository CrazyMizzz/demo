package com.example.demo.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MapperAspect {

    @Pointcut("execution(public * com.example.demo.mapper..*.*(..))")
    public void beforeMapper(){}

    @Before("beforeMapper()")
    public void fillBaseInfo(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Arrays.stream(args).forEach(p->System.out.println(p.toString()));
    }
}
