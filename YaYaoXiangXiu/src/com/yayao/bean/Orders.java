package com.yayao.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 订单类
 * @author yy
 *
 */
public class Orders implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 订单所属会员
	 */
	private Member member;
	/**
	 * 订单所属购物车
	 */
	private Cart cart;
	
	/**
	 * 订单所属收货地址
	 */
	private Consignee consignee;
	
	/**
	 * 订单号码
	 */
	private String orderNumber;
	/**
	 * 下单日期
	 */
	private String orderDate;
	/**
	 * 订单状态
	 */
	private Set cartselectedmers=new HashSet();
   

	public Orders() {
	}

	public Orders(Member member, Cart cart ,Consignee consignee) {
		this.member = member;
		this.cart = cart;
		this.consignee=consignee;
	}

	public Orders(Integer id, Member member, Cart cart, Consignee consignee,
			String orderNumber, String orderDate,  Set cartselectedmers) {
		super();
		this.id = id;
		this.member = member;
		this.cart = cart;
		this.consignee=consignee;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.setCartselectedmers(cartselectedmers);
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public Set getCartselectedmers() {
		return cartselectedmers;
	}

	public void setCartselectedmers(Set cartselectedmers) {
		this.cartselectedmers = cartselectedmers;
	}

	public Consignee getConsignee() {
		return consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}


}