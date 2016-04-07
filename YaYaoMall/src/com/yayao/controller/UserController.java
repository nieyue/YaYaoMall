package com.yayao.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yayao.service.UserService;


/**
 * 用户控制类
 * @author yy
 *
 */
@Scope("prototype")
@Controller("user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	
}
