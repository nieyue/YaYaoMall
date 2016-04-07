package com.yayao.action;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


import com.yayao.bean.Member;
import com.yayao.service.MemService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.OnlineStatistics;
import com.yayao.util.SHAutil;

/**
 * 更改账户密码
 * @author yy
 *
 */
@Scope("prototype")
@Controller("changeMem")
public class ChangeMemAction extends BaseAction {
	
	@Autowired
	@Qualifier("memService")
	private MemService memService;
	private String loginPwd;//登录原始密码
	private String newLoginPwd;//修改后的密码
	private String reNewLoginPwd;//修改后的密码
	
	
	
	
	public String getLoginPwd() {
		return loginPwd;
	}



	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}



	public String getNewLoginPwd() {
		return newLoginPwd;
	}



	public void setNewLoginPwd(String newLoginPwd) {
		this.newLoginPwd = newLoginPwd;
	}



	public String getReNewLoginPwd() {
		return reNewLoginPwd;
	}



	public void setReNewLoginPwd(String reNewLoginPwd) {
		this.reNewLoginPwd = reNewLoginPwd;
	}


	//修改密码
	public String changepwd() throws Exception{
		Map session = ActionContextUtil.getSession();
		Member sm = (Member) session.get("Member");
		//Member member=memService.memLogin(sm.getLoginName(), sm.getLoginPwd());
		String shalp = SHAutil.getSHA(loginPwd);
		String newshalp = SHAutil.getSHA(newLoginPwd);
		if(shalp.equals(sm.getLoginPwd())){
			sm.setLoginPwd(newshalp);
			memService.updateMember(sm);
			return SUCCESS;
		}else{
			this.addFieldError("changeLoginPwd", "※输入的账户密码错误！");
			return INPUT;
		}
	}
	

}