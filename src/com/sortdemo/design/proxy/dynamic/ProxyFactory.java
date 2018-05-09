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
						System.out.println("**************动态代理开始保存****************");
						Object returnValue = method.invoke(target, args);
						System.out.println("**************动态代理结束保存****************");
						return returnValue;
					}
				});
	}
}
