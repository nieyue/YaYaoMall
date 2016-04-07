package com.yayao.dao.impl;


import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.yayao.bean.*;
import com.yayao.dao.OrderDao;
import com.yayao.util.*;
@Repository("orderDao")
public class OrderDaoImpl extends BaseLog implements OrderDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
		
	}

	/** 新增订单 */
	public void addOrder(Orders order) {
			getSession().save(order);
	}

	/** 浏览某会员的所有订单 */
	public List browseOrder(Member member){
		List list = null;
			Query query = getSession().createQuery("from Orders as a where a.member=:member");
			query.setEntity("member", member);
			list = query.list();
		return list;
	}

	/** 浏览所有订单 */
	public List browseOrder(){
		List list = null;
			Query query = getSession().createQuery("from Orders as a order by a.id desc");
			list = query.list();
		return list;
	}

	/** 浏览某订单的所有商品记录 */
	public List browseOrderMer(Orders order){
		List result = null;
			//浏览购物车中的所有选购记录
			String hql ="from Cartselectedmer as a where a.order=:order";
			Query query = getSession().createQuery(hql);
			query.setEntity("order", order);
			result = query.list();
		return result;
	}

	/** 删除订单 */	
	public void delOrder(Integer id)  {
			Query hql=getSession().createQuery(" DELETE from Orders  WHERE id=:id ");
			hql.setInteger("id", id);
			hql.executeUpdate();
	}

	/** 装载订单 */
	public Orders loadOrder(Integer id) {
		Orders order = null;
			order = (Orders)getSession().get(Orders.class, id);
		return order;
	}

	/** 修改订单 */
	public void updateOrder(Orders order){
		getSession().merge(order);
			/*Query hql = getSession().createQuery(
					" UPDATE Orders  o "+ 
							" SET o.orderNumber=?, "+
							" o.orderDate=?, "+
							" o.member=?, "+
							" o.cart=?, "+
							" o.consignee=? "+
					" WHERE o.id=? ");
			hql.setString(0, order.getOrderNumber());
			hql.setString(1, order.getOrderDate());
			hql.setEntity(2, order.getMember());
			hql.setEntity(3, order.getCart());
			hql.setEntity(4, order.getConsignee());
			hql.setInteger(5, order.getId());
			hql.executeUpdate();*/
	}

	/** 浏览订单的所有商品记录 */
	public List browseAllOrderMer() {
		List l=null;
			Query hql = getSession().createQuery("from Cartselectedmer where orderStatus!=0");
			l = hql.list();
		return l;
	}

}
