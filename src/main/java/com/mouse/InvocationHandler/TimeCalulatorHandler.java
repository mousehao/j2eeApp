package com.mouse.InvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by huawei on 2016/3/18.
 */
public class TimeCalulatorHandler implements InvocationHandler {
    private  Object target;

    public TimeCalulatorHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object object=method.invoke(target, args);
        long endTime=System.currentTimeMillis();
        System.out.println("time run:"+(endTime-startTime));
        return object;
    }
}
