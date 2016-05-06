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
import com.yayao.service.MerSellerService;
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
	@Resource(name = "merSellerService")
	private MerSellerService merSellerService;
	/**
	 * 商户注册
	 * @param user
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sellerEmailRegister", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	MerSeller merSellerRegister(@ModelAttribute MerSeller merSeller,@RequestParam("sellerEmailValidCode") String sellerEmailValidCode, HttpSession session) throws Exception {
		/*
		 * if(result.hasErrors()){
		 * //customer.setContent(result.getFieldError().getDefaultMessage());
		 * return null; }
		 */
		if(!NumberUtil.isNumeric(sellerEmailValidCode)){
			return null;
		}
		if(session.getAttribute("sellerEmailValidCodeExpire")==null){
			return null;
		}
		
		String sessionvce = session.getAttribute("sellerEmailValidCodeExpire").toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute("sellerEmailValidCode").toString()).equals(Integer.valueOf(sellerEmailValidCode))){
			String shalp = SHAutil.getSHA(merSeller.getSellerPassword());
			merSeller.setSellerPassword(shalp);
		
		boolean status = merSellerService.addMerSeller(merSeller);
		session.setAttribute("merSeller", merSeller);
		if(status){
			merSeller.setSellerMsg(StatusCode.SUCESS);
			return merSeller;
		}
		return null;
			}
			merSeller.setSellerMsg(StatusCode.VERIFICATION_CODE_ERROR);
			return merSeller;
		}
		merSeller.setSellerMsg(StatusCode.VERIFICATION_CODE_EXPIRED);
		
		return merSeller;
		
	}
	
	
	
}