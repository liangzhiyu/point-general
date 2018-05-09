package com.sortdemo.design.proxy.dynamic;

public class DynamicMain {

	public static void main(String[] args) {
		 // Ŀ�����
        IUserDao target = new UserDao();
        // ��ԭʼ������ class cn.itcast.b_dynamic.UserDao��
        System.out.println(target.getClass());

        // ��Ŀ����󣬴����������
        IUserDao proxy = (IUserDao) new ProxyFactory<IUserDao>(target).getProxyInstance();
        // class $Proxy0   �ڴ��ж�̬���ɵĴ������
        System.out.println(proxy.getClass());

        // ִ�з���   ���������
        proxy.save();
	}
}
