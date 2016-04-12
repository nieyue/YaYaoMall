package com.yayao.controller;

import java.security.Provider.Service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateUtils;
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
import com.yayao.mail.SendMailDemo;
import com.yayao.service.UserService;
import com.yayao.util.DateUtil;
import com.yayao.util.SHAutil;

/**
 * 账户控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("user")
@RequestMapping(value = "/user")
public class UserController {
	@Resource(name = "userService")
	private UserService userService;
	/**
	 * 用户名检查，邮箱和手机
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/chkUserName", method = RequestMethod.GET)
	public @ResponseBody
	String userNameValid(@RequestParam String userName) {
		boolean state = userService.chkLoginName(userName);
		if (state) {
			return "用户已经存在！";
		}
		return "200";
	}
	/**
	 * 邮箱验证码发送
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/validCode", method = RequestMethod.GET)
	public @ResponseBody
	String validCode(@RequestParam("userEmail") final String userEmail,@RequestParam("validCode") final String validCode,HttpSession session) {
		new Thread(new Runnable() {
			public void run() {
				SendMailDemo smd=new SendMailDemo();
				smd.sendMail(userEmail,Integer.valueOf(validCode));
			}
		}).start();
		session.setAttribute("validCode",Integer.valueOf(validCode));
		session.setAttribute("validCodeExpire",DateUtil.getCurrentTime());
		return "200";
	}
	/**
	 * 邮箱验证码验证
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/chkValidCode", method = RequestMethod.GET)
	public @ResponseBody
	String chkValidCode(@RequestParam("validCode")String validCode,HttpSession session) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date validCodeExpire = null;
		try {
			String sessionvce = session.getAttribute("validCodeExpire").toString();
			validCodeExpire = format.parse(sessionvce);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!(new Date().after(DateUtil.getFirstToTime(validCodeExpire, 1)))){//没过期
			if(Integer.valueOf(session.getAttribute("validCode").toString()).equals(Integer.valueOf(validCode))){
				return "200";
			
		}
			return "验证码错误";
			
		}
		return "验证码过期";
	}
	/**
	 * 用户注册
	 * @param user
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody
	User userRegister(@ModelAttribute User user,@RequestParam("validCode") String validCode, HttpSession session) {
		/*
		 * if(result.hasErrors()){
		 * //customer.setContent(result.getFieldError().getDefaultMessage());
		 * return null; }
		 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date validCodeExpire = null;
		try {
			String sessionvce = session.getAttribute("validCodeExpire").toString();
			validCodeExpire = format.parse(sessionvce);
		if(!(new Date().after(DateUtil.getFirstToTime(validCodeExpire, 1)))){//没过期
			if(Integer.valueOf(session.getAttribute("validCode").toString()).equals(Integer.valueOf(validCode))){
			String shalp = SHAutil.getSHA(user.getUserPassword());
			user.setUserPassword(shalp);
		String username = null;
		if(user.getUserEmail()!=null&&!user.getUserEmail().isEmpty()){
			username=user.getUserEmail();
		}
		if(user.getUserPhone()!=null&&!user.getUserPhone().isEmpty()){
			username=user.getUserPhone();
		}
		boolean state = userService.chkLoginName(username);
		if (state) {
			return null;
		}
		session.setAttribute("user", user);
		userService.addUser(user);
		return user;
			}
			user.setUserMsg("验证码错误");
		}
		user.setUserMsg("验证码过期");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
