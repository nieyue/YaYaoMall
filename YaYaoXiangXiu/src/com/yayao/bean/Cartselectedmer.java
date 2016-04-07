package com.yayao.bean;
/**
 * 购物车中选中的商品类
 * @author yy
 *
 */
public class Cartselectedmer implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 购物车ID
	 */
	private Cart cart;
	/**
	 * 商品ID
	 */
	private Merchandise merchandise;
	/**
	 * 订单ID
	 */
	private Orders order;
	
	/**
	 * 数目
	 */
	private Integer number;
	/**
	 * 单价
	 */
	private Double price;
	/**
	 * 总价
	 */
	private Double money;
	/**
	 * 订单状态
	 */
	private Integer orderStatus;


	public Cartselectedmer() {
	}

	public Cartselectedmer(Cart cart, Merchandise merchandise, Integer number,
			Double price, Double money, Orders order, Integer orderStatus) {
		this.cart = cart;
		this.merchandise = merchandise;
		this.number = number;
		this.price = price;
		this.money = money;
        this.order=order;
        this.orderStatus=orderStatus;
		
	}

	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Merchandise getMerchandise() {
		return this.merchandise;
	}

	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}


	


}