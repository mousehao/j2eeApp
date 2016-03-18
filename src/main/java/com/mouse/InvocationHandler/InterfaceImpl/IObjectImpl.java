package com.mouse.InvocationHandler.InterfaceImpl;

import com.mouse.InvocationHandler.Interface.IObject;
import com.mouse.InvocationHandler.TimeCalulatorHandler;

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
    }

    public static void main(String[] args) {
        //����java se�ṩ�Ļ��ڽӿڵĶ�̬����
        IObject iObject=new IObjectImpl();
        TimeCalulatorHandler timeCalulatorHandler=new TimeCalulatorHandler(iObject);
        IObject iObject1= (IObject) Proxy.newProxyInstance(iObject.getClass().getClassLoader(),iObject.getClass().getInterfaces(),timeCalulatorHandler);
        iObject1.run();
    }
}
