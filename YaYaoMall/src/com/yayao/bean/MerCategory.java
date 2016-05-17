package com.yayao.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 商品分类
 * @author yy
 *
 */
@Entity
@Table(name="mercategory_tb",catalog="YaYaoMall_db")
public class MerCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品分类id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mercategoryid;
	/**
	 * 商品分类名称
	 */
	private String cateName;
	/**
	 * 商品分类更新日期
	 */
	private Date cateDate;
	
	/**
	 * 商品
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="merCategory")
	@JsonBackReference
	private Set<Merchandise> merchandises;
	/**
	 * 卖家
	 */
	@ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="sellerid")
	@JsonManagedReference
	private Seller seller;
	/**
	 * 商品类别消息
	 */
	@Transient
	private String cateMsg;
	
	public MerCategory() {
		super();
	}


	public MerCategory(Integer mercategoryid, String cateName, Date cateDate,
			Set<Merchandise> merchandises,Seller seller,String cateMsg) {
		super();
		this.mercategoryid = mercategoryid;
		this.cateName = cateName;
		this.cateDate = cateDate;
		this.merchandises = merchandises;
		this.seller=seller;
		this.cateMsg=cateMsg;
	}


	public Integer getMercategoryid() {
		return mercategoryid;
	}


	public void setMercategoryid(Integer mercategoryid) {
		this.mercategoryid = mercategoryid;
	}


	public String getCateName() {
		return cateName;
	}


	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	public Set<Merchandise> getMerchandises() {
		return merchandises;
	}


	public void setMerchandises(Set<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}


	public Seller getSeller() {
		return seller;
	}


	public void setSeller(Seller seller) {
		this.seller = seller;
	}


	public Date getCateDate() {
		return cateDate;
	}


	public void setCateDate(Date cateDate) {
		this.cateDate = cateDate;
	}


	public String getCateMsg() {
		return cateMsg;
	}


	public void setCateMsg(String cateMsg) {
		this.cateMsg = cateMsg;
	}
	
	
}
