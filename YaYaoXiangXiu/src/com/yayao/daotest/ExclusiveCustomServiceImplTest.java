package com.yayao.daotest;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yayao.bean.Consignee;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Member;
import com.yayao.service.ConsigneeService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.service.impl.ConsigneeServiceImpl;
import com.yayao.service.impl.MemServiceImpl;
import com.yayao.util.DateUtil;

public class ExclusiveCustomServiceImplTest {
	MemService memService;
	ExclusiveCustomService exclusiveCustomService;
	ApplicationContext context;
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		session=sessionFactory.openSession();

		//session.beginTransaction();
		exclusiveCustomService=  (ExclusiveCustomService) context.getBean("exclusiveCustomService");
		memService=(MemServiceImpl) context.getBean("memService");
				
		System.out.println(session);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddExclusiveCustom() throws Exception {
		ExclusiveCustom ec=new ExclusiveCustom();
		ec.setCustomName("聂跃1");
		ec.setCustomCategory("湘绣");
		ec.setCustomDate(DateUtil.getCurrentTime());
		ec.setCustomPhone("15111336587");
		ec.setCustomDetails("生命之泉");
		ec.setCustomPicture("/customPicture/55.jpg");
		ec.setCustomOrderNumber(DateUtil.getOrdersTime());
		Member m = memService.loadMember(1);
		ec.setMember(m);
		//c.setMember(3);
		//System.out.println(sessionFactory);
		//System.out.println(session);
		exclusiveCustomService.addExclusiveCustom(ec);
		
	}

	@Test
	public void testUpdateExclusiveCustom() throws Exception {
		ExclusiveCustom ex = exclusiveCustomService.loadExclusiveCustom(3);
		System.out.println();
		System.out.println(ex);
		 exclusiveCustomService.updateExclusiveCustom(ex);
		
		System.out.println(ex);
	}

	@Test
	public void testBrowseExclusiveCustom() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelExclusiveCustom() throws Exception {
		ExclusiveCustom ex = exclusiveCustomService.loadExclusiveCustom(2);
		System.out.println(ex);
		System.out.println(ex);
		 exclusiveCustomService.delExclusiveCustom(ex.getId());
		
		System.out.println(ex);
	}

	@Test
	public void testLoadExclusiveCustom() {
		fail("Not yet implemented");
	}

}
