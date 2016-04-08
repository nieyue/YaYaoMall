package com.yayao.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yayao.bean.User;
import com.yayao.service.UserService;
import com.yayao.util.SHAutil;


/**
 * 账户控制类
 * @author yy
 *
 */
@Scope("prototype")
@Controller("user")
@RequestMapping(value="/user")  
@SessionAttributes("user") 
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	
	/**
	 * 用户名检查，邮箱和手机
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/chkUserName",method=RequestMethod.GET)
	public @ResponseBody String userNameValid(@RequestParam String userName){
		boolean state= userService.chkLoginName(userName);
		if(state){
			return "用户已经存在！";
		}
		return  null;
	}
		@RequestMapping(value="/register",method=RequestMethod.POST)
		public @ResponseBody User userRegister(@ModelAttribute User user,ModelMap modelMap){
			/*if(result.hasErrors()){
				//customer.setContent(result.getFieldError().getDefaultMessage());
				return null;
			}*/
			try {
				String shalp = SHAutil.getSHA(user.getUserPassword());
				user.setUserPassword(shalp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean state= userService.chkLoginName(user.getUserName());
			if(state){
				return null;
			}
			modelMap.put("user", user);
			userService.addUser(user);
			return  user;
		}
}
