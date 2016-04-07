package com.yayao.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;





import com.yayao.bean.Admin;
import com.yayao.service.AdminService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseAction;
import com.yayao.util.SHAutil;


/**
 * 管理员增加，删除，查询
 * @author yy
 *
 */
@Scope("prototype")
@Controller("adminManager")
public class AdminManagerAction extends BaseAction{
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;
	
	private String ht_adminName;//管理员名字
	private String ht_adminType;//管理员类型
	private String ht_loginName;//登陆账号
	private String ht_loginPwd;//登陆密码
	

	
	public String getHt_adminName() {
		return ht_adminName;
	}
	public void setHt_adminName(String ht_adminName) {
		this.ht_adminName = ht_adminName;
	}
	public String getHt_adminType() {
		return ht_adminType;
	}
	public void setHt_adminType(String ht_adminType) {
		this.ht_adminType = ht_adminType;
	}
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
	/**
	 * 增加管理员
	 * @return
	 * @throws Exception
	 */
	
	public String ht_addAdmin() throws Exception {
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin)session.get("Admin");
		
		if(ht_loginPwd==null||ht_loginPwd.equals("")||ht_loginName==null||ht_loginName.equals("")){
			this.addFieldError("ht_addAdminError", "※添加失败，请检查输入是否有误！");
			return "input";
		}
		//检查添加的账户是否已经存在
		boolean status=adminService.chkAdminLoginName(ht_loginName);
		if(!status&&a.getAdminType().equals(4)){
		String ht_lp = SHAutil.getSHA(ht_loginPwd);
		Admin admin=new Admin();
		admin.setAdminName(ht_adminName);
		if(ht_adminType.equals("商品管理员")){
			
		admin.setAdminType(new Integer(1));
		}
		else if(ht_adminType.equals("会员管理员")){
			admin.setAdminType(new Integer(2));
			
		}
		else if(ht_adminType.equals("订单管理员")){
			admin.setAdminType(new Integer(3));
			
		}
		else if(ht_adminType.equals("系统管理员")){
			admin.setAdminType(new Integer(4));
			
		}
		else{
			this.addFieldError("ht_addAdminError", "※添加失败，请检查输入是否有误！");
			return "input";
		}
		admin.setLoginName(ht_loginName);
		admin.setLoginPwd(ht_lp);
		adminService.addAdmin(admin);
		adminService.browseAdmin();
		return "success";
		}else{
			this.addFieldError("ht_addAdminError", "※用户已经存在，请您重新添加！");
			return "input";
		}
	}
	/**
	 * 删除管理员
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_delAdmin() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String hln = ActionContextUtil.getRequest().getParameter("hln");
		if(a!=null&&a.getAdminType().equals(4)){
			List list=adminService.browseAdmin();
			for (int i = 0; i < list.size(); i++) {
				Admin admin=(Admin)list.get(i);
				if(admin.getLoginName().equals(hln)){
					adminService.delAdmin(admin.getId());
					adminService.browseAdmin();
					return null;
				}
			}
		}
		return null;
	}
	/**
	 * 批量删除管理员
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_delAllAdmin() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		Integer adiid=null;
		//获取索引
		String adminDelIndexs = ActionContextUtil.getRequest().getParameter("delIndexs");
		if(adminDelIndexs!=null&&!adminDelIndexs.equals("")){
			
		String[] adi=adminDelIndexs.split(",");
		for (int i = 0; i < adi.length; i++) {
			adiid=new Integer(adi[i]);
		if(a!=null&&a.getAdminType().equals(4)){
		
					adminService.delAdmin(adiid);
				}
			}
		}
		adminService.browseAdmin();
		
		return null;
	}
	 
	/**
	 * 更改管理员
	 * @return
	 * @throws Exception
	 */
	public String ht_modifyAdmin() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		//获取索引
		String aaa = ActionContextUtil.getRequest().getParameter("aaa");
		if(ht_loginPwd==null||ht_loginPwd.equals("")||ht_loginName==null||ht_loginName.equals("")){
			this.addFieldError("ht_addAdminError", "※添加失败，请检查输入是否有误！");
			return "input";
		}
		if(a!=null&&a.getAdminType()==4){
			List list=adminService.browseAdmin();
			for (int i = 0; i < list.size(); i++) {
				Admin admin=(Admin)list.get(i);
				if(admin.getLoginName().equals(aaa)){
					admin.setAdminName(ht_adminName);
					if(ht_adminType.equals("商品管理员")){
						
						admin.setAdminType(new Integer(1));
						}
						else if(ht_adminType.equals("会员管理员")){
							admin.setAdminType(new Integer(2));
							
						}
						else if(ht_adminType.equals("订单管理员")){
							admin.setAdminType(new Integer(3));
							
						}
						else if(ht_adminType.equals("系统管理员")){
							admin.setAdminType(new Integer(4));
							
						}
						else{
							this.addFieldError("ht_addAdminError", "※添加失败，请检查输入是否有误！");
							return "input";
						}
					admin.setLoginName(ht_loginName);
					String ht_lp = SHAutil.getSHA(ht_loginPwd);
					admin.setLoginPwd(ht_lp);
					
					adminService.updateAdmin(admin);
					adminService.browseAdmin();
					return "success";
				}
			}
		}
		return "input";
	}
	/**
	 * 浏览管理员
	 * @return
	 * @throws Exception
	 */
	@SkipValidation
	public String ht_browseAdmin() throws Exception{
		Map session = ActionContextUtil.getSession();
		Admin a = (Admin) session.get("Admin");
		if(a!=null&&a.getAdminType()==4){
			adminService.browseAdmin();
			return "success";	
		}
		return "input";
	}
	
	
}