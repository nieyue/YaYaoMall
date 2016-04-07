package com.yayao.dao;

import com.yayao.bean.*;

import java.util.*;

public interface CartDao {
	/** 选购商品 */	
	public void addCart(Member member,Merchandise mer,int number);
	/** 查看购物车中的选购商品 */
	public List browseCart(Member member);		
	/** 清空购物车 */	
	public void clearCart(Member member) ;		
	/** 调整选购商品的数量 */	
	public void modiCart(Integer id,int number) ;	
	/** 删除已选购商品 */	
	public void delCart(Integer id);
	/** 删除购物车 */	
	public void delCartSelf(Integer id) ;
	/** 装载指定会员的购物车 */	
	public Cart loadCart(Member member) ;
	/** 装载指定选购商品 */	
	public Cartselectedmer loadCartselectedmer(Integer id);
	/** 更新购物车 */	
	public void updateCart(Cart cart) ;
	/** 修改订单状态 */	
	public void updateOrderStatus(Integer orderStatus,Integer id) ;
	/**查询普通订单 */	
	public List searchOrder(String sql);	
	/** 为选购商品添加订单ID */	
	public void insertOrder(Orders order,Cartselectedmer sel);
	
}
