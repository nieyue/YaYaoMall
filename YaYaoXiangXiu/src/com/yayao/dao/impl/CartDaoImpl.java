package com.yayao.dao.impl;


import java.util.*;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yayao.bean.*;
import com.yayao.dao.CartDao;
import com.yayao.util.*;
@Repository("cartDao")
public class CartDaoImpl extends BaseLog implements CartDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
		//return sessionFactory.openSession();
		
	}

	/** 选购商品 */	
	public void addCart(Member member, Merchandise mer, int number){
			Cartselectedmer sel = null;
			int favourable = member.getMemberlevel().getFavourable().intValue();			
			//判断该会员是否已经有使用中的购物车
			String hql ="from Cart as a where a.member=:member and a.cartStatus=0";
			Query query = getSession().createQuery(hql);
			query.setEntity("member", member);
			query.setMaxResults(1);
			Cart cart = (Cart)query.uniqueResult();
     if (cart==null){
				cart = new Cart();
				cart.setCartStatus(new Integer(0));
				cart.setMember(member);
				if (mer.getSpecial().intValue()==1){//特价商品
					cart.setMoney(Math.round((number*mer.getSprice().doubleValue())*100)/100.0);
				}else{//普通商品
					cart.setMoney(Math.round((number*mer.getPrice().doubleValue()*favourable/100)*100)/100.0);
				}
				//cart.getMerchandises().add(mer);
				Cartselectedmer csm=new Cartselectedmer();
				csm.setCart(cart);
				csm.setMerchandise(mer);
				csm.setOrderStatus(new Integer(0));//0：取消的订单，1：以下的订单，2：已经发货的订单，3：交易完成
				csm.setNumber(Integer.valueOf(number));
				if (mer.getSpecial().intValue()==1){//特价商品
					csm.setPrice(mer.getSprice());
					csm.setMoney(Math.round((number*mer.getSprice().doubleValue())*100)/100.0);
				}else{//普通商品
					csm.setPrice(Math.round((mer.getPrice().doubleValue()*favourable/100)*100)/100.0);
					csm.setMoney(Math.round((number*mer.getPrice().doubleValue()*favourable/100)*100)/100.0);
				}
				getSession().save(cart);
				getSession().save(csm);
			}else{				
				//如果选购的是已经选购过的商品则只增加商品数量即可
				hql = "select a from Cartselectedmer as a where a.cart=:cartid and a.merchandise=:merid order by a.id desc";
				query = getSession().createQuery(hql);
				query.setInteger("cartid", cart.getId().intValue());
				query.setInteger("merid", mer.getId().intValue());
				query.setMaxResults(1);
				sel = (Cartselectedmer)query.uniqueResult();
				int total = number;
				System.out.println((total*mer.getPrice().doubleValue()*favourable/100));
				//更改购物车选择的商品数目金额等
				if(sel!=null){
					total = number+sel.getNumber().intValue();
					sel.setNumber(Integer.valueOf(total));
					if (mer.getSpecial().intValue()==1){//特价商品
						sel.setPrice(mer.getSprice());
						sel.setMoney(Math.round((total*mer.getSprice().doubleValue())*100)/100.0);
					}else{//普通商品
						sel.setPrice(Math.round((mer.getPrice().doubleValue()*favourable/100)*100)/100.0);
						sel.setMoney(Math.round((total*mer.getPrice().doubleValue()*favourable/100)*100)/100.0);
					}						
					getSession().update(sel);
					/*Query hql2=getSession().createQuery(
							" UPDATE Cartselectedmer sel "+
									" SET sel.cart=?, "+
									" sel.merchandise=?, "+
									" sel.number=?, "+
									" sel.price=?, "+
									" sel.orderStatus=?, "+
									" sel.money=? "+
									" WHERE sel.id=? "
							);
					hql2.setEntity(0, sel.getCart());
					hql2.setEntity(1, sel.getMerchandise());
					hql2.setInteger(2,sel.getNumber());
					hql2.setDouble(3,sel.getPrice());
					hql2.setInteger(4,sel.getOrderStatus());
					hql2.setDouble(5,sel.getMoney());
					hql2.setInteger(6,sel.getId());
					hql2.executeUpdate();*/
				}
				
				//更改购物车金额等
				if (mer.getSpecial().intValue()==1){//特价商品
					cart.setMoney(Math.round((cart.getMoney().doubleValue()+number*mer.getSprice().doubleValue())*100)/100.0);
				}else{//普通商品
					cart.setMoney(Math.round((cart.getMoney().doubleValue()+number*mer.getPrice().doubleValue()*favourable/100)*100)/100.0);
				}				
				getSession().update(cart);
				/*Query hql3=getSession().createQuery(
						" UPDATE Cart cart "+
								" SET cart.money=?, "+
								" cart.cartStatus=? "+
								" WHERE cart.id=? "
						);
				hql3.setDouble(0, cart.getMoney());
				hql3.setInteger(1, cart.getCartStatus());
				hql3.setInteger(2,cart.getId());
				hql3.executeUpdate();*/

			//如果是尚未选购过的则要新添购选商品
			if(sel==null){
				Cartselectedmer csm=new Cartselectedmer();
				csm.setCart(cart);
				csm.setMerchandise(mer);
				csm.setOrderStatus(new Integer(0));//0：取消的订单，1：以下的订单，2：已经发货的订单，3：交易完成
				csm.setNumber(Integer.valueOf(number));
				if (mer.getSpecial().intValue()==1){//特价商品
					csm.setPrice(mer.getSprice());
					csm.setMoney(Math.round((number*mer.getSprice().doubleValue())*100)/100.0);
				}else{//普通商品
					csm.setPrice(Math.round((mer.getPrice().doubleValue()*favourable/100)*100)/100.0);
					csm.setMoney(Math.round((number*mer.getPrice().doubleValue()*favourable/100)*100)/100.0);
				}
				getSession().save(csm);
			}			
			
			}
          
	}

	/** 查看购物车中的选购商品 */
	public List browseCart(Member member){
		List result = null;
			//取得该会员的使用中购物车ID
			//Integer cartid = new Integer(0);
			String hql ="from Cart as a where a.member=:member and a.cartStatus=0";
			Query query = getSession().createQuery(hql);
			query.setEntity("member", member);
			query.setMaxResults(1);
			Cart cart = (Cart)query.uniqueResult();
//			if (cart!=null){
//				cartid = cart.getId();
//			}
			if(cart!=null){
			//浏览购物车中的所有选购记录
			hql ="from Cartselectedmer as a where a.cart=:cart";
			query = getSession().createQuery(hql);
			query.setEntity("cart", cart);
			result = query.list();
			}
			return result;
	}

	/** 清空购物车 */
	public void clearCart(Member member){
			//取得该会员的使用中购物车ID
		   // Integer cartid = new Integer(0);
			String hql ="from Cart as a where a.member=:member and a.cartStatus=0";
			Query query = getSession().createQuery(hql);
			query.setEntity("member", member);
			query.setMaxResults(1);
			Cart cart = (Cart)query.uniqueResult();
			if (cart!=null){
			//	cartid = cart.getId();
				cart.setMoney(Double.valueOf(0));
				getSession().update(cart);
				/*Query hql2=getSession().createQuery(
						" UPDATE Cart cart "+
								" SET cart.money=?, "+
								" cart.cartStatus=? "+
								" WHERE cart.id=? "
						);
				hql2.setDouble(0, cart.getMoney());
				hql2.setInteger(1, cart.getCartStatus());
				hql2.setInteger(2,cart.getId());
				hql2.executeUpdate();*/
			}
			//删除购物车中的所有选购记录(通过HQL进行批量删除)			
			String hql3 ="delete from Cartselectedmer where cart=:cart";
			Query q=getSession().createQuery(hql3);
			q.setEntity("cart", cart);
			q.executeUpdate();
	}

	/** 调整选购商品的数量 */
	public void modiCart(Integer id, int number) {
			//修改指定的选购记录
			double diff = 0;
			//Integer cartid = new Integer(0);
			Cartselectedmer sel = (Cartselectedmer)getSession().get(Cartselectedmer.class, id);			
			Cart cart = sel.getCart();
			if (sel!=null){
				diff = (number - sel.getNumber().intValue())*sel.getPrice().doubleValue();//获取增加或减少商品的总价钱
				sel.setNumber(Integer.valueOf(number));
				sel.setMoney(Math.round(Double.valueOf(sel.getPrice().doubleValue()*number)*100)/100.0);
				getSession().update(sel);
				/*Query hql=getSession().createQuery(
						" UPDATE Cartselectedmer sel "+
								" SET sel.cart=?, "+
								" sel.merchandise=?, "+
								" sel.number=?, "+
								" sel.price=?, "+
								" sel.orderStatus=?, "+
								" sel.money=? "+
								" WHERE sel.id=? "
						);
				hql.setEntity(0, sel.getCart());
				hql.setEntity(1, sel.getMerchandise());
				hql.setInteger(2,sel.getNumber());
				hql.setDouble(3,sel.getPrice());
				hql.setInteger(4,sel.getOrderStatus());
				hql.setDouble(5,sel.getMoney());
				hql.setInteger(6,sel.getId());
				hql.executeUpdate();*/
			}
			

			//更新购物车总金额
			if (cart!=null){
				cart.setMoney(Math.round(Double.valueOf(cart.getMoney().doubleValue()+diff)*100)/100.0);
				getSession().update(cart);
				/*Query hql=getSession().createQuery(
						" UPDATE Cart cart "+
								" SET cart.money=?, "+
								" cart.cartStatus=? "+
								" WHERE cart.id=? "
						);
				hql.setDouble(0, cart.getMoney());
				hql.setInteger(1, cart.getCartStatus());
				hql.setInteger(2,cart.getId());
				hql.executeUpdate();*/
			}
	}

	/** 删除已选购商品 */	
	public void delCart(Integer id){
			//删除指定的选购记录
			double money = 0;
			Integer cartid = new Integer(0);
			Cartselectedmer sel = (Cartselectedmer)getSession().get(Cartselectedmer.class, id);			
			if (sel!=null){
				money = sel.getMoney().doubleValue();
				cartid = sel.getCart().getId();
				//getSession().delete(sel);
				Query hql=getSession().createQuery(" DELETE from Cartselectedmer sel WHERE sel.id=? ");
				hql.setInteger(0,id);
				hql.executeUpdate();
			}
			

			//更新购物车总金额
			Cart cart = (Cart)getSession().get(Cart.class, cartid);
			if (cart!=null){
				cart.setMoney(Math.round(Double.valueOf(cart.getMoney().doubleValue()-money)*100)/100.0);
				getSession().update(cart);
				/*Query hql=getSession().createQuery(
						" UPDATE Cart cart "+
								" SET cart.money=?, "+
								" cart.cartStatus=? "+
								" WHERE cart.id=? "
						);
				hql.setDouble(0, cart.getMoney());
				hql.setInteger(1, cart.getCartStatus());
				hql.setInteger(2,cart.getId());
				hql.executeUpdate();*/
			}
	}

	/** 装载指定会员的购物车 */
	public Cart loadCart(Member member) {
		Cart cart = null;
			//取得该会员的使用中购物车
			String hql ="from Cart as a where a.member=:member and a.cartStatus=0";
			Query query =getSession().createQuery(hql);
			query.setEntity("member", member);
			query.setMaxResults(1);
			cart = (Cart)query.uniqueResult();
		return cart;
	}

	/** 更新购物车 */
	public void updateCart(Cart cart) {
			getSession().update(cart);
			/*Query hql=getSession().createQuery(
					" UPDATE Cart cart "+
							" SET cart.money=?, "+
							" cart.cartStatus=? "+
							" WHERE cart.id=? "
					);
			hql.setDouble(0, cart.getMoney());
			hql.setInteger(1, cart.getCartStatus());
			hql.setInteger(2,cart.getId());
			hql.executeUpdate();*/
	}

	/**
	 * 向选购商品插入订单ID ,改订单状态为1，已经下单
	 */
	public void insertOrder(Orders order,Cartselectedmer sel) {
	
			//getSession().update(cart);
			Query hql=getSession().createQuery(
					" UPDATE Cartselectedmer sel "+
							" SET sel.order=?, "+
							"sel.orderStatus=? "+
							" WHERE sel.id=? "
					);
			hql.setEntity(0, order);
			hql.setInteger(1,sel.getOrderStatus());
			hql.setInteger(2,sel.getId());
			hql.executeUpdate();
	}

	/**
	 * 删除购物车自己
	 */
	public void delCartSelf(Integer id) {
	
			Query hql=getSession().createQuery("DELETE from Cart cc WHERE cc.id=? ");
			hql.setInteger(0,id);
			hql.executeUpdate();
			
	}

	/** 装载指定选购商品 */	
	public Cartselectedmer loadCartselectedmer(Integer id) {
		
		Cartselectedmer sel=null;
		
			Query hql=getSession().createQuery("from Cartselectedmer WHERE id=:id");
			hql.setInteger("id",id);
			sel =(Cartselectedmer) hql.uniqueResult();
		return sel;
	}

	/**
	 * 修改订单状态
	 */
	public void updateOrderStatus(Integer orderStatus,Integer id) {
		
			Query hql=getSession().createQuery("UPDATE Cartselectedmer SET orderStatus=? where id=?");
			hql.setInteger(0,orderStatus);
			hql.setInteger(1,id);
			hql.executeUpdate();
	}

	/**
	 * 查询普通订单（1到多个）
	 */
	public List searchOrder(String sql)  {
		List l=null;
		
			Query q = getSession().createSQLQuery(sql).addEntity(Cartselectedmer.class);
			l = q.list();
		return l;
	}
	
}
