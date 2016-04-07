package com.yayao.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yayao.bean.Consignee;
import com.yayao.bean.ExclusiveCustom;
import com.yayao.dao.ConsigneeDao;
import com.yayao.dao.ExclusiveCustomDao;
import com.yayao.util.BaseLog;
@Repository("exclusiveCustomDao")
public class ExclusiveCustomDaoImpl extends BaseLog implements ExclusiveCustomDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
		
	}
	/**
	 * 增加定制
	 */
	@Override
	public void addExclusiveCustom(ExclusiveCustom exclusiveCustom)  {
			getSession().save(exclusiveCustom);
	}
	
	/**
	 * 修改定制
	 */
	@Override
	public void updateExclusiveCustom(ExclusiveCustom exclusiveCustom) {
			getSession().merge(exclusiveCustom);
			/*Query hql = getSession().createQuery(
					" UPDATE ExclusiveCustom "+ 
							" SET customCategory=?, "+
							" member=?, "+
							" customDate=?, "+
							" customName=?, "+
							" customPhone=?, "+
							" customPicture=?, "+
							" customDetails=?, "+
							" customOrderNumber=? "+
					" WHERE id=? ");
	
			hql.setString(0, exclusiveCustom.getCustomCategory());
			hql.setEntity(1, exclusiveCustom.getMember());
			hql.setString(2, exclusiveCustom.getCustomDate());
			hql.setString(3, exclusiveCustom.getCustomName());
			hql.setString(4, exclusiveCustom.getCustomPhone());
			hql.setString(5, exclusiveCustom.getCustomPicture());
			hql.setString(6, exclusiveCustom.getCustomDetails());
			hql.setString(7, exclusiveCustom.getCustomOrderNumber());
			hql.setInteger(8, exclusiveCustom.getId());
			hql.executeUpdate();*/
			
	}

	/**
	 * 浏览定制信息
	 */
	@Override
	public List browseExclusiveCustom(){
		Criteria c = getSession().createCriteria(ExclusiveCustom.class);		
		c.addOrder(Order.asc("id"));
		List list=c.list();
	return list;
	}

	/**
	 * 删除定制信息
	 */
	@Override
	public void delExclusiveCustom(Integer id){
			Query hql = getSession().createQuery(" delete from ExclusiveCustom  where id=:id ");
			hql.setInteger("id", id);
			hql.executeUpdate();
	}
	
	/**
	 * 装载收货人信息
	 */
	@Override
	public ExclusiveCustom loadExclusiveCustom(Integer id)  {
		ExclusiveCustom exclusiveCustom = (ExclusiveCustom)getSession().get(ExclusiveCustom.class, id);
		return exclusiveCustom;
	}
	/**
	 * 查询定制订单
	 */
	public List searchExclusiveCustom(String hql) {
		List l=null;
			Query q = getSession().createQuery(hql);
			l = q.list();
		return l;
	}

}
