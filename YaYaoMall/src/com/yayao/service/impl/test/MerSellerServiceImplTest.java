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

import com.yayao.bean.MerSeller;
import com.yayao.service.MerSellerService;
import com.yayao.service.UserLevelService;
import com.yayao.util.SHAutil;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class MerSellerServiceImplTest {
	@Autowired
	@Qualifier("merSellerService")
	MerSellerService merSellerService;
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
		fail("Not yet implemented");
	}

	@Test
	public void testChkLoginName() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddMerSeller() throws Exception {
		String sellerName="15555555556";
		String sellerPassword=SHAutil.getSHA("123456");
		boolean status = merSellerService.chkLoginName(sellerName);
		System.out.println(status);
		if(!status){
			MerSeller merSeller =new MerSeller();
			merSeller.setSellerPhone(sellerName);
			merSeller.setSellerPassword(sellerPassword);
			merSellerService.addMerSeller(merSeller);
		}
	}

	@Test
	public void testUpdateMerSeller() {
		MerSeller merSeller = merSellerService.loadMerSeller(6);
		merSeller.setSellerPhone("15555555556");
		merSellerService.updateMerSeller(merSeller);
	}

	@Test
	public void testSearchMerSeller() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseMerSeller() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelMerSeller() {
		merSellerService.delMerSeller(6);
	}

	@Test
	public void testLoadMerSeller() {
		fail("Not yet implemented");
	}

}
