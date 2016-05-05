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

import com.yayao.bean.MerSeller;
import com.yayao.dao.MerSellerDao;

/**
 * 商户访问实现
 * @author yy
 *
 */
@Repository("merSellerDao")
public class MerSellerDaoImpl implements MerSellerDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		 //return sessionFactory.openSession();
	}

	/** 新增注册商户 */
	public void addMerSeller(MerSeller merSeller) {
		getSession().save(merSeller);

	}

	/** 检测登录商户是否有效 */
	public boolean chkLoginName(String sellerName) {
		boolean status = true;// true代表数据库已经存在
		MerSeller merSeller = null;
		Criteria c = getSession().createCriteria(MerSeller.class);
		Disjunction dis=Restrictions.disjunction();//逻辑或or
		dis.add(Restrictions.eq("sellerEmail", sellerName));
		dis.add(Restrictions.eq("sellerPhone", sellerName));
		c.add(dis);
		merSeller = (MerSeller) c.uniqueResult();
		if (merSeller == null) {
			status = false;
			return status;
		}
		return status;
	}

	/** 商户登录 */
	public MerSeller merSellerLogin(String sellerName, String sellerPassword) {
		MerSeller merSeller = null;
		Criteria c = getSession().createCriteria(MerSeller.class);
		Disjunction dis=Restrictions.disjunction();//逻辑或or
		dis.add(Restrictions.eq("sellerEmail", sellerName));
		dis.add(Restrictions.eq("sellerPhone", sellerName));
		c.add(dis);
		c.add(Restrictions.eq("sellerPassword", sellerPassword));
		merSeller = (MerSeller) c.uniqueResult();
		return merSeller;
	}

	/** 修改注册商户信息 */
	public void updateMerSeller(MerSeller merSeller) {
		if(merSeller!=null){
			getSession().merge(merSeller);
			//getSession().saveOrUpdate(user);
			//getSession().createQuery("update User set userNiceName="+user.getUserNiceName()+" where userid="+user.getUserid()).executeUpdate();
		}
	}

	/** 浏览注册商户*/
	@SuppressWarnings("unchecked")
	public List<MerSeller> browseMerSeller() {
		List<MerSeller> list = null;
		Criteria c = getSession().createCriteria(MerSeller.class);
		c.addOrder(Order.asc("mersellerid"));
		list = c.list();
		return list;
	}

	/** 删除注册商户 */
	public void delMerSeller(Integer id) {
		MerSeller merSeller = (MerSeller) getSession().get(MerSeller.class, id);
		if(merSeller!=null){
			getSession().delete(merSeller);
		}
	}

	/** 装载注册商户*/
	public MerSeller loadMerSeller(Integer id) {
		MerSeller merSeller=null;
		merSeller= (MerSeller) getSession().get(MerSeller.class, id);
		return merSeller;
	}


	/**
	 * 查询注册商户
	 */
	@SuppressWarnings("unchecked")
	public List<MerSeller> searchMerSeller(String hql) {
		List<MerSeller> list = null;
		Query query = getSession().createQuery(hql);
		list = query.list();
		return list;
	}

	/**
	 * 找回商户
	 */
	public MerSeller RetrieveAccount(String sellerName) {
		MerSeller merSeller = null;
		Criteria c = getSession().createCriteria(MerSeller.class);
		Disjunction dis=Restrictions.disjunction();//逻辑或or
		dis.add(Restrictions.eq("sellerEmail", sellerName));
		dis.add(Restrictions.eq("sellerPhone", sellerName));
		c.add(dis);
		merSeller = (MerSeller) c.uniqueResult();
		return merSeller;
	}
}