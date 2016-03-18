import com.mouse.InvocationHandler.Advice.ExceptionAdvice;
import com.mouse.InvocationHandler.Advice.MonitorableInvocationAdvice;
import com.mouse.InvocationHandler.Advice.TimeShowBeforAdvice;
import com.mouse.InvocationHandler.Interface.Monitorable;
import com.mouse.InvocationHandler.InterfaceImpl.IObjectImpl;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by huawei on 2016/3/18.
 */
public class TestIntroducationInterceptor {
    public static void main(String[] args) {
        IObjectImpl iObject1=new IObjectImpl();
        MonitorableInvocationAdvice monitorableInvocationAdvice=new MonitorableInvocationAdvice();
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(iObject1);
        proxyFactory.addAdvice(monitorableInvocationAdvice);
        proxyFactory.setInterfaces(new Class[]{Monitorable.class});
        proxyFactory.setOptimize(true);
        IObjectImpl iObject2=(IObjectImpl)proxyFactory.getProxy();
        iObject2.run();
        Monitorable monitorable=(Monitorable)iObject2;
        monitorable.setActive(true);
        iObject2.run();
    }
}
