package com.yayao.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 收货人信息
 * @author yy
 *
 */
public class Consignee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Fields
	/**
	 * 会员主键
	 */
	private Integer id;
	
	/**
	 * 收货姓名
	 */
	private String receiptName;
	/**
	 * 电话号码
	 */
	private String telePhone;
	/**
	 * 手机号码
	 */
	private String cellPhone;
	/**
	 * 
	*送货地址
	*/
	private String address;
	/**
	 * 邮编
	 */
	private String zip;
	/**
	 * 所属会员
	 */
	private Member member;
	/**
	 * 是否有订单，0表示没有，1表示有
	 */
	private Integer hasOrder;
	/**
	 * 订单列表
	 */
	private Set orders=new HashSet();
	
	public Consignee() {
		
	}


	public Consignee(Integer id, String receiptName, String telePhone,
			String cellPhone, String address, String zip, Member member, Set orders, Integer hasOrder) {
		super();
		this.id = id;
		this.receiptName = receiptName;
		this.telePhone = telePhone;
		this.cellPhone = cellPhone;
		this.address = address;
		this.zip = zip;
		this.member=member;
	    this.orders=orders;
	    this.hasOrder=hasOrder;
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}




	public String getTelePhone() {
		return telePhone;
	}



	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}



	public String getCellPhone() {
		return cellPhone;
	}



	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}



	public String getReceiptName() {
		return receiptName;
	}



	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Set getOrders() {
		return orders;
	}


	public void setOrders(Set orders) {
		this.orders = orders;
	}


	public Integer getHasOrder() {
		return hasOrder;
	}


	public void setHasOrder(Integer hasOrder) {
		this.hasOrder = hasOrder;
	}

	
}
