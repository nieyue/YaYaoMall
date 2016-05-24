package com.yayao.controller;

import java.text.ParseException;
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

import com.yayao.bean.Seller;
import com.yayao.messageinterface.SMSInterface;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerchandiseService;
import com.yayao.service.SellerService;
import com.yayao.util.DateUtil;
import com.yayao.util.MyDESutil;
import com.yayao.util.NumberUtil;
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
	@Resource(name = "sellerService")
	private SellerService sellerService;
	
	/**
	 * 手机验证码发送
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/sellerPhoneValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String validCode(@RequestParam("accountName") final String sellerPhone,HttpSession session) throws ParseException {
		if(session.getAttribute("sellerPhoneValidCodeExpire")!=null){
			String sessionvce = session.getAttribute("sellerPhoneValidCodeExpire").toString();
			if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 1)))){//没超过一分钟
			return StatusCode.GetValueByKey(StatusCode.ONE_ASK_ONE);
		}
			
		}		
		
		Integer sellerPhoneValidCode=(int) (Math.random()*9000+1000);
		try {
				SMSInterface.SmsNumSend(String.valueOf(sellerPhoneValidCode), sellerPhone,StatusCode.GetValueByKey(StatusCode.SMS_TEMPLATE_CODE_REG));
		} catch (Exception e) {
			return null;
		} 
		session.setAttribute("sellerPhoneValidCode",sellerPhoneValidCode);
		session.setAttribute("sellerPhoneValidCodeExpire",DateUtil.getCurrentTime());
		return StatusCode.GetValueByKey(StatusCode.SUCCESS);
	}
	/**
	 * 手机验证码验证
	 * 
	 * @param user
	 * @param session
	 * @return
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	@RequestMapping(value = "/chkSellerPhoneValidCode", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	String chkValidCode(@RequestParam("validCode")String sellerPhoneValidCode,HttpSession session) throws NumberFormatException, ParseException {
		if(!NumberUtil.isNumeric(sellerPhoneValidCode)){
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
		}
		if(session.getAttribute("sellerPhoneValidCodeExpire")==null){
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
		}
		String sessionvce = session.getAttribute("sellerPhoneValidCodeExpire").toString();
		if(!(new Date().after(DateUtil.getFirstToSecondsTime(DateUtil.parseDate(sessionvce), 10)))){//没过期
			if(Integer.valueOf(session.getAttribute("sellerPhoneValidCode").toString()).equals(Integer.valueOf(sellerPhoneValidCode))){
				return StatusCode.GetValueByKey(StatusCode.SUCCESS);
			
		}
			return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR);
			
		}
		return StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_EXPIRED);
	}
	/**
	 * 商户手机注册
	 * @param merSeller
	 * @param modelMap
	 * @return
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sellerPhoneRegister", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	Seller merSellerRegister(@ModelAttribute Seller seller,@RequestParam("validCode") String sellerPhoneValidCode, HttpSession session) throws Exception {
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
			String shalp = MyDESutil.getMD5(seller.getSellerPassword());
			seller.setSellerPassword(shalp);
		
		boolean status = sellerService.addSeller(seller);
		if(status){
			//成功则清除validcode
			session.removeAttribute("sellerPhoneValidCodeExpire");
			session.removeAttribute("sellerPhoneValidCode");
			seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
			seller.setSellerToken( MyDESutil.getMD5(seller.getSellerPhone()));//设置token
			session.setAttribute("seller", seller);
			return seller;
		}
		return null;
			}
			seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.VERIFICATION_CODE_ERROR));
			return seller;
		}
		seller.setSellerMsg(StatusCode.GetValueByKey("VERIFICATION_CODE_EXPIRED"));
		
		return seller;
		
	}
	/**
	 * 商户名检查，邮箱和手机
	 * 
	 * @param merSeller
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/chkSellerName", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String sellerNameValid(@RequestParam("accountName") String accountName) {
		boolean state =sellerService.chkLoginName(accountName);
		if (state) {
			return StatusCode.GetValueByKey(StatusCode.SELLER_EXIST);
		}
		return StatusCode.GetValueByKey(StatusCode.SELLER_NOT_EXIST);
	}
	
	/**
	 * 商户手动登录
	 * 
	 * @param merSeller
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sellerLogin", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	Seller sellerLogin(HttpSession session,String sellerName,String sellerPassword) {
		boolean status = sellerService.chkLoginName(sellerName);
		if(status&&sellerPassword!=null){
			String shaup =  MyDESutil.getMD5(sellerPassword);
			Seller seller = sellerService.merSellerLogin(sellerName, shaup);
			if(seller!=null){
				seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
				seller.setSellerToken( MyDESutil.getMD5(sellerName));//设置token
				session.setAttribute("seller", seller);
				return seller;
			}
		}
		
		return null;
		
	}
	/**
	 * 商户自动登录
	 * 
	 * @param merSeller
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/sellerAutoLogin", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody
	Seller sellerAutoLogin(HttpSession session,Integer sellerid,String sellerloginstate,String sellerToken){
		Seller seller=new Seller();
		//如果会话存在
		if(session.getAttribute("seller")!=null&&((Seller)session.getAttribute("seller")).getSellerid().equals(sellerid)){
			seller=(Seller) session.getAttribute("seller");
			seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
			return seller;
		}
		//如何会话不存在，新会话
		if(sellerToken!=null){
			//没有设置自动登录
			if(sellerloginstate.equals("0")){
				seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SESSION_EXPIRED));
				return seller;
			}
			//设置自动登录
			if(sellerloginstate.equals("1")){
			seller =sellerService.loadSeller(Integer.valueOf(sellerid));
			if( MyDESutil.getMD5(seller.getSellerEmail()).equals(sellerToken)|| MyDESutil.getMD5(seller.getSellerPhone()).equals(sellerToken)){
				seller.setSellerMsg(StatusCode.GetValueByKey(StatusCode.SUCCESS));
				session.setAttribute("seller", seller);
			}
			}
		}
		return seller;
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
	public @ResponseBody void sellerLoginOut(HttpSession session) {
		if(session.getAttribute("seller")!=null){
			session.invalidate();
		}
		
	}
	
}