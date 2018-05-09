package com.sortdemo.design.proxy.statics;

public class UserMain {

	public static void main(String[] args) {

		UserDao userDao = new UserDao();
		ProxyUserDao proxyUserDao = new ProxyUserDao(userDao);
		proxyUserDao.save();
	}

}
