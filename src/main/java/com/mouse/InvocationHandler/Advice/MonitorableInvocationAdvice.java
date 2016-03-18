package com.mouse.InvocationHandler.Advice;

import com.mouse.InvocationHandler.Interface.Monitorable;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;

/**
 * Created by huawei on 2016/3/18.
 */
public class MonitorableInvocationAdvice extends DelegatingIntroductionInterceptor implements Monitorable {
	ThreadLocal<Boolean> threadLocal=new ThreadLocal<Boolean>();
	public void setActive(boolean active) {
		threadLocal.set(active);
	}

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println(Thread.currentThread().getId());
		if(threadLocal.get()!=null&&threadLocal.get()){
			System.out.println("开启了开关。。。");
		}else {
			System.out.println("关闭了开关。。。");
		}
		return super.invoke(mi);
	}
}
