package com.yayao.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
	public void addMer(Merchandise merchandise) {
		merchandise.setMerchandiseUpdateTime(new Date());
		getSession().save(merchandise);
	}

	/**
	 * 删除指定的商品 
	 */
	public void delMer(Integer merchandiseid) {
		getSession().delete(loadMer(merchandiseid));
	}

	/**
	 * 更新商品 
	 */
	public void updateMer(Merchandise merchandise) {
		merchandise.setMerchandiseUpdateTime(new Date());
		getSession().update(merchandise);
	}

	/**
	 * 装载指定的商品
	 */
	public Merchandise loadMer(Integer merchandiseid) {
		Merchandise mer = null;
		mer = (Merchandise)getSession().get(Merchandise.class, merchandiseid);
		return mer;
	}

	/**
	 * 浏览类别商品 ，若为0浏览所有
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> browseMerByMerCate(Integer mercategoryid,String merchandiseStatus,String orderName,String orderWay) {
		Criteria c = getSession().createCriteria(Merchandise.class);
		if(mercategoryid!=0){
			c.add(Restrictions.eq("merCategory.merCategoryId",mercategoryid));
		}
		if(merchandiseStatus!=null){
			c.add(Restrictions.eq("merchandiseStatus",merchandiseStatus));
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
	 *  根据商家浏览商品 ，若为0浏览所有
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> browseMerBySeller(Integer sellerid,String merchandiseStatus,String orderName,String orderWay) {
		Criteria c = getSession().createCriteria(Merchandise.class);
		if(sellerid!=0){
			c.add(Restrictions.eq("seller.sellerId", sellerid));
		}
		if(merchandiseStatus!=null){
			c.add(Restrictions.eq("merchandiseStatus",merchandiseStatus));
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
	 * 根据类别分页浏览商品 ，若为0浏览所有
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> browseMerByMerCate(int pageSize, int pageNo, Integer mercategoryid,String merchandiseStatus,String orderName,String orderWay) {
		List<Merchandise> list = null;
		Criteria c = getSession().createCriteria(Merchandise.class);
		if(mercategoryid!=0){
			c.add(Restrictions.eq("merCategory.merCategoryId", mercategoryid));
		}
		if(merchandiseStatus!=null){
			c.add(Restrictions.eq("merchandiseStatus",merchandiseStatus));
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
	 * 根据商家分页浏览商品 ，若为0浏览所有
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> browseMerBySeller(int pageSize, int pageNo,Integer sellerid,String merchandiseStatus,String orderName,String orderWay) {
		List<Merchandise> list = null;
		Criteria c = getSession().createCriteria(Merchandise.class);
		if(sellerid!=0){
			c.add(Restrictions.eq("seller.sellerId", sellerid));
		}
		if(merchandiseStatus!=null){
			c.add(Restrictions.eq("merchandiseStatus",merchandiseStatus));
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
	**后台检索商品（按商品模糊名称） ，若为0浏览所有
	** 
	*/
	@SuppressWarnings("unchecked")
	public List<Merchandise> searchMerchandise(Integer sellerid,String merName) {
		List<Merchandise> list=null;
		Criteria criteria = getSession().createCriteria(Merchandise.class);
		if(sellerid!=0){
			criteria.add(Restrictions.eq("seller.sellerId", sellerid));
		}
		criteria.add(Restrictions.like("merchandiseName", "%"+merName+"%"));
		list=criteria.list();
		return list;
	}

	/**
	 * 统计记录条数 
	 */
	@SuppressWarnings("unchecked")
	public int countRecord(Integer sellerid,String merchandiseStatus,Integer mercategoryid) {
		List<Merchandise> list=null;
		Criteria criteria = getSession().createCriteria(Merchandise.class);
		if(merchandiseStatus!=null){
			criteria.add(Restrictions.eq("merchandiseStatus",merchandiseStatus));
		}
		if(sellerid==0&&mercategoryid!=0){//只查询一个类别所有商品记录
			criteria.add(Restrictions.eq("merCategory.merCategoryId", mercategoryid));
		}else if(mercategoryid==0&&sellerid!=0){//只查询一个商户所有商品记录
			criteria.add(Restrictions.eq("seller.sellerId", sellerid));
		}else if(mercategoryid!=0&&sellerid!=0){//只查询一个商户下的一个类别所有商品记录，同上上
			criteria.add(Restrictions.eq("seller.sellerId", sellerid));
			criteria.add(Restrictions.eq("merCategory.merCategoryId", mercategoryid));
		}
		list=criteria.list();
		return list.size();
	}

	
}