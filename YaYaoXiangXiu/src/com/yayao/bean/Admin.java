package com.yayao.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理员类
 * @author yy
 *
 */

public class Admin implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 管理员类型
	 */
	private Integer adminType;
	/**
	 * 管理员姓名
	 */
	private String adminName;
	/**
	 * 登陆名
	 */
	private String loginName;
	/**
	 * 登陆密码
	 */
	private String loginPwd;
	/**
	 * 评论
	 */
	private List comments=new ArrayList();
	
	public Admin() {
	}

	
	public Admin(Integer adminType, String adminName, String loginName,
			String loginPwd, List comments) {
		this.adminType = adminType;
		this.adminName = adminName;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.comments=comments;
	}

	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdminType() {
		return this.adminType;
	}

	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}


	public List getComments() {
		return comments;
	}


	public void setComments(List comments) {
		this.comments = comments;
	}
	
	
}