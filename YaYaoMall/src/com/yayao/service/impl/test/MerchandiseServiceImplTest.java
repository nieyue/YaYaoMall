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
import com.yayao.bean.Seller;
import com.yayao.service.MerCategoryService;
import com.yayao.service.MerchandiseImgService;
import com.yayao.service.MerchandiseService;
import com.yayao.service.SellerService;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class MerchandiseServiceImplTest {
	@Autowired
	@Qualifier("merchandiseService")
	MerchandiseService merchandiseService;
	@Autowired
	@Qualifier("merchandiseImgService")
	MerchandiseImgService merchandiseImgService;
	@Autowired
	@Qualifier("merCategoryService")
	MerCategoryService merCategoryService;
	@Autowired
	@Qualifier("sellerService")
	SellerService sellerService;
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
		MerCategory mercate = merCategoryService.loadMerCategory(5);
		mer.setMerCategory(mercate);
		mer.setMerchandiseCode("sr1d55");
		Seller merSeller = new Seller();
		merSeller.setSellerid(7);
		mer.setSeller(merSeller);
		//mer.setMerchandiseImg("http://wd.geilicdn.com/vshop333816149-1457603308132-5927369.jpg?w=1080&h=0");
		mer.setMerchandiseName("施兆鹏八十大寿礼茶 湖南安化黑茶 金花茯砖 收藏茶 盒装1936g");
		mer.setMerchandiseOldPrice(2980.00);
		mer.setMerchandisePrice(2820.00);
		mer.setMerchandisePostage(0.00);
		mer.setMerchandiseSold(45);//销量
		mer.setMerchandiseStatus("上架");
		mer.setMerchandiseStock(965);//库存
		mer.setMerchandiseUpdateTime(new Date());
		mer.setMerDiscount(Double.valueOf(2820*100/2980)/100);//折扣
		merchandiseService.addMer(mer);
	}

	@Test
	public void testDelMer() {
		
	}

	@Test
	public void testUpdateMer() {
		List<Merchandise> list = merchandiseService.browseMerBySeller(0, "merchandiseid", "asc");
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			Merchandise merchandise = list.get(i);
			Seller seller =merchandise.getMerCategory().getSeller();
			merchandise.setSeller(seller);
			merchandiseService.updateMer(merchandise);
		}
		//Merchandise mer = merchandiseService.loadMer(1);
		
	
		//mer.setMerchandiseIMGS(imgs);
		//merchandiseService.updateMer(mer);
		//System.out.println(mer.getMerchandiseIMGS());
	}

	@Test
	public void testLoadMer() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseMerString() {
		MerCategory cate = merCategoryService.loadMerCategory(6);
		System.out.println(cate);
		List<Merchandise> list = merchandiseService.browseMerBySeller(0, "merchandiseSold","desc");
	for (int i = 0; i < list.size(); i++) {
		
		System.out.println(list.get(i));
	}
	}

	@Test
	public void testBrowseMerIntIntInt() {
		MerCategory cate = merCategoryService.loadMerCategory(7);
		System.out.println(cate);
		List<Merchandise> list = merchandiseService.browseMerBySeller(10, 1, 0, "merchandiseSold","des");
	for (int i = 0; i < list.size(); i++) {
		
		System.out.println((list.get(0).getMerchandiseUpdateTime()).before(list.get(1).getMerchandiseUpdateTime()));
	}
	
	}

	@Test
	public void testSearchMer() {
		MerCategory cate = merCategoryService.loadMerCategory(7);
		System.out.println(cate);
		List<Merchandise> list = merchandiseService.searchMerchandise(0, "为人民服务");
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
		int aa = merchandiseService.countRecord(0, 0);
			System.out.println(aa);
	}

}
