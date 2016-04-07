package com.yayao.daotest;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yayao.bean.Consignee;
import com.yayao.bean.Member;
import com.yayao.service.ConsigneeService;
import com.yayao.service.MemService;
import com.yayao.service.impl.ConsigneeServiceImpl;
import com.yayao.service.impl.MemServiceImpl;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.SHAutil;





public class ConsigneeServiceImplTest {
	MemService memService;
	ConsigneeService consigneeService;
	ApplicationContext context;
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		session=sessionFactory.openSession();

		//session.beginTransaction();
		consigneeService=  (ConsigneeServiceImpl) context.getBean("consigneeService");
		memService=(MemServiceImpl) context.getBean("memService");
				
		System.out.println(session);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddConsignee() throws Exception {
		Consignee c=new Consignee();
		c.setReceiptName("聂跃1");
		c.setAddress("湖南长沙岳麓区1");
		c.setZip("415000");
		c.setTelePhone("15111336587");
		c.setCellPhone("15111336587");
		Member m = memService.loadMember(1);
		c.setMember(m);
		//c.setMember(3);
		System.out.println(sessionFactory);
		System.out.println(session);
		consigneeService.addConsignee(c);
		
	}

	@Test
	public void testUpdateConsignee() throws Exception {
		Consignee m=new Consignee();
		Consignee m1 = consigneeService.loadConsignee(2);
		System.out.println(m1.getReceiptName());
		m.setId(2);
		m.setReceiptName("地方1");
		m.setAddress("发的地方的发给对方说的 ");
		m.setCellPhone("343434");
		m.setTelePhone("324324234");
		m.setZip("454433");
		Member member = memService.loadMember(1);
		m.setMember(member);
		 consigneeService.updateConsignee(m);
		
		System.out.println(m1.getReceiptName());
		
	}

	@Test
	public void testBrowseConsignee() throws Exception {
		Member member = (Member) ActionContextUtil.getSession().get("Member");
		List list = consigneeService.browseConsignee(member);
		Iterator i=list.iterator();
		while (i.hasNext()) {
			Consignee a = (Consignee) i.next();
			
			System.out.println(a.getId());
			System.out.println(a.getReceiptName());
			System.out.println(a.getTelePhone());
			System.out.println(a.getCellPhone());
			System.out.println(a.getAddress());
			System.out.println(a.getZip());
			System.out.println(a.getMember());
			System.out.println(a.getMember().getId());
		}
	}

	@Test
	public void testDelConsignee() throws Exception {
		consigneeService.delConsignee(2);
		System.out.println(consigneeService.loadConsignee(2).getReceiptName());
	}

	@Test
	public void testLoadConsignee() throws Exception {
		Consignee a = consigneeService.loadConsignee(2);
		String rn = a.getReceiptName();
		String z = a.getZip();
		String ad=a.getAddress();
		Integer i = a.getId();
		String tp = a.getTelePhone();
		String cp = a.getCellPhone();
		 Member n = a.getMember();
		System.out.println(rn+" "+z+" "+i+" "+ad+" "+cp+" "+n.getId());
	}

}
