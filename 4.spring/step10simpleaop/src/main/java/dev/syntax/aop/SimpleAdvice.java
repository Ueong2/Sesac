package dev.syntax.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

@Slf4j
public class SimpleAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    /*
        MethodBeforeAdvice
        대상 메서드(target method)가 실행되기 전에 처리할 내용
     */

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        log.info("--before called");
        for(Object arg : args){
            log.info("Argument : " + arg);
        }
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(returnValue);
        System.out.println(method);
        System.out.println(args);
        System.out.println(target);
    }
}
