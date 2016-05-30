package com.yayao.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
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
import com.yayao.business.MyValidator;
import com.yayao.mail.SendMailDemo;
import com.yayao.messageinterface.SMSInterface;
import com.yayao.myView.PDFView;
import com.yayao.myView.XLSView;
import com.yayao.service.UserService;
import com.yayao.util.DateUtil;
import com.yayao.util.FileUploadUtil;
import com.yayao.util.MyDESutil;
import com.yayao.util.NumberUtil;
import com.yayao.util.StatusCode;

/**
 * 账户控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("userController")
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
	@RequestMapping(value = "/chkUserName", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String userNameValid(@RequestParam("accountName") String userName) {
		boolean state = userService.chkLoginName(userName);
		if (state) {
			return StatusCode.GetValueByKey(StatusCode.USER_EXIST);
		}
		return StatusCode.GetValueByKey(StatusCode.USER_NOT_EXIST);
	}
	/**
	 * 邮箱/手机验证码发送
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/userValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String validCode(@RequestParam("accountName") final String accountName,HttpSession session) throws ParseException {
		String uvc="";
		String uvce="";
		if(Pattern.matches(MyValidator.REGEX_EMAIL,accountName)){
			uvc="userEmailValidCode";
			uvce="userEmailValidCodeExpire";
		}
		if(Pattern.matches(MyValidator.REGEX_PHONE,accountName)){
			uvc="userPhoneValidCode";
			uvce="userPhoneValidCodeExpire";
		}
		
		if(session.getAttribute(uvce)!=null){
			String sessionvce = session.getAttribute(uvce).toString();
			if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 1)))){//没超过一分钟
			return StatusCode.GetValueByKey(StatusCode.ONE_ASK_ONE);
		}
			
		}		
		Integer userValidCode=(int) (Math.random()*9000+1000);
		try {
			if(Pattern.matches(MyValidator.REGEX_EMAIL,accountName)){
				SendMailDemo.sendSafeMail(accountName,Integer.valueOf(userValidCode));
			}
			if(Pattern.matches(MyValidator.REGEX_PHONE,accountName)){
				SMSInterface.SmsNumSend(String.valueOf(userValidCode), accountName,StatusCode.GetValueByKey(StatusCode.SMS_TEMPLATE_CODE_REG));
			}
		} catch (NumberFormatException e) {
			return null;
		} catch (InterruptedException e) {
			return null;
		}
		session.setAttribute(uvc,userValidCode);
		session.setAttribute(uvce,DateUtil.getCurrentTime());
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	/**
	 * 邮箱/手机验证码验证
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value = "/chkUserValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String chkValidCode(@RequestParam("validCode")String userValidCode,HttpSession session) throws NumberFormatException, ParseException {
		
		if(!NumberUtil.isNumeric(userValidCode)){
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
		}
		if(session.getAttribute("userEmailValidCodeExpire")==null&&session.getAttribute("userPhoneValidCodeExpire")==null){
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
		}
		String uvc="";
		String uvce="";
		if(session.getAttribute("userEmailValidCodeExpire")!=null){
			uvc="userEmailValidCode";
			uvce="userEmailValidCodeExpire";
		}
		if(session.getAttribute("userPhoneValidCodeExpire")!=null){
			uvc="userPhoneValidCode";
			uvce="userPhoneValidCodeExpire";
		}
		//两个都存在，取时间最后最近的
		if(session.getAttribute("userEmailValidCodeExpire")!=null&&session.getAttribute("userPhoneValidCodeExpire")!=null){
			if(DateUtil.parseDate(session.getAttribute("userEmailValidCodeExpire").toString()).after(DateUtil.parseDate(session.getAttribute("userPhoneValidCodeExpire").toString()))){
				uvc="userEmailValidCode";
				uvce="userEmailValidCodeExpire";
			}
		}
		String sessionvce = session.getAttribute(uvce).toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute(uvc).toString()).equals(Integer.valueOf(userValidCode))){
				return StatusCode.GetValueByKey(StatusCode.SUCCESS);
			
		}
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
			
		}
		return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_EXPIRED);
	}
	/**
	 * 用户注册
	 * @param user
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/userRegister", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	User userRegister(@ModelAttribute User user,@RequestParam("validCode") String userValidCode, HttpSession session) throws Exception {
		/*
		 * if(result.hasErrors()){
		 * //customer.setContent(result.getFieldError().getDefaultMessage());
		 * return null; }
		 */
		String uvc="";
		String uvce="";
		if(!NumberUtil.isNumeric(userValidCode)){
			return null;
		}
		if(user.getUserEmail()!=null&&Pattern.matches(MyValidator.REGEX_EMAIL,user.getUserEmail())){
			uvc="userEmailValidCode";
			uvce="userEmailValidCodeExpire";
		if(session.getAttribute("userEmailValidCodeExpire")==null){
			return null;
		}
		}
		if(user.getUserPhone()!=null&&Pattern.matches(MyValidator.REGEX_PHONE,user.getUserPhone())){
			uvc="userPhoneValidCode";
			uvce="userPhoneValidCodeExpire";
			if(session.getAttribute("userPhoneValidCodeExpire")==null){
				return null;
			}
		}
		
		String sessionvce = session.getAttribute(uvce).toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute(uvc).toString()).equals(Integer.valueOf(userValidCode))){
			String shalp =  MyDESutil.getMD5(user.getUserPassword());
			user.setUserPassword(shalp);
		
		boolean status = userService.addUser(user);
		if(status){
			//成功则清除validcode
			session.removeAttribute(uvce);
			session.removeAttribute(uvc);
			user.setUserMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
			session.setAttribute("user", user);
			return user;
		}
		return null;
			}
			user.setUserMsg(StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR));
			return user;
		}
		user.setUserMsg(StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_EXPIRED));
		
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
	@RequestMapping(value = "/login", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	User login(HttpSession session,@RequestParam("userName")String userName,@RequestParam("userPassword")String userPassword) throws Exception {
		boolean status = userService.chkLoginName(userName);
		if(status&&userPassword!=null){
			String shaup =  MyDESutil.getMD5(userPassword);
			User user = userService.userLogin(userName, shaup);
			if(user!=null){
				user.setUserMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
				session.setAttribute("user", user);
				return user;
			}
		}
		
		return null;
		
	}
	/**
	 * 账户自动登录
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/userAutoLogin", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	User sellerAutoLogin(HttpSession session,@RequestParam("userId")Integer userId,@RequestParam("loginState")String loginState){
		User user=new User();
		//如果会话存在
		if(session.getAttribute("user")!=null&&((User)session.getAttribute("user")).getUserId().equals(userId)){
			user=(User) session.getAttribute("user");
			user.setUserMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
			return user;
		}
		//如何会话不存在，新会话
			//设置自动登录
			if(loginState.equals("1")){
				user =userService.loadUser(Integer.valueOf(userId));
				user.setUserMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
				session.setAttribute("user", user);
			}
		return user;
	}
	/**
	 * 账户登出
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/loginOut", method = {RequestMethod.GET,RequestMethod.POST})
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
	@RequestMapping(value = "/userImgUpload", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String userImgUpload(@RequestParam("user_file") MultipartFile file,HttpSession session,@RequestParam("user_id")Integer id)  {
			User u=userService.loadUser(id);
			//删除原图片
			String	oldIMGURL=u.getUserImg();
			String userIMG = null;
			 try{
				 if(session.getAttribute("user")!=null){
					 userIMG = FileUploadUtil.FormDataFileUpload(file, session,"/resources/userUpload",id.toString(),oldIMGURL);
					 u.setUserImg(userIMG);
				 }
			}catch (IOException e) {
				e.printStackTrace();
			}
			 userService.updateUser(u);
			 return userIMG;
		}
	/**
	 * 账户修改属性
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */   
	@RequestMapping(value = "/updateUserInfo", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody void updateUser(HttpSession session ,@RequestParam("userId")Integer userId,@RequestParam("userInfoOne") String userInfoOne,@RequestParam("changeValue")String changeValue)  {
		User u=null;
			if(!NumberUtil.isNumeric(String.valueOf(userId))){
			return ;
			}
			u=userService.loadUser(userId);
		
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
	@RequestMapping(value = "/loadUser", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	User loadUser(HttpSession session,@RequestParam("userId")Integer id) {
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
	@RequestMapping(value = {"/browseUser"}, method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	List<User> browseUser(HttpSession session) {
		List<User> list = userService.browseUser();
		session.setAttribute("userList", list);
		return list;
		
	}
	/**
	 * xls
	 * 
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value = {"/browseUserXLS"}, method = {RequestMethod.GET,RequestMethod.POST})
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
	@RequestMapping(value = {"/browseUserPDF"}, method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody PDFView browseUserPDF(HttpSession session,Model model) {
		List<User> list = userService.browseUser();
		model.addAttribute("userList", list);
		pdfView.setFileName("用户信息PDF");
		return pdfView;
		
	}
}
