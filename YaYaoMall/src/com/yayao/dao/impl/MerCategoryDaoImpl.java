package com.yayao.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yayao.bean.MerCategory;
import com.yayao.dao.MerCategoryDao;


/**
 * 商品分类数据访问实现类
 * @author yy
 *
 */
@Repository("merCategoryDao")
public class MerCategoryDaoImpl implements MerCategoryDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		 //return sessionFactory.openSession();

	}

	/**
	 * 新增商品分类 
	 */
	public void addMerCategory(MerCategory merCategory) {
		getSession().save(merCategory);

	}

	/**
	 * 更新商品分类 
	 */
	public void updateMerCategory(MerCategory merCategory) {
		if(merCategory!=null){
			getSession().merge(merCategory);
		}
	}


	/**
	 * 删除指定的商品分类 
	 */
	public void delMerCategory(Integer id) {
		MerCategory merCategory = (MerCategory) getSession().get(MerCategory.class, id);
		if(merCategory!=null){
			getSession().delete(merCategory);
		}
	}

	/**
	 * 装载指定商户的商品分类 
	 */
	public MerCategory loadMerCategory(Integer sellerid,String cateName) {
		MerCategory merCategory=null;
		Criteria c = getSession().createCriteria(MerCategory.class);
		c.add(Restrictions.eq("mersellerid", sellerid));
		c.add(Restrictions.eq("cateName", cateName));
		merCategory=(MerCategory) c.uniqueResult();
		return merCategory;
	}
	/**
	 * 浏览商户商品分类 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MerCategory> browseMerCategory(Integer sellerid) {
		List<MerCategory> list = null;
		Criteria userLevel = getSession().createCriteria(MerCategory.class);
		userLevel.add(Restrictions.eq("mersellerid", sellerid));
		userLevel.addOrder(Order.asc("mercategoryid"));
		list = userLevel.list();
		return list;
	}
	/**
	 * 检查商户商品分类存在否
	 */
	public boolean chkMerCategory(Integer sellerid,String cateName) {
		boolean status = true;//true代表数据库已经存在
		MerCategory cate = null;
		Criteria c = getSession().createCriteria(MerCategory.class);
		c.add(Restrictions.eq("mersellerid", sellerid));
		c.add(Restrictions.eq("cateName", cateName));
		 cate = (MerCategory) c.uniqueResult();
		if(cate==null){
			status=false;
			return status;
		}
		
		return status;
	}

}