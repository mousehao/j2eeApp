
import com.mouse.InvocationHandler.CGLibroxy.CGLibProxy;
import com.mouse.InvocationHandler.InterfaceImpl.IObjectImpl;

/**
 * Created by huawei on 2016/3/18.
 */
public class TestCGLibProxy {
    public static void main(String[] args) {
        CGLibProxy cgLibProxy=new CGLibProxy();
        IObjectImpl iObject=(IObjectImpl)cgLibProxy.getProxy(IObjectImpl.class);
        iObject.run();
    }
}
