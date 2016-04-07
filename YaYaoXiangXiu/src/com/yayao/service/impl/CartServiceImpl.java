package com.yayao.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.*;
import com.yayao.dao.CartDao;
import com.yayao.dao.MerDao;
import com.yayao.service.CartService;
import com.yayao.util.ActionContextUtil;
@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	@Qualifier("cartDao")
	private CartDao cartDao;
	@Autowired
	@Qualifier("merDao")
	private MerDao merDao;

	@Override
	public void addCart(Member member, Merchandise mer, int number)
			 {
		 cartDao.addCart(member, mer, number);
		
	}

	@Override
	public List browseCart(Member member) {
		 Map session = ActionContextUtil.getSession();
		List l=cartDao.browseCart(member);
		List list=new ArrayList();
		Double totleMoney=0.0;
		if(l!=null){
		for (int i = 0; i < l.size(); i++) {
			Cartselectedmer sel = (Cartselectedmer) l.get(i);
			//Merchandise mer=merDao.loadMer(sel.getMerchandise().getId());
			totleMoney+=sel.getMoney();
			list.add(sel);
		}
		session.put("cartSelectedMerList", list);
		session.put("totalMoney", totleMoney);
		}
		return list;
		
	}

	@Override
	public void clearCart(Member member)  {
		cartDao.clearCart(member);
	}

	@Override
	public void modiCart(Integer id, int number) {
		cartDao.modiCart(id, number);
	}

	@Override
	public void delCart(Integer id) {
		 cartDao.delCart(id);
	}

	@Override
	public Cart loadCart(Member member) {
		Cart c = cartDao.loadCart(member);
		return c;
	}

	@Override
	public void updateCart(Cart cart){
		 cartDao.updateCart(cart);
		
	}

	@Override
	public void insertOrder(Orders order, Cartselectedmer sel)
			{
		 cartDao.insertOrder(order, sel);
		
	}

	@Override
	public void delCartSelf(Integer id) {
	     cartDao.delCartSelf(id);
	}

	@Override
	public Cartselectedmer loadCartselectedmer(Integer id) {
		Cartselectedmer sel = cartDao.loadCartselectedmer(id);
		return sel;
	}

	@Override
	public void updateOrderStatus(Integer orderStatus,Integer id) {
		 cartDao.updateOrderStatus(orderStatus,id);
	}

	@Override
	public List searchOrder(String sql){
		List l = cartDao.searchOrder(sql);
		return l;
	}

}
