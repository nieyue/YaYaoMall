package com.yayao.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.*;
import com.yayao.dao.CartDao;
import com.yayao.dao.OrderDao;
import com.yayao.service.OrderService;
import com.yayao.util.ActionContextUtil;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    @Qualifier("orderDao")
    private OrderDao orderDao;
    @Autowired
    @Qualifier("cartDao")
    private CartDao cartDao;
	@Override
	public void addOrder(Orders order) {
		orderDao.addOrder(order);
	}

	@Override
	public List browseOrder(Member member) {
		List orders = orderDao.browseOrder(member);
				return orders;
	}

	@Override
	public List browseOrder(){
		List list = orderDao.browseOrder();
		return list;
	}

	/**
	 * 浏览当前会员的所有订单的选购商品
	 */
	public List browseOrderMer(Member member) {
		Map session = ActionContextUtil.getSession();
		List list=new ArrayList();
		List orders = orderDao.browseOrder(member);
		for (int i = 0; i < orders.size(); i++) {
			Orders o=(Orders)orders.get(i);
			List om = orderDao.browseOrderMer(o);
			for (int j = 0; j < om.size(); j++) {
				Cartselectedmer cartselectedmer=(Cartselectedmer) om.get(j);
				list.add(cartselectedmer);
			}
		}
		session.remove("orderMerList");
		session.put("orderMerList", list);
		return list;
	}
	/**
	 * 管理员浏览当前会员的所有订单的选购商品
	 */
	public List adminBrowseOrderMer(Member member){
		Map session = ActionContextUtil.getSession();
		List list=new ArrayList();
		List orders = orderDao.browseOrder(member);
		for (int i = 0; i < orders.size(); i++) {
			Orders o=(Orders)orders.get(i);
			List om = orderDao.browseOrderMer(o);
			for (int j = 0; j < om.size(); j++) {
				Cartselectedmer cartselectedmer=(Cartselectedmer) om.get(j);
				list.add(cartselectedmer);
			}
		}
		session.remove("aOrderMerList");
		session.put("aOrderMerList", list);
		return list;
	}
	/**
	 * 浏览所有订单的选购商品
	 */
	public List browseAllOrderMer() {
		Map session = ActionContextUtil.getSession();
		List list = orderDao.browseAllOrderMer();
		session.remove("allOrderMerList");
		session.put("allOrderMerList", list);
		return list;
	}

	@Override
	public void delOrder(Integer id) {
	 orderDao.delOrder(id);
		
	}

	@Override
	public Orders loadOrder(Integer id)  {
		Orders order = orderDao.loadOrder(id);
		return order;
	}

	@Override
	public void updateOrder(Orders order)  {
		orderDao.updateOrder(order);
	}

	@Override
	public List browseOrderMer(Orders order)  {
		List list = orderDao.browseOrderMer(order);
		return list;
	}

	
}
