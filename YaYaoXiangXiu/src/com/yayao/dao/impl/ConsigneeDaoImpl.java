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
import com.yayao.dao.ConsigneeDao;
import com.yayao.util.BaseLog;
@Repository("consigneeDao")
public class ConsigneeDaoImpl extends BaseLog implements ConsigneeDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
		
	}
	/**
	 * 增加收货人
	 */
	@Override
	public void addConsignee(Consignee consignee)  {
			getSession().save(consignee);
	}
	
	/**
	 * 修改收货人信息
	 */
	@Override
	public void updateConsignee(Consignee consignee) {
		
			/*Query q = getSession().createSQLQuery(
					" UPDATE consignee_tb "+ 
                    " SET ReceiptName=?, "+
					" TelePhone=?, "+
					" CellPhone=?, "+
					" Address=?, "+
					" Zip=? "+
                    " WHERE ID=? ");*/
			/*Query hql = getSession().createQuery(
					" UPDATE Consignee "+ 
							" SET receiptName=?, "+
							" telePhone=?, "+
							" cellPhone=?, "+
							" address=?, "+
							" hasOrder=?, "+
							" zip=? "+
					" WHERE id=? ");

			hql.setString(0, consignee.getReceiptName());
			hql.setString(1, consignee.getTelePhone());
			hql.setString(2, consignee.getCellPhone());
			hql.setString(3, consignee.getAddress());
			hql.setInteger(4, consignee.getHasOrder());
			hql.setString(5, consignee.getZip());
			hql.setInteger(6, consignee.getId());
			hql.executeUpdate();*/
		getSession().merge(consignee);
			
	}

	/**
	 * 浏览收货人信息
	 */
	@Override
	public List browseConsignee(){
		Criteria c = getSession().createCriteria(Consignee.class);		
		c.addOrder(Order.asc("id"));
		List list=c.list();
		return list;
	}

	/**
	 * 删除收货人信息
	 */
	@Override
	public void delConsignee(Integer id)  {
			//Query q = getSession().createSQLQuery(" delete from consignee_tb  where id=:id ");
			Query hql = getSession().createQuery(" delete from Consignee  where id=:id ");
			hql.setInteger("id", id);
			hql.executeUpdate();
	}
	
	/**
	 * 装载收货人信息
	 */
	@Override
	public Consignee loadConsignee(Integer id)  {
		Consignee consignee = (Consignee)getSession().get(Consignee.class, id);
		return consignee;
	}

}
