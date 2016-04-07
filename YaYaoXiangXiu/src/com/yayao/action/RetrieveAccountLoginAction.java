package com.yayao.action;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Member;
import com.yayao.bean.Merchandise;
import com.yayao.mail.MailSenderInfo;
import com.yayao.mail.MyAuthenticator;
import com.yayao.mail.SendMailDemo;
import com.yayao.mail.SimpleMailSender;
import com.yayao.service.CartService;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.service.MerService;
import com.yayao.service.OrderService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;
/**
 * 账户登录
 * @author yy
 *
 */
@Scope("prototype")
@Controller("eetrieveAccountLogin")
public class RetrieveAccountLoginAction extends BaseAction {
	
	@Autowired
	@Qualifier("merService")
	private MerService merService;
	@Autowired
	@Qualifier("memService")
	private MemService memService;
	@Autowired
	@Qualifier("consigneeService")
	private ConsigneeService consigneeService;
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@Autowired
	@Qualifier("exclusiveCustomService")
	private ExclusiveCustomService exclusiveCustomService;
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	
	
	private String loginName;//注册账号
	private String email;//注册邮箱
	private String loginPwd;//新密码
	private String reLoginPwd;//密码确认
	
	
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getReLoginPwd() {
		return reLoginPwd;
	}
	public void setReLoginPwd(String reLoginPwd) {
		this.reLoginPwd = reLoginPwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	/**
	 * 账户找回验证及发送验证至邮箱
	 * @return
	 * @throws Exception
	 */
	public String retrieveAccountLoginMethod() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member mem = memService.RetrieveAccount(loginName,email);
		
		if(mem!=null){
				session.put("retrieveMember", mem);
				SendMailDemo sml=new SendMailDemo();
				String emailSearch=SHAutil.getSHA(mem.getEmail());
				sml.sendMail(emailSearch);
				  return "success";
		 } 
		this.addFieldError("retrieveAccountLoginError","※账户或邮箱错误！");
		return "input";
		
		}
	/**
	 * 验证成功，修改密码
	 * @return
	 * @throws Exception
	 */
	public String retrieveAccountUpdateMethod() throws Exception {
		Map session = ActionContextUtil.getSession();
		Member retrieveMember = (Member) session.get("retrieveMember");
		String emailSearch = ActionContextUtil.getRequest().getParameter("emailSearch");
		if(emailSearch!=null&&emailSearch.equals(SHAutil.getSHA(retrieveMember.getEmail()))){
			
		if(retrieveMember!=null&&retrieveMember.getLoginName().equals(loginName)&&loginPwd.equals(reLoginPwd)
				&&loginPwd.length()>=6&&loginPwd.length()<=16){
			String shalp = SHAutil.getSHA(loginPwd);
			retrieveMember.setLoginPwd(shalp);
			memService.updateMember(retrieveMember);
			session.put("Member", retrieveMember);
			
			
			consigneeService.browseConsignee(retrieveMember);
			exclusiveCustomService.browseExclusiveCustom(retrieveMember);
			//merService.browseCategory();
			cartService.browseCart(retrieveMember);
			orderService.browseOrderMer(retrieveMember);
		    commentService.browseMemCustomComment(retrieveMember);
			commentService.browseMemMerComment(retrieveMember);
			//commentService.browseComment(6,1);
			return "success";
		} 
		this.addFieldError("retrieveAccountUpdateError","※账户或密码验证错误！");
		return "input";
		}else{
			this.addFieldError("retrieveAccountUpdateError","※验证超时或异常错误，请重新验证！");
			return "input";
			
		}
		
	}
	
}