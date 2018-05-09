package com.sortdemo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflect {
	
	
	/*Class核心方法
	getName()：获得类的完整名字。
	getFields()：获得类的public类型的属性。
	getDeclaredFields()：获得类的所有属性。
	getMethods()：获得类的public类型的方法。
	getDeclaredMethods()：获得类的所有方法。
	getMethod(String name, Class[] parameterTypes)：获得类的特定方法，name参数指定方法的名字，parameterTypes 参数指定方法的参数类型。
	getConstructors()：获得类的public类型的构造方法。
	getConstructor(Class[] parameterTypes)：获得类的特定构造方法，parameterTypes 参数指定构造方法的参数类型。
	newInstance()：通过类的不带参数的构造方法创建这个类的一个对象。*/
	
	public static void main(String[] args) throws Exception {
		String s ="&lt;img src=&quot;/we/userfiles/we/exam/201705/22/20170522164025_403.jpg&quot; alt=&quot;&quot; /&gt;AA11";
		String s2 = s.replace("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"");
		System.out.println(s2);
	}
	
	//通过反射给类的属性赋值
	public static void setFieldByReflect() throws Exception{
		Class c = Class.forName("com.sortdemo.reflect.ReflectEntity");//加载这个类
		Field field = c.getDeclaredField("name");	//获取name字段
		Object o = c.newInstance();	//实例化这个类（调用无参构造方法）
		field.setAccessible(true);	//打破封装性
		field.set(o, "jack");		//给o对象的name属性赋值为110
		System.out.println(c.getSimpleName());
	}
	
	//获取Integer类的属性
	public static void getFieldToInteger() throws Exception{
	       Class c = Class.forName("java.lang.Integer");    
           //获取所有的属性  
           Field[] fs = c.getDeclaredFields();    
        
           //定义可变长的字符串，用来存储属性    
           StringBuffer sb = new StringBuffer();    
           //通过追加的方法，将每个属性拼接到此字符串中    
           //最外边的public定义    
           sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");    
           //里边的每一个属性    
           for(Field field:fs){     
               sb.append("\t");//空格    
               sb.append(Modifier.toString(field.getModifiers())+" ");//获得属性的修饰符，例如public，static等等    
               sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字    
               sb.append(field.getName()+";\n");//属性的名字+回车    
           }    
           sb.append("}");  
           System.out.println(sb);
	}
	
	//通过发射获取类的方法
	public static void getMethodByReflect() throws Exception{
		Class<?> c = Class.forName("com.sortdemo.reflect.ReflectEntity");
		Method[]method = c.getMethods();//获得类的public类型的方法。
		for (Method m : method) {
			System.out.println(m);
		}
		Method[] method2 = c.getDeclaredMethods();//获取所有方法
		for (Method m : method2) {
			System.out.println(m);
		}
	}
}
