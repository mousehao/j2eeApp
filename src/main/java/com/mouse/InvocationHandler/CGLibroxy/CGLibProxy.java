package com.mouse.InvocationHandler.CGLibroxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by huawei on 2016/3/18.
 */
public class CGLibProxy implements MethodInterceptor {
    private Enhancer enhancer=new Enhancer();

    public Object getProxy(Class cls){
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object object1=methodProxy.invokeSuper(o, objects);
        long endTime=System.currentTimeMillis();
        System.out.println("time run:"+(endTime-startTime));
        return object1;
    }
}
