package com.yayao.service.impl.test;

import static org.junit.Assert.fail;

import java.util.Date;
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

import com.yayao.bean.MerCategory;
import com.yayao.bean.Merchandise;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerchandiseService;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class MerchandiseServiceImplTest {
	@Autowired
	@Qualifier("merchandiseService")
	MerchandiseService merchandiseService;
	@Autowired
	@Qualifier("merCategoryService")
	MerCategoryService merCategoryService;
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
	public void testAddMer() {
		Merchandise mer=new Merchandise();
		MerCategory mercate = merCategoryService.loadMerCategory("花茶");
		mer.setMerCategory(mercate);
		mer.setMerchandiseCode("sr155");
		mer.setMerchandiseIMGS("http://wd.geilicdn.com/vshop333816149-1457603308132-5927369.jpg?w=1080&h=0");
		mer.setMerchandiseName("清香型 绿茶茶叶 2016年雨前早春 包邮罐装200克");
		mer.setMerchandiseOldPrice(168.00);
		mer.setMerchandisePrice(80.00);
		mer.setMerchandisePostage(20.00);
		mer.setMerchandiseSold(55);//销量
		mer.setMerchandiseStatus("上架");
		mer.setMerchandiseStock(96);//库存
		mer.setMerchandiseUpdateTime(new Date());
		mer.setMerDiscount(6.0);//折扣
		
		merchandiseService.addMer(mer);
	}

	@Test
	public void testDelMer() {
		
	}

	@Test
	public void testUpdateMer() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadMer() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseMerString() {
		MerCategory cate = merCategoryService.loadMerCategory("黑茶");
		System.out.println(cate);
		List<Merchandise> list = merchandiseService.browseMer(null, "merchandiseSold","desc");
	for (int i = 0; i < list.size(); i++) {
		
		System.out.println(list.get(i));
	}
	}

	@Test
	public void testBrowseMerIntIntInt() {
		MerCategory cate = merCategoryService.loadMerCategory("黑茶");
		System.out.println(cate);
		List<Merchandise> list = merchandiseService.browseMer(2,3,null, "merchandiseSold","des");
	for (int i = 0; i < list.size(); i++) {
		
		System.out.println(list.get(i));
	}
	
	}

	@Test
	public void testSearchMer() {
		MerCategory cate = merCategoryService.loadMerCategory("黑茶");
		System.out.println(cate);
		List<Merchandise> list = merchandiseService.searchMerchandise(cate, "为人民服务");
	for (int i = 0; i < list.size(); i++) {
		
		System.out.println(list.get(i));
	}
	}

	@Test
	public void testSearchMerchandise() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountRecord() {
		MerCategory cate = merCategoryService.loadMerCategory("黑茶");
		int aa = merchandiseService.countRecord(cate);
			System.out.println(aa);
	}

}
