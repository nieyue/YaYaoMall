package com.yayao.service.impl.test;

import static org.junit.Assert.fail;

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

import com.yayao.bean.Seller;
import com.yayao.service.SellerService;
import com.yayao.util.MyDESutil;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class SellerServiceImplTest {
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
	public void testMerSellerLogin() {
		String sellerName="15555555555";
		String sellerPassword= MyDESutil.getMD5("123456");
		String sellerName2="15555555556";
		String sellerPassword2= MyDESutil.getMD5("1234567");
			Seller seller = sellerService.merSellerLogin(sellerName, sellerPassword);
			Seller seller2 = sellerService.merSellerLogin(sellerName, sellerPassword);
			Seller seller3 = sellerService.merSellerLogin(sellerName2, sellerPassword2);
			Seller seller4 = sellerService.merSellerLogin(sellerName2, sellerPassword2);
			System.out.println(seller);
			System.out.println(seller3);
			System.out.println(seller2);
			System.out.println(seller4);
	}

	@Test
	public void testChkLoginName() {
		
	}

	@Test
	public void testRetrieveAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSeller() throws Exception {
		String sellerName="15555555555";
		String sellerPassword= MyDESutil.getMD5("123456");
		System.out.println(sellerPassword);
		boolean status = sellerService.chkLoginName(sellerName);
		System.out.println(status);
		if(!status){
			Seller seller =new Seller();
			seller.setSellerPhone(sellerName);
			System.out.println(sellerName);
			seller.setSellerPassword(sellerPassword);
			System.out.println(sellerPassword);
			boolean s = sellerService.addSeller(seller);
			System.out.println(s);
		}
	}

	@Test
	public void testUpdateSeller() {
		Seller seller = sellerService.loadSeller(6);
		seller.setSellerPhone("15555555556");
		sellerService.updateSeller(seller);
	}

	@Test
	public void testSearchSeller() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseSeller() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelSeller() {
		sellerService.delSeller(6);
	}

	@Test
	public void testLoadSeller() {
		fail("Not yet implemented");
	}

}
