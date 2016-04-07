package com.yayao.action;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


import com.yayao.bean.Member;
import com.yayao.service.MemService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;
/**
 * 账户注册，
 * @author yy
 *
 */
@Scope("prototype")
@Controller("memReg")
public class MemRegAction extends BaseAction {
	
	@Autowired
	@Qualifier("memService")
	private MemService memService;
	private String loginName;//注册账号
	private String loginPwd;//注册密码
	private String reLoginPwd;//重复密码
	private String email;
	private String validate;	//验证码
	
	

	public MemService getMemService() {
		return memService;
	}
	public void setMemService(MemService memService) {
		this.memService = memService;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
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
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	//注册
	public String reg() throws Exception{
		String shalp = SHAutil.getSHA(loginPwd);
		boolean state= memService.chkLoginName(loginName);
		if(state){
			this.addFieldError("regerror","※用户已经存在，请您重新注册！");
			return "input";
		}else{
			Member m=new Member();
			m.setLoginName(loginName);
			m.setLoginPwd(shalp);
			m.setEmail(email);
			//Map application = ActionContextUtil.getApplication();
			Map session = ActionContextUtil.getSession();
			session.put("Member", m);
			memService.addMember(m);
			//登录
			//Member m1 = memService.memLogin(loginName, shalp);
			//List list=new ArrayList();
			
			//list.add(m1.getId());
			//application.put("appMember", list);
			memService.memLogin(loginName,shalp);
			return "success";
		}
		}
	//验证码
	public void validate() {
		Map session = ActionContextUtil.getSession();
		if(!session.get("random").equals(validate)) {
			this.addFieldError("validate", "※验证码错误！");
		}
	}

}