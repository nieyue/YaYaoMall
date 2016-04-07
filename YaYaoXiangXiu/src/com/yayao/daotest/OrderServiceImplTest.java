package com.yayao.daotest;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yayao.bean.Cart;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.bean.Member;
import com.yayao.bean.Orders;
import com.yayao.service.CartService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.service.OrderService;
import com.yayao.service.impl.CartServiceImpl;
import com.yayao.service.impl.MemServiceImpl;
import com.yayao.service.impl.OrderServiceImpl;
import com.yayao.util.DateUtil;

public class OrderServiceImplTest {
	MemService memService;
	CartService cartService;
	OrderService orderService;
	ApplicationContext context;
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		session=sessionFactory.openSession();

		//session.beginTransaction();
		orderService=  (OrderServiceImpl) context.getBean("orderService");
		cartService=  (CartServiceImpl) context.getBean("cartService");
		memService=(MemServiceImpl) context.getBean("memService");
				
		System.out.println(session);
	
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddOrder() throws Exception {
		Orders order=new Orders();
		Member member = memService.loadMember(1);
		order.setMember(member);
		
		//order.setConsignee(1);
		
		Cart cart = cartService.loadCart(member);
		cart.setCartStatus(new Integer(1));//改变购物车状态由0变成1，使用中变成已下单。
		order.setCart(cart);
		cartService.updateCart(cart);
		order.setOrderDate(DateUtil.getCurrentTime());
		order.setOrderNumber(DateUtil.getOrdersTime());
		//order.setOrderStatus(new Integer(1));//0:取消订单，1:已经下单，2:已经发货，3:已经完成
		
		 orderService.addOrder(order);
	}

	@Test
	public void testBrowseOrderMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseOrderMer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOrder() {
		fail("Not yet implemented");
	}

}
