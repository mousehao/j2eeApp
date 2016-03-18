
import com.mouse.InvocationHandler.Advice.ExceptionAdvice;
import com.mouse.InvocationHandler.Advice.TimeShowBeforAdvice;
import com.mouse.InvocationHandler.InterfaceImpl.IObjectImpl;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by huawei on 2016/3/18.
 */
public class TestSpringProxyFactory {
    public static void main(String[] args) {
        IObjectImpl iObject1=new IObjectImpl();
        TimeShowBeforAdvice timeShowBeforAdvice=new TimeShowBeforAdvice();
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(iObject1);
        proxyFactory.addAdvice(timeShowBeforAdvice);
//        proxyFactory.addAdvice(new ExceptionAdvice());
        IObjectImpl iObject2=(IObjectImpl)proxyFactory.getProxy();
        iObject2.run();


    }
}
