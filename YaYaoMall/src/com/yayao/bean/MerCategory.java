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
@Table(name="mer_category_tb",catalog="yayaomall_db")
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
	private Integer merCategoryId;
	/**
	 * 商品分类名称
	 */
	private String merCategoryName;
	/**
	 * 商品分类更新日期
	 */
	private Date merCategoryDate;
	
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
	@JoinColumn(name="seller_id")
	@JsonManagedReference
	private Seller seller;
	/**
	 * 商品类别消息
	 */
	@Transient
	private String merCategoryMsg;
	
	public MerCategory() {
		super();
	}


	public MerCategory(Integer merCategoryId, String merCategoryName,
			Date merCategoryDate, Set<Merchandise> merchandises, Seller seller,
			String merCategoryMsg) {
		super();
		this.merCategoryId = merCategoryId;
		this.merCategoryName = merCategoryName;
		this.merCategoryDate = merCategoryDate;
		this.merchandises = merchandises;
		this.seller = seller;
		this.merCategoryMsg = merCategoryMsg;
	}


	public Integer getMerCategoryId() {
		return merCategoryId;
	}


	public void setMerCategoryId(Integer merCategoryId) {
		this.merCategoryId = merCategoryId;
	}


	public String getMerCategoryName() {
		return merCategoryName;
	}


	public void setMerCategoryName(String merCategoryName) {
		this.merCategoryName = merCategoryName;
	}


	public Date getMerCategoryDate() {
		return merCategoryDate;
	}


	public void setMerCategoryDate(Date merCategoryDate) {
		this.merCategoryDate = merCategoryDate;
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


	public String getMerCategoryMsg() {
		return merCategoryMsg;
	}


	public void setMerCategoryMsg(String merCategoryMsg) {
		this.merCategoryMsg = merCategoryMsg;
	}

	
}
