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

import com.yayao.bean.Seller;
import com.yayao.dao.SellerDao;

/**
 * 商户访问实现
 * @author yy
 *
 */
@Repository("sellerDao")
public class SellerDaoImpl implements SellerDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		 //return sessionFactory.openSession();
	}

	/** 新增注册商户 */
	public void addSeller(Seller seller) {
		getSession().save(seller);

	}

	/** 检测登录商户是否有效 */
	public boolean chkLoginName(String sellerName) {
		boolean status = true;// true代表数据库已经存在
		Seller seller = null;
		Criteria c = getSession().createCriteria(Seller.class);
		Disjunction dis=Restrictions.disjunction();//逻辑或or
		dis.add(Restrictions.eq("sellerEmail", sellerName));
		dis.add(Restrictions.eq("sellerPhone", sellerName));
		c.add(dis);
		seller = (Seller) c.uniqueResult();
		if (seller == null) {
			status = false;
			return status;
		}
		return status;
	}

	/** 商户登录 */
	public Seller merSellerLogin(String sellerName, String sellerPassword) {
		Seller seller = null;
		Criteria c = getSession().createCriteria(Seller.class);
		Disjunction dis=Restrictions.disjunction();//逻辑或or
		dis.add(Restrictions.eq("sellerEmail", sellerName));
		dis.add(Restrictions.eq("sellerPhone", sellerName));
		c.add(dis);
		c.add(Restrictions.eq("sellerPassword", sellerPassword));
		seller = (Seller) c.uniqueResult();
		return seller;
	}

	/** 修改注册商户信息 */
	public void updateSeller(Seller seller) {
		if(seller!=null){
			getSession().update(seller);
			//getSession().saveOrUpdate(user);
			//getSession().createQuery("update User set userNiceName="+user.getUserNiceName()+" where userid="+user.getUserid()).executeUpdate();
		}
	}

	/** 浏览注册商户*/
	@SuppressWarnings("unchecked")
	public List<Seller> browseSeller() {
		List<Seller> list = null;
		Criteria c = getSession().createCriteria(Seller.class);
		c.addOrder(Order.asc("sellerId"));
		list = c.list();
		return list;
	}

	/** 删除注册商户 */
	public void delSeller(Integer sellerid) {
		Seller seller = (Seller) getSession().get(Seller.class, sellerid);
		if(seller!=null){
			getSession().delete(seller);
		}
	}

	/** 装载注册商户*/
	public Seller loadSeller(Integer sellerid) {
		Seller seller=null;
		seller= (Seller) getSession().get(Seller.class, sellerid);
		return seller;
	}


	/**
	 * 查询注册商户
	 */
	@SuppressWarnings("unchecked")
	public List<Seller> searchSeller(String hql) {
		List<Seller> list = null;
		Query query = getSession().createQuery(hql);
		list = query.list();
		return list;
	}

	/**
	 * 找回商户
	 */
	public Seller RetrieveAccount(String sellerName) {
		Seller seller = null;
		Criteria c = getSession().createCriteria(Seller.class);
		Disjunction dis=Restrictions.disjunction();//逻辑或or
		dis.add(Restrictions.eq("sellerEmail", sellerName));
		dis.add(Restrictions.eq("sellerPhone", sellerName));
		c.add(dis);
		seller = (Seller) c.uniqueResult();
		return seller;
	}

}