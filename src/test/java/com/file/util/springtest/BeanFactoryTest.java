package com.file.util.springtest;

import com.mouse.InvocationHandler.model.MyTestBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created  on 2016/5/23.
 */
public class BeanFactoryTest {
	@Test
	public void testGetBeanFromBF() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("testSpring.xml"));
		MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
		Assert.assertEquals("test", myTestBean.getStr());
	}

}
