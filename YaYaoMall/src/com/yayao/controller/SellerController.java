package com.yayao.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yayao.bean.MerSeller;
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
	 * 商户手机注册
	 * @param merSeller
	 * @param modelMap
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sellerPhoneRegister", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	MerSeller merSellerRegister(@ModelAttribute MerSeller merSeller,@RequestParam("sellerPhoneValidCode") String sellerPhoneValidCode, HttpSession session) throws Exception {
		/*
		 * if(result.hasErrors()){
		 * //customer.setContent(result.getFieldError().getDefaultMessage());
		 * return null; }
		 */
		if(!NumberUtil.isNumeric(sellerPhoneValidCode)){
			return null;
		}
		if(session.getAttribute("sellerPhoneValidCodeExpire")==null){
			return null;
		}
		
		String sessionvce = session.getAttribute("sellerPhoneValidCodeExpire").toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute("sellerPhoneValidCode").toString()).equals(Integer.valueOf(sellerPhoneValidCode))){
			String shalp = SHAutil.getSHA(merSeller.getSellerPassword());
			merSeller.setSellerPassword(shalp);
		
		boolean status = merSellerService.addMerSeller(merSeller);
		session.setAttribute("merSeller", merSeller);
		if(status){
			//成功则清除validcode
			session.removeAttribute("sellerPhoneValidCodeExpire");
			session.removeAttribute("sellerPhoneValidCode");
			merSeller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
			return merSeller;
		}
		return null;
			}
			merSeller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR));
			return merSeller;
		}
		merSeller.setSellerMsg(StatusCode.GetValueByKey("VERIFICATION_CODE_EXPIRED"));
		
		return merSeller;
		
	}
	/**
	 * 商户名检查，邮箱和手机
	 * 
	 * @param merSeller
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/chkSellerName", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String userNameValid(@RequestParam String sellerName) {
		boolean state = merSellerService.chkLoginName(sellerName);
		if (state) {
			return StatusCode.GetValueByKey(StatusCode.SELLER_EXIST);
		}
		return StatusCode.GetValueByKey(StatusCode.SELLER_NOT_EXIST);
	}
	
	/**
	 * 商户登录
	 * 
	 * @param merSeller
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sellerLogin", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	MerSeller sellerLogin(HttpSession session,String sellerName,String sellerPassword) throws Exception {
		boolean status = merSellerService.chkLoginName(sellerName);
		if(status&&sellerPassword!=null){
			String shaup = SHAutil.getSHA(sellerPassword);
			MerSeller seller = merSellerService.merSellerLogin(sellerName, shaup);
			if(seller!=null){
				seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
				session.setAttribute("merSeller", seller);
				return seller;
			}
		}
		
		return null;
		
	}
	/**
	 * 商户登出
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sellerLoginOut", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody void sellerLoginOut(HttpSession session) throws Exception {
		if(session.getAttribute("merSeller")!=null){
			session.invalidate();
		}
		
	}
	
}