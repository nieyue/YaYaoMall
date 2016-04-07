package com.yayao.action;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.opensymphony.xwork2.ActionContext;
import com.yayao.bean.Admin;
import com.yayao.bean.Member;
import com.yayao.service.AdminService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;


/**
 * 管理员登录、退出
 * @author yy
 *
 */
@Scope("prototype")
@Controller("adminLogin")
public class AdminLoginAction extends BaseAction{
	
	@Resource(name="adminService")
	private AdminService adminService;
	
	private String ht_loginName;//登陆账号
	private String ht_loginPwd;//登陆密码
	private String ht_validate;	//验证码



	
	public String getHt_loginName() {
		return ht_loginName;
	}

	public void setHt_loginName(String ht_loginName) {
		this.ht_loginName = ht_loginName;
	}

	public String getHt_loginPwd() {
		return ht_loginPwd;
	}

	public void setHt_loginPwd(String ht_loginPwd) {
		this.ht_loginPwd = ht_loginPwd;
	}

	public String getHt_validate() {
		return ht_validate;
	}

	public void setHt_validate(String ht_validate) {
		this.ht_validate = ht_validate;
	}

	/**
	 * 系统管理员登陆
	 * @return
	 * @throws Exception
	 */
	public String ht_login() throws Exception {
		Map session = ActionContextUtil.getSession();
		String ht_shalp = SHAutil.getSHA(ht_loginPwd);
		
		boolean status=adminService.chkAdminLoginName(ht_loginName);
		if(status){
			
			Admin a = adminService.adminLogin(ht_loginName,ht_shalp);
			if(a!=null&&!a.equals("")&&a.getAdminName()!=null){
				
			session.put("Admin", a);
			int at = a.getAdminType();
			//系统管理员
			if(at==4){
				return "xitong";
			}
			//订单管理员
			else if(at==3){
				
				return "dingdan";
			}
			//会员管理员
			else if(at==2){
				
				return "huiyuan";
			}
			//商品管理员
			else if(at==1){
				
				return "shangpin";
			}
			}
			this.addFieldError("adminloginerror", "※账号或密码错误！");
			return "input";
		}else{ 
			this.addFieldError("adminloginerror", "※账号或密码错误！");
			return "input";
			}
	}
	/**
	 * 系统管理员退出
	 * @return
	 * @throws Exception
	 */
	   @SkipValidation
		public String ht_logout() throws Exception{
			Map session = ActionContextUtil.getSession();
			Admin a = (Admin) session.get("Admin");
			if(a!=null){
				session.remove("Admin");
				session.clear();
				return null;
			}else{
				return null;
			}
			
		}
	/**
	 * 验证码
	 */
	public void validate() {
		Map session = ActionContextUtil.getSession();
		if(!session.get("random").equals(ht_validate)) {
			this.addFieldError("ht_validate", "※验证码错误！");
		}
	}

	
}