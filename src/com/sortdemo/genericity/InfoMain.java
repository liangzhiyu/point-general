package com.sortdemo.genericity;

public class InfoMain {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		
		Info<Integer> info = new Info<Integer>();
		info.setName(111111);
		
		Info<String> info2 = new Info<String>();
		info2.setName("fffffff");
		System.out.println(info.getName()+info2.getName());
		
		
		Info o = getObject(Info.class);
		String str = getObjectForName(String.class);
		System.out.println("FFFFFFFF"+o.hashCode());
		System.out.println(str.length());
	}

	public static <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
		T t = c.newInstance();
		return t;
	}
	
	
	public static <T> T getObjectForName(Class<T> c) throws InstantiationException, IllegalAccessException {
		
		return c.newInstance();
	}
	
	
}
