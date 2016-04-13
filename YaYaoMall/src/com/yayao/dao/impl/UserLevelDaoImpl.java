package com.yayao.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yayao.bean.UserLevel;
import com.yayao.dao.UserLevelDao;
/**
 * 账户数据访问实现类
 * @author yy
 *
 */
@Repository("userLevelDao")
public class UserLevelDaoImpl implements UserLevelDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		 //return sessionFactory.openSession();

	}

	/** 新增账户等级 */
	public void addUserLevel(UserLevel userLevel) {
		getSession().save(userLevel);

	}

	/** 修改账户等级 */
	public void updateUserLevel(UserLevel userLevel) {
		if(userLevel!=null){
			getSession().merge(userLevel);
		}
	}


	/** 删除账户等级 */
	public void delUserLevel(Integer id) {
		UserLevel userLevel = (UserLevel) getSession().get(UserLevel.class, id);
		if(userLevel!=null){
			getSession().delete(userLevel);
		}
	}

	/**
	 * 加载单个用户等级
	 */
	public UserLevel loadUserLevel(Integer id) {
		UserLevel userLevel=null;
		userLevel=  (UserLevel) getSession().get(UserLevel.class, id);
		return userLevel;
	}
	/**
	 * 浏览账户级别
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserLevel> browseUserLevel() {
		List<UserLevel> list = null;
		Criteria userLevel = getSession().createCriteria(UserLevel.class);
		userLevel.addOrder(Order.asc("userlevelid"));
		list = userLevel.list();
		return list;
	}

}