package com.yayao.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.yayao.bean.*;
import com.yayao.dao.AdminDao;
import com.yayao.service.AdminService;
import com.yayao.service.CartService;
import com.yayao.service.CommentService;
import com.yayao.service.ExclusiveCustomService;
import com.yayao.service.MemService;
import com.yayao.service.MerService;
import com.yayao.service.OrderService;
import com.yayao.util.ActionContextUtil;
import com.yayao.util.BaseLog;

import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/** 系统用户管理接口实现 */
@Service("adminService")
public class AdminServiceImpl  implements AdminService{
	@Autowired
	@Qualifier("adminDao")
	private AdminDao adminDao;
	@Autowired
	@Qualifier("memService")
	private MemService memService;
	@Autowired
	@Qualifier("merService")
	private MerService merService;
	@Autowired
	@Qualifier("commentService")
	private CommentService commentService;
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("cartService")
	private CartService cartService;
	@Autowired
	@Qualifier("exclusiveCustomService")
	private ExclusiveCustomService exclusiveCustomService;
	/** 系统管理员登录 */
	public Admin adminLogin(String loginName, String loginPwd){
		Admin admin = adminDao.adminLogin(loginName, loginPwd);
		Map session = ActionContextUtil.getSession();
		if(admin!=null&&admin.getAdminType().equals(4)){
			browseAdmin();
		}else if(admin!=null&&admin.getAdminType().equals(2)){
			memService.adminBrowseMember();
			//commentService.browseMemCustomComment(member);
			
		}else if(admin!=null&&admin.getAdminType().equals(3)){
			exclusiveCustomService.browseAllExclusiveCustom();
			orderService.browseAllOrderMer();
			
		}
		else if(admin!=null&&admin.getAdminType().equals(1)){
		merService.browseCategory();
		String hql1 ="from Merchandise as a order by a.id desc";
		String hql2 ="from Merchandise as a where a.special=1 order by a.id";
		merService.browseMer(hql1);
		merService.browseMer(hql2);
		}
		return admin;
	}

	/** 新增管理员 */	
	
	public void addAdmin(Admin admin){
	 adminDao.addAdmin(admin);
	}

	/** 浏览所有管理员信息 */
	public List browseAdmin(){
			
			//浏览所有管理人信息
			List list=adminDao.browseAdmin();
			ActionContextUtil.getSession().remove("adminList");
			//存储当前管理人信息
			ActionContextUtil.getSession().put("adminList", list);
			return list;
	}

	/** 删除指定的管理员 */
	public void delAdmin(Integer id) {
		adminDao.delAdmin(id);
	}

	/** 装载指定的管理员 */
	public Admin loadAdmin(Integer id)  {
		Admin admin=adminDao.loadAdmin(id);
		return admin;
	}

	/** 更新管理员 */	
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
	}

	/**
	 * 管理员账号检查是否存在
	 */
	public boolean chkAdminLoginName(String loginName) {
		boolean status=adminDao.chkAdminLoginName(loginName);
		return status;
	}
}