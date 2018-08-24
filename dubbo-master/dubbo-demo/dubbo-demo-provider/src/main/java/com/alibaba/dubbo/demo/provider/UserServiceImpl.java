package com.alibaba.dubbo.demo.provider;

import com.alibaba.dubbo.demo.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public String findByUsernameAndPassword(String username, String password) {
		System.out.println("--哈哈--果然有奇人!此人是:");
		return "wulin";
	}

}
