package com.yayao.action;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
 * 基本信息及更改
 * @author yy
 *
 */
@Scope("prototype")
@Controller("memInformation")
public class MemInformationAction extends BaseAction {
	
	@Autowired
	@Qualifier("memService")
	private MemService memService;
	private String email;//电子邮件
	private String memberName;//真实姓名
	private String sex;//性别
	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




	public String getMemberName() {
		return memberName;
	}




	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}




	public String getSex() {
		return sex;
	}




	public void setSex(String sex) {
		this.sex = sex;
	}


	//基本信息更改保存
	public String changeinformation() throws Exception{
		Map session = ActionContextUtil.getSession();
		Member sm = (Member) session.get("Member");
		//Member member=memService.memLogin(sm.getLoginName(), sm.getLoginPwd());
		sm.setEmail(email);
		sm.setMemberName(memberName);
		if(sex==""||sex==null){
		sm.setSex(memService.loadMember(sm.getId()).getSex());
		}else{
			sm.setSex(sex);
		}
		memService.updateMember(sm);
		return SUCCESS;
	}
	

}