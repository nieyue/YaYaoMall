package com.yayao.service.impl.test;

import static org.junit.Assert.fail;

import java.util.List;

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
import com.yayao.bean.UserLevel;
import com.yayao.service.UserLevelService;
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
	@Qualifier("userLevelService")
	UserLevelService userLevelService;
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	
	@Before
	public void setUp() throws Exception {
		//session=sessionFactory.openSession();
		//session=sessionFactory.getCurrentSession();
	}
	@After
	public void tearDown() throws Exception {
		//session=sessionFactory.getCurrentSession();
		//System.out.println(sessionFactory.getCurrentSession().isOpen());
		
	}

	@Test
	public void testUserLogin() {
		User user = userService.userLogin("聂跃2", "123456");
		System.out.println(user);
	}

	@Test
	public void testChkLoginName() {
		 boolean status = userService.chkLoginName("151113365");
		 //boolean status = userService.chkLoginName("278076304@qq.com");
		// Assert.assertEquals(true, status);;
		 System.out.println(status);
	}

	@Test
	public void testRetrieveAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddUser() {
		UserLevel userlevel=userLevelService.loadUserLevel(1);
		User user =new User();
		user.setUserLevel(userlevel);
		user.setIntegral(new Integer(1));
		String [] imgs={"http://www.baidu.com","http://www.yayao8.com"};
		
		user.setUserEmail("278076304@dd.dd");
		user.setUserPassword("123456");
		System.out.println("dsf");
		userService.addUser(user);
	}

	@Test
	public void testUpdateUser() {
		User u = userService.loadUser(9);
		//User u=new User();
		//u.setUserid(9);
		//UserLevel ul = userService.loadUserLevel(1);
		//ul=null;
		//u.setUserLevel(ul);
		u.setUserIMG("1saf23.jpg");
		userService.updateUser(u);
	}

	@Test
	public void testSearchUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseUser() {
		List<User> l = userService.browseUser();
		System.out.println(l);
		List<User> l2 = userService.browseUser();
		System.out.println(l2);
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
		
		User u = userService.loadUser(1);
		//u.setUserEmail("123456");
		//userService.addUser(u);
		
		User u2 = userService.loadUser(1);
		//u2.setUserEmail("1234567");
		// userService.updateUser(u);
		//List<User> l = userService.browseUser();
		//List<User> l2 = userService.browseUser();
		User u22 = userService.loadUser(1);
		System.out.println(u.getUserEmail());
		//System.out.println(l);
		System.out.println(u2);
		//System.out.println(l2);
		System.out.println(u22);
	}

}
