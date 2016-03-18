package com.mouse.InvocationHandler.InterfaceImpl;

import com.mouse.InvocationHandler.Interface.IObject;
import com.mouse.InvocationHandler.TimeCalulatorHandler;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.lang.reflect.Proxy;

/**
 * Created by huawei on 2016/3/18.
 */
public class IObjectImpl implements IObject {
    public void run() {
        int i=1;
        while(i<100000){
            i+=1;
        }
//        int b=1/0;
    }

    public static void main(String[] args) {
        //测试java se提供的基于接口的动态代理
        IObject iObject=new IObjectImpl();
        TimeCalulatorHandler timeCalulatorHandler=new TimeCalulatorHandler(iObject);
        IObject iObject1= (IObject) Proxy.newProxyInstance(iObject.getClass().getClassLoader(),iObject.getClass().getInterfaces(),timeCalulatorHandler);
        iObject1.run();

    }
}
