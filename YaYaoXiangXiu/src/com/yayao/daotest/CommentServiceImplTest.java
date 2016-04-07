package com.yayao.daotest;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yayao.service.CommentService;
import com.yayao.service.ConsigneeService;
import com.yayao.service.MemService;
import com.yayao.service.impl.CommentServiceImpl;
import com.yayao.service.impl.ConsigneeServiceImpl;
import com.yayao.service.impl.MemServiceImpl;

public class CommentServiceImplTest {
	MemService memService;
	CommentService commentService;
	ApplicationContext context;
	SessionFactory sessionFactory;
	Session session;
	@Before
	public void setUp() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory=(SessionFactory) context.getBean("sessionFactory");
		session=sessionFactory.openSession();

		//session.beginTransaction();
		commentService=  (CommentServiceImpl) context.getBean("commentService");
		memService=(MemServiceImpl) context.getBean("memService");
				
		System.out.println(session);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddComment() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseCommentIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseComment() {
		fail("Not yet implemented");
	}

	@Test
	public void testCountComment() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadComment() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelComment() throws Exception {
		 commentService.delComment(6);
		
		System.out.println(commentService.loadComment(6).getTitle());
	}

	@Test
	public void testUpdateComment() {
		fail("Not yet implemented");
	}

}
