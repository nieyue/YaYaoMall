package com.yayao.dao;

import com.yayao.bean.*;
import java.util.*;

public interface OrderDao {
	/** 新增订单 */	
	public void addOrder(Orders order) ;
	/** 浏览某会员的所有订单 */
	public List browseOrder(Member member) ;
	/** 浏览所有订单 */
	public List browseOrder();
	/** 浏览某订单的所有商品记录 */
	public List browseOrderMer(Orders order);			
	/** 浏览订单的所有商品记录 */
	public List browseAllOrderMer();			
	/** 删除订单 */	
	public void delOrder(Integer id);	
	/** 装载订单 */	
	public Orders loadOrder(Integer id);
	/** 修改订单 */	
	public void updateOrder(Orders order);
	
}
