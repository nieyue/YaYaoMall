package com.yayao.bean;

import java.util.*;

/**
 *会员类
 * @author yy
 *
 */
public class Member implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 会员主键
	 */
	private Integer id;
	/**
	 * 会员等阶
	 */
	private Memberlevel memberlevel;
	/**
	 * 登录账号
	 */
	private String loginName;
	/**
	 * 登录密码
	 */
	private String loginPwd;
	/**
	 * 真实姓名
	 */
	private String memberName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 注册日期
	 */
	private String regDate;
	/**
	 * 最近一次登陆时间
	 */
	private String lastDate;
	/**
	 * 登陆次数
	 */
	private Integer loginTimes;
	/**
	 * 是否登录1为登录
	 */
	private Integer isLogin;
	/**
	 * 订单
	 */
	private Set orders = new HashSet();
	/**
	 * 收货人
	 */
	private List consignees=new ArrayList();
	/**
	 * 评论
	 */
	private List comments=new ArrayList();
	
	/**
	 * 专属定制
	 */
	private Set exclusiveCustoms=new HashSet();
	


	public Member() {
		
	}

	

	public Member(Integer id,Memberlevel memberlevel, String loginName, String loginPwd,
			String memberName, String sex, String email, String regDate, String lastDate,
			Integer loginTimes,Integer isLogin, Set orders, List consignees, List comments, Set exclusiveCustoms) {
		super();
		this.id = id;
		this.memberlevel=memberlevel;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.memberName = memberName;
		this.sex=sex;
		this.email = email;
		this.regDate = regDate;
		this.lastDate = lastDate;
		this.loginTimes = loginTimes;
		this.isLogin=isLogin;
		this.orders = orders;
		this.consignees=consignees;
		this.comments=comments;
		this.exclusiveCustoms=exclusiveCustoms;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getRegDate() {
		return regDate;
	}



	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}



	public String getLastDate() {
		return lastDate;
	}



	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}



	public Integer getLoginTimes() {
		return loginTimes;
	}



	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}



	public Set getOrders() {
		return orders;
	}



	public void setOrders(Set orders) {
		this.orders = orders;
	}



	public List getConsignees() {
		return consignees;
	}



	public void setConsignees(List consignees) {
		this.consignees = consignees;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getIsLogin() {
		return isLogin;
	}
	
	
	
	public void setIsLogin(Integer isLogin) {
		this.isLogin = isLogin;
	}



	public Memberlevel getMemberlevel() {
		return memberlevel;
	}



	public void setMemberlevel(Memberlevel memberlevel) {
		this.memberlevel = memberlevel;
	}



	public List getComments() {
		return comments;
	}



	public void setComments(List comments) {
		this.comments = comments;
	}
	
	public Set getExclusiveCustoms() {
		return exclusiveCustoms;
	}
	
	
	
	public void setExclusiveCustoms(Set exclusiveCustoms) {
		this.exclusiveCustoms = exclusiveCustoms;
	}


	
	
}
