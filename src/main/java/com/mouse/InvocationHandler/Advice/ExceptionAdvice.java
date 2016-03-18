package com.mouse.InvocationHandler.Advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by huawei on 2016/3/18.
 */
public class ExceptionAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method,Object[] args,Object target,Exception ex){
        System.out.println("发生异常了");
        System.out.println(ex.getMessage());
        System.out.println(ex.toString());
    }

}
