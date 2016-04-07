package com.yayao.daotest;


import java.util.Iterator;
import java.util.List;

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

import com.yayao.bean.Category;
import com.yayao.bean.Merchandise;
import com.yayao.service.AdminService;
import com.yayao.service.MerService;
import com.yayao.service.impl.MerServiceImpl;
import com.yayao.util.DateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class MerServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{
	@Autowired
	@Qualifier("merService")
	MerService merService;
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
		//merService=(MerServiceImpl) context.getBean("merService");
				
		System.out.println(session);
	
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCategory() throws Exception {
	Category cate=new Category();
//	cate.setCateName("湘绣");
	cate.setCateName("陶瓷");
//	cate.setCateDesc("湘绣知名越来越高！");
	cate.setCateDesc("陶瓷技艺会有飞速发展！");
	merService.addCategory(cate);
	System.out.println(cate.getCateName());
	}

	@Test
	public void testDelCategory() {
		
	}

	@Test
	public void testUpdateCategory() throws Exception {
		Category cate=merService.loadCategory(2);
		cate.setCateName("陶瓷静品");
		cate.setCateDesc("陶瓷技艺真的会有飞速发展！");
	 merService.updateCategory(cate);
		
	
	}
	@Test
	public void testSearchMerchandise() throws Exception {
		List list=merService.searchMerchandise("花");
		Iterator i=list.iterator();
		while (i.hasNext()) {
			Merchandise mer = (Merchandise) i.next();
			System.out.println(mer.getId());
			System.out.println(mer.getMerName());
			System.out.println(mer.getMerDesc());
			System.out.println(mer.getCategory().getCateName());
		}
		
		
		
	}

	@Test
	public void testLoadCategory() throws Exception {
	Category cate= merService.loadCategory(2);
	System.out.println(cate.getCateName());
	}

	@Test
	public void testBrowseCategory() throws Exception {
		List l= merService.browseCategory();
		System.out.println(l);
		for (int i = 0; i < l.size(); i++) {
			Category cate = (Category) l.get(i);
			String cn = cate.getCateName();
			String cd = cate.getCateDesc();
			System.out.println(cn+" "+cd);
		}
	}

	@Test
	public void testAddMer() throws Exception {
	Merchandise mer=new Merchandise();
	mer.setLeaveFactoryDate(DateUtil.getCurrentTime());
	mer.setManufacturer("沙坪");
	mer.setMerModel("fd44");
	mer.setMerDesc("湖南湘绣，秀美天下！");
	mer.setMerName("伏虎");
	mer.setPrice(560.0);
	mer.setSpecial(0);//1代表特价
	mer.setSprice(330.0);
	mer.setPicture("1.png");
	Category category = merService.loadCategory(1);
	mer.setCategory(category);
	merService.addMer(mer);
	}

	@Test
	public void testDelMer() {
		
	}

	@Test
	public void testUpdateMer() throws Exception {
		Merchandise mer = merService.loadMer(34);
		//mer.setLeaveFactoryDate(DateUtil.getCurrentTime());
		//mer.setManufacturer("沙坪2");
		//mer.setMerModel("fd44df");
		//mer.setMerDesc("湖南湘绣，秀美天下！");
		//mer.setMerName("摩天");
		//mer.setPrice(440.0);
		//mer.setSpecial(0);//1代表特价
		//mer.setSprice(220.0);
		//mer.setPicture("商品2");
		//Category category = merService.loadCategory(1);
		mer.setCategory(null);
		merService.updateMer(mer);
		
	}

	@Test
	public void testLoadMer() {
	
	}

	@Test
	public void testBrowseMerString() {
	
	}

	@Test
	public void testBrowseMerIntIntIntBoolean() {
		
	}

	@Test
	public void testBrowseMerIntIntString() {
		
	}

	@Test
	public void testCountRecord() {
		
	}

}
