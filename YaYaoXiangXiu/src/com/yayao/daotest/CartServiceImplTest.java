package com.yayao.daotest;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yayao.bean.Cart;
import com.yayao.bean.Cartselectedmer;
import com.yayao.bean.Category;
import com.yayao.bean.Member;
import com.yayao.bean.Memberlevel;
import com.yayao.bean.Merchandise;
import com.yayao.bean.Orders;
import com.yayao.service.CartService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.MemService;
import com.yayao.service.MerService;
import com.yayao.service.OrderService;
import com.yayao.service.impl.CartServiceImpl;
import com.yayao.service.impl.ConsigneeServiceImpl;
import com.yayao.service.impl.MemServiceImpl;
import com.yayao.service.impl.MerServiceImpl;
import com.yayao.service.impl.OrderServiceImpl;
import com.yayao.util.DateUtil;


public class CartServiceImplTest {
	MemService memService;
	MerService merService;
	CartService cartService;
	ConsigneeService consigneeService;
	ApplicationContext context;
	SessionFactory sessionFactory;
	Session session;
	OrderService orderService;
	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		session=sessionFactory.openSession();

		//session.beginTransaction();
		consigneeService=  (ConsigneeServiceImpl) context.getBean("consigneeService");
		cartService=(CartServiceImpl) context.getBean("cartService");
		memService=(MemServiceImpl) context.getBean("memService");
		merService=(MerServiceImpl) context.getBean("merService");
		orderService=(OrderServiceImpl)context.getBean("orderService");
		System.out.println(session);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCart() throws Exception {
		Cart cart=new Cart();
		Member m=memService.loadMember(2);
		System.out.println(m.getLoginName());
		Merchandise mer=merService.loadMer(1);
		System.out.println(mer.getPicture());
		
//		Merchandise mer=new Merchandise();
//		Category category=new Category();
//		category.setCateName("湘绣");
//		category.setCateDesc("湘绣商城");
//		mer.setCategory(category);
//		mer.setLeaveFactoryDate(DateUtil.getCurrentTime());
//		mer.setManufacturer("沙坪");
//		mer.setMerDesc("这是一款很温馨的艺术与现实结合的产品！");
//		mer.setMerModel("GD-3435");
//		mer.setMerName("伏虎");
//		mer.setPicture("商品图片01");
//		mer.setPrice(510.0);
//		mer.setSpecial(1);
//		Memberlevel ml=new Memberlevel();
//		ml.setLevelName("白银会员");
//		ml.setFavourable(90);
//		m.setMemberlevel(ml);
//		mer.setSprice(mer.getPrice().doubleValue()*ml.getFavourable().intValue()/100);
	    cartService.addCart(m, mer, 5);
		System.out.println(cart.getMoney());
		System.out.println(cart.getCartStatus());
		System.out.println(cart.getMerchandises());
		System.out.println(cart.getMember());
	}

	@Test
	public void testBrowseCart() {
		
	}

	@Test
	public void testClearCart() {
		
	}

	@Test
	public void testModiCart() {
		
	}

	@Test
	public void testDelCart() {
	
	}

	@Test
	public void testLoadCart() {
		
	}

	@Test
	public void testUpdateCart() {
		
	}
	@Test
	public void testInsertOrder() throws Exception {
		Orders order = orderService.loadOrder(new Integer(24));
		System.out.println(order.getOrderNumber());
		Cartselectedmer sel=new Cartselectedmer();
		sel.setId(new Integer(45));
		System.out.println(sel.getId());
		cartService.insertOrder(order, sel);
		
		
	}

}
