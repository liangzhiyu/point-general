package com.sortdemo.design.proxy.statics;

public class ProxyUserDao implements IUserDao{

	UserDao userDao;
	
	public ProxyUserDao(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public void save() {
		System.out.println("*************������ǰ*********");
		userDao.save();
		System.out.println("*************�������*********");
	}

}
