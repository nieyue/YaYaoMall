package com.yayao.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayao.bean.MerCategory;
import com.yayao.bean.MerSeller;
import com.yayao.bean.User;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerchandiseService;
import com.yayao.util.DateUtil;
import com.yayao.util.NumberUtil;
import com.yayao.util.SHAutil;
import com.yayao.util.StatusCode;
/**
 * 商家控制类
 * 
 * @author yy
 * 
 */
@Scope("prototype")
@Controller("sellerController")
@RequestMapping(value = "/seller")
public class SellerController {
	@Resource(name = "merCategoryService")
	private MerCategoryService merCategoryService;
	@Resource(name = "merchandiseService")
	private MerchandiseService merchandiseService;
	/**
	 * 商户注册
	 * @param user
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/register", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	User merSellerRegister(@ModelAttribute MerSeller merSeller,@RequestParam("validCode") String validCode, HttpSession session) throws Exception {
		/*
		 * if(result.hasErrors()){
		 * //customer.setContent(result.getFieldError().getDefaultMessage());
		 * return null; }
		 */
		/*if(!NumberUtil.isNumeric(validCode)){
			return null;
		}
		if(session.getAttribute("validCodeExpire")==null){
			return null;
		}
		
		String sessionvce = session.getAttribute("validCodeExpire").toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute("validCode").toString()).equals(Integer.valueOf(validCode))){
			String shalp = SHAutil.getSHA(user.getUserPassword());
			user.setUserPassword(shalp);
		
		boolean status = userService.addUser(user);
		session.setAttribute("user", user);
		if(status){
			user.setUserMsg(StatusCode.SUCESS);
			return user;
		}
		return null;
			}
			user.setUserMsg(StatusCode.VERIFICATION_CODE_ERROR);
			return user;
		}
		user.setUserMsg(StatusCode.VERIFICATION_CODE_EXPIRED);
		
		return user;
		*/
		return null;
	}
	
	
	
}