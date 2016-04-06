package com.yayao.service.impl.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.yayao.bean.User;
import com.yayao.service.UserService;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class UserServiceImplTest {
	@Autowired
	@Qualifier("userService")
	UserService userService;
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		session=sessionFactory.openSession();
		System.out.println(session);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testChkLoginName() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		User user =new User();
		user.setIntegral(new Integer(1));
		user.setUserName("聂跃");
		user.setUserPassword("123456");
		System.out.println("dsf");
		userService.addUser(user);
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdminBrowseUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseUserLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadUserLevel() {
		fail("Not yet implemented");
	}

}
