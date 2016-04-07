package com.yayao.bean;

import java.util.*;

/**
 * 购物车
 * @author yy
 *
 */
public class Cart implements java.io.Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 商品归属人
	 */
	private Member member;
	/**
	 * 总价钱
	 */
	private Double money;
	/**
	 * 购物车状态
	 */
	private Integer cartStatus;
	/**
	 * 商品集合
	 */
	private Set merchandises = new HashSet();  
	
	public Cart() {
	}

	public Cart(Member member) {
		this.member = member;
	}

	public Cart(Member member, Double money, Integer cartStatus, Set merchandises) {
		this.member = member;
		this.money = money;
		this.cartStatus = cartStatus;
		this.merchandises=merchandises;
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

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Integer getCartStatus() {
		return this.cartStatus;
	}

	public void setCartStatus(Integer cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Set getMerchandises() {
		return merchandises;
	}

	public void setMerchandises(Set merchandises) {
		this.merchandises = merchandises;
	}

}