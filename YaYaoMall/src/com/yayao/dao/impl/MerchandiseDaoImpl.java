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
import com.yayao.bean.Merchandise;
import com.yayao.dao.MerchandiseDao;


/**
 *商品数据访问实现类
 * @author yy
 *
 */
@Repository("merchandiseDao")
public class MerchandiseDaoImpl implements MerchandiseDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		 //return sessionFactory.openSession();

	}

	/**
	 * 新增商品 
	 */
	public void addMer(Merchandise mer) {
		getSession().save(mer);
	}

	/**
	 * 删除指定的商品 
	 */
	public void delMer(Integer id) {
		getSession().delete(loadMer(id));
	}

	/**
	 * 更新商品 
	 */
	public void updateMer(Merchandise mer) {
		getSession().merge(mer);
	}

	/**
	 * 装载指定的商品
	 */
	public Merchandise loadMer(Integer id) {
		Merchandise mer = null;
		mer = (Merchandise)getSession().get(Merchandise.class, id);
		return mer;
	}

	/**
	 * 浏览商品 
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> browseMer(MerCategory cate,String orderName,String orderWay) {
		Criteria c = getSession().createCriteria(Merchandise.class);
		if(cate!=null){
			c.add(Restrictions.eq("merCategory", cate));
		}
		switch (orderWay) {
		case "asc":
			c.addOrder(Order.asc(orderName));
			break;
		case "desc":
			c.addOrder(Order.desc(orderName));
			break;
		}
		List<Merchandise> list = c.list();
		return list;
	}

	/**
	 * 分页浏览商品 
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> browseMer(int pageSize, int pageNo, MerCategory cate,String orderName,String orderWay) {
		List<Merchandise> list = null;
		Criteria c = getSession().createCriteria(Merchandise.class);
		if(cate!=null){
			c.add(Restrictions.eq("merCategory", cate));
		}
		switch (orderWay) {
		case "asc":
			c.addOrder(Order.asc(orderName));
			break;
		case "desc":
			c.addOrder(Order.desc(orderName));
			break;
		}
		c.setFirstResult((pageNo-1)*pageSize);
		c.setMaxResults(pageSize);
		list = c.list();
		return list;
	}

	
	/**
	**后台检索商品（按商品模糊名称） 
	** 
	*/
	@SuppressWarnings("unchecked")
	public List<Merchandise> searchMerchandise(MerCategory cate,String merName) {
		List<Merchandise> list=null;
		Criteria criteria = getSession().createCriteria(Merchandise.class);
		if(cate!=null){
			criteria.add(Restrictions.eq("merCategory", cate));
		}
		criteria.add(Restrictions.like("merchandiseName", "%"+merName+"%"));
		list=criteria.list();
		return list;
	}

	/**
	 * 统计记录条数 
	 */
	@SuppressWarnings("unchecked")
	public int countRecord(MerCategory cate) {
		List<Merchandise> list=null;
		Criteria criteria = getSession().createCriteria(Merchandise.class);
		if(cate!=null){
			criteria.add(Restrictions.eq("merCategory", cate));
		}
		list=criteria.list();
		return list.size();
	}

	
}