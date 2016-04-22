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

import com.yayao.bean.UserLevel;
import com.yayao.service.UserLevelService;
import com.yayao.service.UserService;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class UserLevelServiceImplTest {
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
		session=sessionFactory.openSession();
		System.out.println(session);
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddUserLevel() {
		UserLevel ul=new UserLevel();
		//ul.setLevelName("钻石会员");
		//ul.setFavourable(80);
		//userLevelService.addUserLevel(ul);
	}

	@Test
	public void testUpdateUserLevel() {
		UserLevel ul = userLevelService.loadUserLevel(4);
		System.out.println(ul);
	}

	@Test
	public void testDelUserLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseUserLevel() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadUserLevel() {
		UserLevel ul = userLevelService.loadUserLevel(4);
		System.out.println(ul);
	}

}
