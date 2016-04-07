package com.yayao.bean;


import java.util.ArrayList;
import java.util.List;


/**
 * 商品类
 * @author yy
 *
 */
public class Merchandise implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 商品类型
	 */
	private Category category;
	/**
	 * 商品名称
	 */
	private String merName;
	/**
	 * 商品单价（市场）
	 */
	private Double price;
	/**
	 * 会员价（根据等级来）
	 */
	private Double sprice;
	/**
	 * 商品型号(尺寸)
	 */
	private String merModel;
	/**
	 * 商品图片
	 */
	private String picture;
	/**
	 * 商品描述
	 */
	private String merDesc;
	/**
	 * 制造商
	 */
	private String manufacturer;
	/**
	 * 出厂日期
	 */
	private String leaveFactoryDate;
	/**
	 * 特价为1
	 */
	private Integer special;
	/**
	 * 评论列表
	 */
	List comments=new ArrayList();
	
	
	public Merchandise() {
	}

	
	public Merchandise(Category category) {
		this.category = category;
	}

	public Merchandise(Category category, String merName, Double price,
			Double sprice, String merModel, String picture, String merDesc,
			String manufacturer, String leaveFactoryDate, Integer special, List comments) {
		this.category = category;
		this.merName = merName;
		this.price = price;
		this.sprice = sprice;
		this.merModel = merModel;
		this.picture = picture;
		this.merDesc = merDesc;
		this.manufacturer = manufacturer;
		this.leaveFactoryDate = leaveFactoryDate;
		this.special = special;
		this.comments=comments;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getMerName() {
		return this.merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSprice() {
		return this.sprice;
	}

	public void setSprice(Double sprice) {
		this.sprice = sprice;
	}

	public String getMerModel() {
		return this.merModel;
	}

	public void setMerModel(String merModel) {
		this.merModel = merModel;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String string) {
		this.picture = string;
	}

	public String getMerDesc() {
		return this.merDesc;
	}

	public void setMerDesc(String merDesc) {
		this.merDesc = merDesc;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getLeaveFactoryDate() {
		return this.leaveFactoryDate;
	}

	public void setLeaveFactoryDate(String leaveFactoryDate) {
		this.leaveFactoryDate = leaveFactoryDate;
	}

	public Integer getSpecial() {
		return this.special;
	}

	public void setSpecial(Integer special) {
		this.special = special;
	}


	public List getComments() {
		return comments;
	}


	public void setComments(List comments) {
		this.comments = comments;
	}
	
	
}