package com.yayao.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yayao.bean.User;
import com.yayao.mail.SendMailDemo;
import com.yayao.myView.PDFView;
import com.yayao.myView.XLSView;
import com.yayao.service.UserService;
import com.yayao.util.DateUtil;
import com.yayao.util.FileUploadUtil;
import com.yayao.util.NumberUtil;
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
	@Resource(name = "xlsView")
	private XLSView xlsView;
	@Resource(name = "pdfView")
	private PDFView pdfView;
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
			return "用户已经存在";
		}
		return "用户不存在";
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
		if(!NumberUtil.isNumeric(validCode)){
			return "验证码错误";
		}
		if(session.getAttribute("validCodeExpire")==null){
			return "验证码错误";
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date validCodeExpire = null;
		try {
			String sessionvce = session.getAttribute("validCodeExpire").toString();
			validCodeExpire = format.parse(sessionvce);
		} catch (ParseException e) {
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
	 * @throws Exception 
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody
	User userRegister(@ModelAttribute User user,@RequestParam("validCode") String validCode, HttpSession session) throws Exception {
		/*
		 * if(result.hasErrors()){
		 * //customer.setContent(result.getFieldError().getDefaultMessage());
		 * return null; }
		 */
		if(!NumberUtil.isNumeric(validCode)){
			return null;
		}
		if(session.getAttribute("validCodeExpire")==null){
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date validCodeExpire = null;
		
			String sessionvce = session.getAttribute("validCodeExpire").toString();
			validCodeExpire = format.parse(sessionvce);
		if(!(new Date().after(DateUtil.getFirstToTime(validCodeExpire, 1)))){//没过期
			if(Integer.valueOf(session.getAttribute("validCode").toString()).equals(Integer.valueOf(validCode))){
			String shalp = SHAutil.getSHA(user.getUserPassword());
			user.setUserPassword(shalp);
		
		boolean status = userService.addUser(user);
		session.setAttribute("user", user);
		if(status){
			user.setUserMsg("200");
			return user;
		}
		return null;
			}
			user.setUserMsg("验证码错误");
			return user;
		}
		user.setUserMsg("验证码过期");
		
		return user;
	}
	
	/**
	 * 账户登录
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	User login(HttpSession session,String userName,String userPassword) throws Exception {
		boolean status = userService.chkLoginName(userName);
		if(status&&userPassword!=null){
			String shaup = SHAutil.getSHA(userPassword);
			User user = userService.userLogin(userName, shaup);
			if(user!=null){
				user.setUserMsg("200");
				session.setAttribute("user", user);
				return user;
			}
		}
		
		return null;
		
	}
	/**
	 * 账户登出
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public @ResponseBody void loginOut(HttpSession session) throws Exception {
		if(session.getAttribute("user")!=null){
			session.invalidate();
		}
		
	}
	/**
	 * userIMG图片上传
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/userIMGUpload", method = RequestMethod.POST)
	public @ResponseBody void userIMGUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request,@RequestParam("userid")Integer id)  {
			User u=userService.loadUser(id);
			 try {
				 String userIMG = FileUploadUtil.FormDataFileUpload(file, request);
				u.setUserIMG(userIMG);
			}catch (IOException e) {
				e.printStackTrace();
			}
			 userService.updateUser(u);
		}
	/**
	 * 账户修改属性
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */   
	@RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
	public @ResponseBody void updateUser(HttpSession session ,Integer userid, String userInfoOne,String changeValue)  {
		User u=null;
			if(!NumberUtil.isNumeric(String.valueOf(userid))){
			return ;
			}
			u=userService.loadUser(userid);
		
		if(userInfoOne.indexOf("NiceName")>-1){
			u.setUserNiceName(changeValue);
		}else if(userInfoOne.indexOf("Signature")>-1){
			u.setUserSignature(changeValue);
		}else if(userInfoOne.indexOf("Email")>-1){
			u.setUserEmail(changeValue);
		}else if(userInfoOne.indexOf("Phone")>-1){
			u.setUserPhone(changeValue);
		}else if(userInfoOne.indexOf("Identity")>-1){
			u.setUserIdentity(changeValue);
		}
		session.setAttribute("user",u);
		userService.updateUser(u);
		
	}
	
	/**
	 * 单个账户加载
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/loadUser", method = RequestMethod.GET)
	public @ResponseBody
	User loadUser(HttpSession session,Integer id) {
		if(NumberUtil.isNumeric(String.valueOf(id))){
			User u = userService.loadUser(id);
			session.setAttribute("user",u);
			return u;
		}
		return null;
		
	}
	/**
	 * 所有账户加载
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"/browseUser"}, method = RequestMethod.GET)
	public @ResponseBody
	List<User> browseUser(HttpSession session,Model model) {
		List<User> list = userService.browseUser();
		model.addAttribute("userList", list);
		return list;
		
	}
	/**
	 * xls
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"/browseUserXLS"}, method = RequestMethod.GET)
	@ResponseBody
	public XLSView browseUserXLS(HttpSession session,Model model) {
		List<User> list = userService.browseUser();
		model.addAttribute("userList", list);
		xlsView.setFileName("用户信息excel");
		return xlsView;
		
	}
	/**
	 * pdf
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"/browseUserPDF"}, method = RequestMethod.GET)
	public @ResponseBody PDFView browseUserPDF(HttpSession session,Model model) {
		List<User> list = userService.browseUser();
		model.addAttribute("userList", list);
		pdfView.setFileName("用户信息PDF");
		return pdfView;
		
	}
}
