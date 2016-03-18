package com.mouse.InvocationHandler.Advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by huawei on 2016/3/18.
 */
public class TimeShowBeforAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("methodBeforAdvice...........");
    }
}
