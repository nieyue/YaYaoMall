package com.yayao.controller.test;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.yayao.bean.User;
import com.yayao.controller.UserController;
import com.yayao.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:config/applicationContext.xml","classpath:config/springmvc-servlet.xml"})
public class UserControllerTest {
	@Autowired
	@Qualifier("userService")
	UserService userService;
	MockHttpServletRequest request=new MockHttpServletRequest();
	MockHttpServletResponse response=new MockHttpServletResponse();
	
	@Autowired
	@Qualifier("userController")
	UserController userController;
	
	@Autowired
	@Qualifier("wac")
    private WebApplicationContext wac;  
  
    private MockMvc mockMvc; 
	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build(); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserNameValid() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testChkValidCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserRegister() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoginOut() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserIMGUpload() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadUser() {
	}

	@Test
	public void testBrowseUser() throws Exception {
		/*//直接调用方法
		request.setAttribute("msg", "测试action成功");
		 List<User> list = userController.browseUser(request.getSession());
		 for (int i = 0; i < list.size(); i++) {
			 System.out.print(list);
			 System.out.print(list.get(i).getUserEmail());
			 System.out.println(list.get(i).getUserPassword());
		}*/
		//调用路径
		 this.mockMvc.perform(post("/merCategory/browseMerCategory?cateName=绿茶&sellerid=1"))
       // .andExpect(status().isOk())
          .andDo(print());  ;
	}


	@Test
	public void testBrowseUserXLS() {
		fail("Not yet implemented");
	}

	@Test
	public void testBrowseUserPDF() {
		fail("Not yet implemented");
	}

}
