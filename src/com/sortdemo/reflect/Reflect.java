package com.sortdemo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflect {
	
	
	/*Class���ķ���
	getName()���������������֡�
	getFields()��������public���͵����ԡ�
	getDeclaredFields()���������������ԡ�
	getMethods()��������public���͵ķ�����
	getDeclaredMethods()�����������з�����
	getMethod(String name, Class[] parameterTypes)���������ض�������name����ָ�����������֣�parameterTypes ����ָ�������Ĳ������͡�
	getConstructors()��������public���͵Ĺ��췽����
	getConstructor(Class[] parameterTypes)���������ض����췽����parameterTypes ����ָ�����췽���Ĳ������͡�
	newInstance()��ͨ����Ĳ��������Ĺ��췽������������һ������*/
	
	public static void main(String[] args) throws Exception {
		String s ="&lt;img src=&quot;/we/userfiles/we/exam/201705/22/20170522164025_403.jpg&quot; alt=&quot;&quot; /&gt;AA11";
		String s2 = s.replace("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&quot;", "\"");
		System.out.println(s2);
	}
	
	//ͨ�������������Ը�ֵ
	public static void setFieldByReflect() throws Exception{
		Class c = Class.forName("com.sortdemo.reflect.ReflectEntity");//���������
		Field field = c.getDeclaredField("name");	//��ȡname�ֶ�
		Object o = c.newInstance();	//ʵ��������ࣨ�����޲ι��췽����
		field.setAccessible(true);	//���Ʒ�װ��
		field.set(o, "jack");		//��o�����name���Ը�ֵΪ110
		System.out.println(c.getSimpleName());
	}
	
	//��ȡInteger�������
	public static void getFieldToInteger() throws Exception{
	       Class c = Class.forName("java.lang.Integer");    
           //��ȡ���е�����  
           Field[] fs = c.getDeclaredFields();    
        
           //����ɱ䳤���ַ����������洢����    
           StringBuffer sb = new StringBuffer();    
           //ͨ��׷�ӵķ�������ÿ������ƴ�ӵ����ַ�����    
           //����ߵ�public����    
           sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");    
           //��ߵ�ÿһ������    
           for(Field field:fs){     
               sb.append("\t");//�ո�    
               sb.append(Modifier.toString(field.getModifiers())+" ");//������Ե����η�������public��static�ȵ�    
               sb.append(field.getType().getSimpleName() + " ");//���Ե����͵�����    
               sb.append(field.getName()+";\n");//���Ե�����+�س�    
           }    
           sb.append("}");  
           System.out.println(sb);
	}
	
	//ͨ�������ȡ��ķ���
	public static void getMethodByReflect() throws Exception{
		Class<?> c = Class.forName("com.sortdemo.reflect.ReflectEntity");
		Method[]method = c.getMethods();//������public���͵ķ�����
		for (Method m : method) {
			System.out.println(m);
		}
		Method[] method2 = c.getDeclaredMethods();//��ȡ���з���
		for (Method m : method2) {
			System.out.println(m);
		}
	}
}
