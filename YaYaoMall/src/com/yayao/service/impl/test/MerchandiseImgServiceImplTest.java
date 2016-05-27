package com.yayao.service.impl.test;

import static org.junit.Assert.fail;

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

import com.yayao.bean.Merchandise;
import com.yayao.bean.MerchandiseImg;
import com.yayao.service.MerchandiseImgService;
import com.yayao.service.MerchandiseService;
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/applicationContext.xml"})
@TransactionConfiguration(transactionManager="txManager",defaultRollback = false)//true:始终回滚 false:数据提交
public class MerchandiseImgServiceImplTest {
	@Autowired
	@Qualifier("merchandiseImgService")
	MerchandiseImgService merchandiseImgService;
	@Autowired
	@Qualifier("merchandiseService")
	MerchandiseService merchandiseService;
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
	public void testAddMerchandiseImg() {
		Merchandise mer = merchandiseService.loadMer(11);
		MerchandiseImg merchandiseImg = new MerchandiseImg();
		merchandiseImg.setMerchandise(mer);
		StringBuffer imgsbuffer = new StringBuffer();
		//String imgs="";
		
		for (int i =1; i <= 15; i++) {
			
			//imgs=imgsbuffer.toString();
			merchandiseImg.setMerchandiseImgAddress("/resources/sellerUpload/7/黑茶/金花茯砖/金花茯砖1_0"+i+".jpg");
			merchandiseImgService.addMerchandiseImg(merchandiseImg);
			
		}
	}

	@Test
	public void testDelMerchandiseImg() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateMerchandiseImg() {
		List<MerchandiseImg> list = merchandiseImgService.browseMerchandiseImg(1, "merchandiseimgid", "asc");
		StringBuffer imgsbuffer = new StringBuffer();
		//String imgs="";
		for (int i =0; i <list.size(); i++) {
			
			//imgsbuffer.append("/resources/sellerUpload/1/黑茶/富甲富颗粒/富甲富颗粒1_0"+i+".jpg");
			//imgs=imgsbuffer.toString();
			if(i>=9){
			//	list.get(i).setImgaddress("/resources/sellerUpload/1/黑茶/富甲富颗粒/富甲富颗粒1_"+(i+1)+".jpg");
			}else{
			//	list.get(i).setImgaddress("/resources/sellerUpload/1/黑茶/富甲富颗粒/富甲富颗粒1_0"+(i+1)+".jpg");
			}
			merchandiseImgService.updateMerchandiseImg(list.get(i));
			
		}
	}

	@Test
	public void testLoadMerchandiseImg() {
		MerchandiseImg s = merchandiseImgService.imgAddressLoadMerchandiseImg("aa");
		System.out.println(s.getMerchandiseImgAddress());
	}

	@Test
	public void testBrowseMerchandiseImg() {
		fail("Not yet implemented");
	}

}
