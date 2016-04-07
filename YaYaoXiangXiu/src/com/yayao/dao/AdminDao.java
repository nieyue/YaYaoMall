package com.yayao.dao;

import com.yayao.bean.*;

import java.util.*;

/** 系统用户管理接口 */
public interface AdminDao {

	/** 系统管理员登录 */
	public Admin adminLogin(String loginName,String loginPwd);
	
	/** 检测登录帐号是否有效 */	
	public boolean chkAdminLoginName(String loginName) ;
	/** 浏览管理员 */
	public List browseAdmin() ;	
	/** 装载指定的管理员 */	
	public Admin loadAdmin(Integer id) ;	
	/** 删除指定的管理员 */	
	public void delAdmin(Integer id) ;	
	/** 新增管理员 */	
	public void addAdmin(Admin admin) ;	
	/** 更新管理员 */	
	public void updateAdmin(Admin admin) ;	
}