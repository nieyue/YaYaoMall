package com.yayao.test;

import org.springframework.stereotype.Component;

@Component
public class Test2 {
	public String updateUser(String test) {
		System.out.println("测试aop"+test);
		return test;
	}
	public String addUser(String test,Integer test2) {
		System.out.println("测试aop"+test+test2.toString());
		return test;
	}
	
}
