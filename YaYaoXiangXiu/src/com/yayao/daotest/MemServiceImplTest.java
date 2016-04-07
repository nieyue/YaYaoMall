package com.yayao.daotest;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

import com.yayao.bean.Admin;
import com.yayao.bean.Member;
import com.yayao.bean.Memberlevel;
import com.yayao.service.MemService;
import com.yayao.service.impl.MemServiceImpl;
import com.yayao.util.SHAutil;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class MemServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	@Qualifier("memService")
	MemService memService;
	//ApplicationContext context;
	
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		//context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		session=sessionFactory.openSession();

		//session.beginTransaction();
		//memService=(MemServiceImpl) context.getBean("memService");
				
		System.out.println(session);
	
	}

	@After
	public void tearDown() throws Exception {
//		session.flush();
//		session.clear();
//		session.close();
	}

	@Test
	public void testAddMember() throws Exception {
		Member member=new Member();
		member.setMemberName("聂跃aaa");
		//member.setAddress("湖南长沙岳麓区");
		member.setLoginName("nieyue2016");
		String p = SHAutil.getSHA("123456");
		member.setLoginPwd(p);
		member.setEmail("278076304@qq.com");
		//member.setZip("415000");
		//member.setLastDate(new Date());
		member.setSex("男");
		Memberlevel ml=memService.loadMemberLevel(1);
		member.setMemberlevel(ml);
		
		//member.setReceiptName("张三");
		//member.setTelePhone("15111336587");
		//member.setCellPhone("15111336587");
		//member.setRegDate(new Date());
		/*Set orders = new HashSet();
		orders.add("陶瓷");
		orders.add("湘绣");
		member.setOrders(orders);*/
		System.out.println(sessionFactory);
		System.out.println(session);
		 memService.addMember(member);
		
	}

	@Test
	public void testChkLoginName() throws Exception {
		//String p=SHAutil.getSHA("123456");
		boolean status1 = memService.chkLoginName("nieyue2016");
		boolean status2 = memService.chkLoginName("sdf");
		if(status1){
		System.out.println(status1);
		}
		if(status2){System.out.println(status2);
	}
		}

	@Test
	public void testMemLogin() throws Exception {
		String p = SHAutil.getSHA("123456");
		boolean s = memService.chkLoginName("nieyue2016");
		Member m = memService.memLogin("nieyue2016",p );
		//String n = m.getLoginName();
		//String ld = m.getLastDate();
		//Integer lt = m.getLoginTimes();
		//System.out.println(n);
		//System.out.println(ld);
		//System.out.println(lt);
		System.out.println(m.getClass());
		
		System.out.println(s);
		System.out.println(m);
	}

	@Test
	public void testUpdateMember() throws Exception {
		String p = SHAutil.getSHA("123456");
		
		Member m1 = memService.loadMember(58);
		System.out.println(m1.getSex());
		Memberlevel m2=memService.loadMemberLevel(1);
		m1.setId(m1.getId());
		m1.setMemberlevel(m2);
		//m1.setEmail("324543534@qq.com");
        m1.setSex("sdf");
		memService.updateMember(m1);
		
		System.out.println(m1.getMemberName());
		
	}

	@Test
	public void testBrowseMember() throws Exception {
		List list = memService.browseMember();
		System.out.println(list);
		Iterator i=list.iterator();
		while (i.hasNext()) {
			Member a = (Member) i.next();
			
			System.out.println(a.getId());
			System.out.println(a.getMemberName());
			System.out.println(a.getLoginName());
			System.out.println(a.getLoginPwd());
			System.out.println(a.getEmail());
			System.out.println(a.getLastDate());
			System.out.println(a.getRegDate());
			System.out.println(a.getLoginTimes());
			System.out.println(a.getMemberlevel().getFavourable()+" "+a.getMemberlevel().getLevelName());
			
	}
	}

	

	@Test
	public void testDelMember() throws Exception {
		 memService.delMember(58);
		System.out.println(memService.loadMember(58).getMemberName());
	}

	@Test
	public void testLoadMember() throws Exception {
		Member a = memService.loadMember(35);
		String n = a.getMemberName();
	//	Date t = a.getLastDate();
		String t=a.getLastDate();
		Integer i = a.getId();
		String ln = a.getLoginName();
		String lp = a.getLoginPwd();
		System.out.println(n+" "+t+" "+i+" "+ln+" "+lp);
	}
	@Test
	public void testBrowseMemberLevel()throws Exception{
		
	}
	@Test
	public void testLoadMemberLevel()throws Exception{
		
	}

}
