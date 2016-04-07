package com.yayao.action;

import java.util.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.metal.MetalBorders.Flush3DBorder;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;


import com.yayao.bean.Member;
import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.MemService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.OnlineStatistics;
import com.yayao.util.SHAutil;
/**
 * 账户登录退出
 * @author yy
 *
 */
@Scope("prototype")
@Controller("memLogout")
public class MemLogoutAction extends BaseAction {
	
	@Autowired
	@Qualifier("memService")
	private MemService memService;

	
	/**
	 * 用户退出登录
	 * @return
	 * @throws Exception
	 */
	public String logout() throws Exception{
		Map session = ActionContextUtil.getSession();
		Member sm = (Member) session.get("Member");
			Member member = memService.loadMember(sm.getId());
			member.setIsLogin(0);//设置0表示没登录
			memService.updateMember(member);
			session.put("Member", member);
			session.remove("Member");
			session.clear();
			
			return "success";
	}

}