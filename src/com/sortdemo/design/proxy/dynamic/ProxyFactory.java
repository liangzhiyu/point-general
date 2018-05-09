package com.sortdemo.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory<T> {

	private T target;
	
	public ProxyFactory(T target) {
		this.target=target;
	}
	
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy,Method method,Object[] args) throws  Throwable  {
						System.out.println("**************��̬����ʼ����****************");
						Object returnValue = method.invoke(target, args);
						System.out.println("**************��̬�����������****************");
						return returnValue;
					}
				});
	}
}
