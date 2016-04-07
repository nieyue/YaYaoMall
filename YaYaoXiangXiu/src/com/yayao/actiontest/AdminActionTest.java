package com.yayao.actiontest;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionProxy;
import com.yayao.action.AdminLoginAction;
import com.yayao.bean.Admin;
import com.yayao.service.AdminService;
import com.yayao.service.impl.AdminServiceImpl;



public class AdminActionTest extends StrutsSpringTestCase {
	AdminService adminService;
    ApplicationContext context;
	private ActionProxy proxy;  
	AdminLoginAction adminAction;
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		adminService=(AdminServiceImpl) context.getBean("adminService");
	}	
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testGetHt_loginName() {
		proxy=this.getActionProxy("/adminHt_login.action");
		adminAction=(AdminLoginAction) proxy.getAction();
		adminAction.setHt_loginName("涅羽");
		String htloginname = adminAction.getHt_loginName();
		this.assertEquals("涅羽", htloginname);
	}

	@Test
	public void testSetHt_loginName() {
		proxy=this.getActionProxy("/adminHt_login.action");
		adminAction=(AdminLoginAction) proxy.getAction();
	}

	@Test
	public void testGetHt_loginPwd() {
		proxy=this.getActionProxy("/adminHt_login.action");
		adminAction=(AdminLoginAction) proxy.getAction();
		adminAction.setHt_loginPwd("123456");
		String htloginpwd = adminAction.getHt_loginPwd();
		this.assertEquals("123456", htloginpwd);
	}

	@Test
	public void testSetHt_loginPwd() {
		fail("Not yet implemented");
	}
	

	@Test
	public void testGetHt_validate() {
		proxy=this.getActionProxy("/adminHt_login.action");
		adminAction=(AdminLoginAction) proxy.getAction();
		adminAction.setHt_validate("验证");
		String htvalidate = adminAction.getHt_validate();
		this.assertEquals("验证", htvalidate);
		
	}

	@Test
	public void testSetHt_validate() {
		fail("Not yet implemented");
	}

	@Test
	public void testHt_login() throws Exception {
		proxy=this.getActionProxy("/adminHt_login.action");
		adminAction=(AdminLoginAction) proxy.getAction();
		
		adminAction.setHt_loginName("nieyue");
		adminAction.setHt_loginPwd("123456");
		String htlogin = adminAction.ht_login();
		System.out.println(htlogin);
		this.assertEquals("success", htlogin);
	}

	@Test
	public void testHt_validate() {
		proxy=this.getActionProxy("/adminHt_login.action");
		adminAction=(AdminLoginAction) proxy.getAction();
		 adminAction.validate();
	}

}
