package com.sortdemo.design.proxy.statics;

public class ProxyUserDao implements IUserDao{

	UserDao userDao;
	
	public ProxyUserDao(UserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public void save() {
		System.out.println("*************代理保存前*********");
		userDao.save();
		System.out.println("*************代理保存后*********");
	}

}
