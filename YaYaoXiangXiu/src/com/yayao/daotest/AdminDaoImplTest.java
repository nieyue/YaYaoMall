package com.yayao.daotest;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.Admin;
import com.yayao.bean.Comment;
import com.yayao.service.AdminService;
import com.yayao.service.impl.AdminServiceImpl;
import com.yayao.util.SHAutil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class AdminDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {
	//AdminDaoImplTest adt=new AdminDaoImplTest();
	@Autowired
	@Qualifier("adminService")
	AdminService adminService;
	//ApplicationContext context;
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	Session session;
	
	/*@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}*/
	@Before
	public void setUp() throws Exception {
		//context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		//session=sessionFactory.openSession();

		session=sessionFactory.getCurrentSession();
		//session.beginTransaction();
		//adminService=(AdminServiceImpl) context.getBean("adminService");
		
		System.out.println(session);
	}

	@After
	public void tearDown() throws Exception {
	//session.beginTransaction().commit();
	//session.flush();
	//session.clear();
	//session.close();
	}
	@Test
	public void testGetSessionFactory() {
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		
		//session=sessionFactory.getCurrentSession();
		System.out.println(session);
		System.out.println(sessionFactory);
	}

	@Test
	public void testSetSessionFactory() {
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
	
		System.out.println(session);
		System.out.println(sessionFactory);
	}

	@Test
	public void testAdminLogin() throws Exception {
		String p = SHAutil.getSHA("123456");
		Admin admin = adminService.adminLogin("nieyue1", p);
		String n = admin.getAdminName();
		System.out.println(admin);
		System.out.println(n);
	}

	@Test
	public void testAddAdmin() throws Exception {
		//SessionFactory sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		//session=sessionFactory.getCurrentSession();
		Admin admin=new Admin();
		admin.setAdminName("聂跃");
		admin.setAdminType(1);
		admin.setLoginName("nieyue1hh");
		String p = SHAutil.getSHA("123456");
		admin.setLoginPwd(p);
		System.out.println(sessionFactory);
		System.out.println(session);
		 adminService.addAdmin(admin);
	}
	
	
	@Test
	public void testBrowseAdmin() throws Exception {
		
		List list = adminService.browseAdmin();
		System.out.println(list);
		//List list = adminDao.browseAdmin();
		Iterator i=list.iterator();
		while (i.hasNext()) {
			Admin a = (Admin) i.next();
			
			System.out.print(a.getId());
			System.out.print(a.getAdminName());
			System.out.print(a.getLoginName());
			System.out.print(a.getLoginPwd());
			System.out.println(a.getAdminType());
		}
		
		
	}

	@Test
	public void testDelAdmin() throws Exception  {
		
		 adminService.delAdmin(165);
		
			//System.out.println(adminService.loadAdmin(5).getAdminName());
	
	
	}
	@Test
	public void testChkAdminLoginName() throws Exception  {
		
		boolean s = adminService.chkAdminLoginName("nieyue4");
		
		System.out.println(s);
		
	}

	@Test
	public void testLoadAdmin() throws Exception {
		Admin a = adminService.loadAdmin(4);
		String n = a.getAdminName();
		Integer t = a.getAdminType();
		Integer i = a.getId();
		String ln = a.getLoginName();
		String lp = a.getLoginPwd();
		List ll = a.getComments();
		System.out.println(n+" "+t+" "+i+" "+ln+" "+lp+" ");
	
		
//		Admin a1 = adminService.loadAdmin(4);
//		String n1 = a.getAdminName();
//		Integer t1 = a.getAdminType();
//		Integer i1 = a.getId();
//		String ln1 = a.getLoginName();
//		String lp1 = a.getLoginPwd();
//		List ll1 = a.getComments();
//		System.out.println(n1+" "+t1+" "+i1+" "+ln1+" "+lp1+" ");
	}

	@Test
	public void testUpdateAdmin() throws Exception {
		String p = SHAutil.getSHA("123456");
		Admin a=new Admin();
		Admin a1 = adminService.loadAdmin(163);
		System.out.println(a1.getAdminName());
		a.setId(163);
		a.setAdminName("聂跃");
		a.setAdminType(2);
		a.setLoginName("nieyue1233");
		a.setLoginPwd(p);
		
	 adminService.updateAdmin(a);
		
		System.out.println(a.getAdminName());
		
	}

}
