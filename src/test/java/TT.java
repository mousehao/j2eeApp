import com.mouse.InvocationHandler.InterfaceImpl.IObjectImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huawei on 2016/3/18.
 */
public class TT {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        IObjectImpl iObject=(IObjectImpl)context.getBean("objectImpl");
        iObject.run();

    }
}
