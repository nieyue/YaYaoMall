package com.yayao.actiontest;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionProxy;
import com.yayao.action.MemLoginAction;
import com.yayao.service.MemService;
import com.yayao.service.impl.MemServiceImpl;

public class MemLoginActionTest extends StrutsSpringTestCase{

	  MemService memService;
	    ApplicationContext context;
		private ActionProxy proxy;  
		MemLoginAction memLoginAction;
	@Before
	protected void setUp() throws Exception {
		super.setUp();
			context=new ClassPathXmlApplicationContext("applicationContext.xml");
			memService=(MemServiceImpl) context.getBean("memService");
	}	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testValidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMemService() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMemService() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLoginName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLoginName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLoginPwd() {
		proxy=this.getActionProxy("/memLogout.action");
		memLoginAction=(MemLoginAction) proxy.getAction();
		memLoginAction.setLoginPwd("n123456");
		String loginPwd=memLoginAction.getLoginPwd();
		this.assertEquals("n123456", loginPwd);
		System.out.println(loginPwd);
	}

	@Test
	public void testSetLoginPwd() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetValidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() throws Exception {
		proxy=this.getActionProxy("/memLogin.action");
		memLoginAction=(MemLoginAction) proxy.getAction();
	    memLoginAction.setLoginName("nieyue");
	    memLoginAction.setLoginPwd("n123456");
		String login = memLoginAction.login();
		System.out.println(login);
		this.assertEquals("success", login);
	}

	
}
