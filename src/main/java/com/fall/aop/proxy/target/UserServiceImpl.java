package com.fall.aop.proxy.target;

/**
 * 目标对象
 */
public class UserServiceImpl implements UserService {

	@Override
	public void saveUser() {
		System.out.println("目标类执行: 添加用户");
	}

}
