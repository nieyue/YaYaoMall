package com.yayao.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yayao.bean.User;
import com.yayao.dao.UserDao;
/**
 * 账户数据访问实现
 * @author yy
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		// return sessionFactory.openSession();

	}

	/** 新增注册账户 */
	public void addUser(User user) {
		getSession().save(user);

	}

	/** 检测登录账户是否有效 */
	public boolean chkLoginName(String userName) {
		boolean status = true;// true代表数据库已经存在
		User user = null;
		Criteria c = getSession().createCriteria(User.class);
		Disjunction dis=Restrictions.disjunction();//逻辑或or
		dis.add(Restrictions.eq("userName", userName));
		dis.add(Restrictions.eq("userEmail", userName));
		dis.add(Restrictions.eq("userPhone", userName));
		c.add(dis);
		user = (User) c.uniqueResult();
		if (user == null) {
			status = false;
			return status;
		}
		return status;
	}

	/** 账户登录 */
	public User userLogin(String userName, String userPassword) {
		User user = null;
		Criteria c = getSession().createCriteria(User.class);
		c.add(Restrictions.eq("userName", userName));
		c.add(Restrictions.eq("userPassword", userPassword));
		user = (User) c.uniqueResult();
		return user;
	}

	/** 修改注册账户信息 */
	public void updateUser(User user) {
		if(user!=null){
			getSession().merge(user);
		}
	}

	/** 浏览注册账户 */
	@SuppressWarnings("unchecked")
	public List<User> browseUser() {
		List<User> list = null;
		Criteria c = getSession().createCriteria(User.class);
		c.addOrder(Order.asc("id"));
		list = c.list();
		return list;
	}

	/** 删除注册账户 */
	public void delUser(Integer id) {
		User user = (User) getSession().get(User.class, id);
		if(user!=null){
			getSession().delete(user);
		}
	}

	/** 装载注册账户 */
	public User loadUser(Integer id) {
		User user=null;
		user= (User) getSession().load(User.class, id);
		return user;
	}


	/**
	 * 查询注册账户
	 */
	@SuppressWarnings("unchecked")
	public List<User> searchUser(String hql) {
		List<User> list = null;
		Query query = getSession().createQuery(hql);
		list = query.list();
		return list;
	}

	/**
	 * 找回账户
	 */
	public User RetrieveAccount(String userName, String userEmail) {
		User user = null;
		Criteria c = getSession().createCriteria(User.class);
		c.add(Restrictions.eq("userName", userName));
		c.add(Restrictions.eq("userEmail", userEmail));
		user = (User) c.uniqueResult();
		return user;
	}
}