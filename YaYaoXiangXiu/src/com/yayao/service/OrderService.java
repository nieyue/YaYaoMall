package com.yayao.service;

import com.yayao.bean.*;

import java.util.*;

public interface OrderService {
	/** 新增订单 */	
	public void addOrder(Orders order);
	/** 浏览某会员的所有订单 */
	public List browseOrder(Member member);
	/** 浏览所有订单 */
	public List browseOrder();
	/** 浏览某订单的所有商品记录 */
	public List browseOrderMer(Member member);	
	/** 管理员浏览某订单的所有商品记录 */
	public List adminBrowseOrderMer(Member member);	
	/** 浏览所有订单的选购商品*/
	public List browseAllOrderMer();
	/** 根据订单查询选购商品 */
	public List browseOrderMer(Orders order);			
	/** 删除订单 */	
	public void delOrder(Integer id);	
	/** 装载订单 */	
	public Orders loadOrder(Integer id) ;
	/** 修改订单 */	
	public void updateOrder(Orders order);
}
