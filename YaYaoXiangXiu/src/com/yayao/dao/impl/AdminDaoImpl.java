package com.yayao.dao.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.yayao.bean.*;
import com.yayao.dao.AdminDao;
import com.yayao.util.BaseLog;
















import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


/** 系统用户管理接口实现 */
@Repository("adminDao")
public class AdminDaoImpl extends BaseLog implements AdminDao{
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
		
	}
	
	
	/** 系统管理员登录 */
	public Admin adminLogin(String loginName, String loginPwd)  {
			
		    Criteria c = getSession().createCriteria(Admin.class);
			c.add(Restrictions.eq("loginName", loginName));
			c.add(Restrictions.eq("loginPwd",loginPwd));
			Admin admin = (Admin) c.uniqueResult();
			return admin;
	}

	/** 新增管理员 */	
	
	public void addAdmin(Admin admin) {
		getSession().save(admin);
	}

	/** 浏览管理员 */
	public List browseAdmin() {
//			Criteria c = getSession().createCriteria(Admin.class);		
//			c.addOrder(Order.desc("id"));
//			List admins=c.list();
			Query hql = getSession().createQuery("from Admin order by id desc");
			List admins = hql.list();
		return admins;
	}

	/** 删除指定的管理员 
	 * @throws Exception */
	public void delAdmin(Integer id)  {
		
			//Admin admin = (Admin)getSession().get(Admin.class, id);
			//Criteria c = getSession().createCriteria(Admin.class);
			//c.add(Restrictions.eq("id", id));
			//Admin admin = (Admin) c.uniqueResult();
			//getSession().delete(admin);
			
			
			//Query q = getSession().createSQLQuery(" delete from admin_tb  where id=:id ");
			
//			Query hql = getSession().createQuery(" delete from Admin as a  where a.id=:id");
//			hql.setInteger("id", id);
//			hql.executeUpdate();
		Admin a = (Admin)getSession().get(Admin.class, id);
			getSession().delete(a);
	}
	/** 装载指定的管理员 */
	public Admin loadAdmin(Integer id){
		Admin admin = (Admin)getSession().get(Admin.class, id);
		return admin;
	}

	/** 更新管理员 */	
	public void updateAdmin(Admin admin) {
			/*Query q = getSession().createSQLQuery(
					" UPDATE admin_tb "+ 
                    " SET AdminType=?, "+ 
                    " AdminName=?, "+
                    " LoginName=?, "+ 
                    " LoginPwd =? "+ 
                    " WHERE ID=? ");
			q.setInteger(0, admin.getAdminType());
			q.setString(1, admin.getAdminName());
			q.setString(2, admin.getLoginName());
			q.setString(3, admin.getLoginPwd());
			q.setInteger(4, admin.getId());
			*/
//			Query hql= getSession().createQuery("update Admin a set a.adminType=?,a.adminName=?,a.loginName=?,a.loginPwd=? where a.id=? ");
//			hql.setInteger(0, admin.getAdminType());
//			hql.setString(1, admin.getAdminName());
//			hql.setString(2, admin.getLoginName());
//			hql.setString(3, admin.getLoginPwd());
//			hql.setInteger(4, admin.getId());
//			hql.executeUpdate();
		getSession().merge(admin);
	}


	/**
	 * 检查管理员账号是否存在
	 */
	public boolean chkAdminLoginName(String loginName){
		boolean status = true;//true代表数据库已经存在
		Admin admin = null;
		Criteria c = getSession().createCriteria(Admin.class);
		c.add(Restrictions.eq("loginName", loginName));
		 admin = (Admin) c.uniqueResult();
		if(admin==null){
			status=false;
			return status;
		}
		return status;
	}
}