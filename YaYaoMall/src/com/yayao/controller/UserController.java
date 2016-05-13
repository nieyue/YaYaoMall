package com.yayao.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
import com.yayao.mail.SendMailDemo;
import com.yayao.myView.PDFView;
import com.yayao.myView.XLSView;
import com.yayao.service.UserService;
import com.yayao.util.DateUtil;
import com.yayao.util.FileUploadUtil;
import com.yayao.util.NumberUtil;
import com.yayao.util.SHAutil;
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
	String userNameValid(@RequestParam String userName) {
		boolean state = userService.chkLoginName(userName);
		if (state) {
			return StatusCode.GetValueByKey(StatusCode.USER_EXIST);
		}
		return StatusCode.GetValueByKey(StatusCode.USER_NOT_EXIST);
	}
	/**
	 * 邮箱验证码发送
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/userEmailValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String validCode(@RequestParam("userEmail") final String userEmail,@RequestParam("userEmailValidCode") final String userEmailValidCode,HttpSession session) throws ParseException {
		if(session.getAttribute("userEmailValidCodeExpire")!=null){
			String sessionvce = session.getAttribute("userEmailValidCodeExpire").toString();
			if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 1)))){//没超过一分钟
			return StatusCode.GetValueByKey(StatusCode.ONE_ASK_ONE);
		}
			
		}		
		
		try {
			SendMailDemo.sendSafeMail(userEmail,Integer.valueOf(userEmailValidCode));
		} catch (NumberFormatException e) {
			return null;
		} catch (InterruptedException e) {
			return null;
		}
		session.setAttribute("userEmailValidCode",Integer.valueOf(userEmailValidCode));
		session.setAttribute("userEmailValidCodeExpire",DateUtil.getCurrentTime());
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	/**
	 * 邮箱验证码验证
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value = "/chkUserEmailValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String chkValidCode(@RequestParam("userEmailValidCode")String userEmailValidCode,HttpSession session) throws NumberFormatException, ParseException {
		if(!NumberUtil.isNumeric(userEmailValidCode)){
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
		}
		if(session.getAttribute("userEmailValidCodeExpire")==null){
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
		}
		String sessionvce = session.getAttribute("userEmailValidCodeExpire").toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute("userEmailValidCode").toString()).equals(Integer.valueOf(userEmailValidCode))){
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
	@RequestMapping(value = "/userEmailRegister", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	User userRegister(@ModelAttribute User user,@RequestParam("userEmailValidCode") String userEmailValidCode, HttpSession session) throws Exception {
		/*
		 * if(result.hasErrors()){
		 * //customer.setContent(result.getFieldError().getDefaultMessage());
		 * return null; }
		 */
		if(!NumberUtil.isNumeric(userEmailValidCode)){
			return null;
		}
		if(session.getAttribute("userEmailValidCodeExpire")==null){
			return null;
		}
		
		String sessionvce = session.getAttribute("userEmailValidCodeExpire").toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute("userEmailValidCode").toString()).equals(Integer.valueOf(userEmailValidCode))){
			String shalp = SHAutil.getSHA(user.getUserPassword());
			user.setUserPassword(shalp);
		
		boolean status = userService.addUser(user);
		session.setAttribute("user", user);
		if(status){
			//成功则清除validcode
			session.removeAttribute("userEmailValidCodeExpire");
			session.removeAttribute("userEmailValidCode");
			user.setUserMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
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
	User login(HttpSession session,String userName,String userPassword) throws Exception {
		boolean status = userService.chkLoginName(userName);
		if(status&&userPassword!=null){
			String shaup = SHAutil.getSHA(userPassword);
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
	@RequestMapping(value = "/userIMGUpload", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String userIMGUpload(@RequestParam("userFile") MultipartFile file,HttpSession session,@RequestParam("userid")Integer id)  {
			User u=userService.loadUser(id);
			//删除原图片
			String oldIMGURL="";
			oldIMGURL=u.getUserIMG();
			String userIMG = "";
			 try{
				 userIMG = FileUploadUtil.FormDataFileUpload(file, session,"/resources/userUpload",oldIMGURL);
				u.setUserIMG(userIMG);
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
	@RequestMapping(value = "/loadUser", method = {RequestMethod.GET,RequestMethod.POST})
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
