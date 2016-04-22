package com.yayao.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="merchandise_tb",catalog="YaYaoMall_db")
@JsonIgnoreProperties({""})
public class Merchandise implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品分类id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer merchandiseid;
	/**
	 * 商品描述
	 */
	private String merchandiseName;
	/**
	 * 商品库存量
	 */
	private Integer merchandiseStock;
	/**
	 * 商品原始价格
	 */
	private String merchandiseOldPrice;
	/**
	 * 商品真实价格
	 */
	private String merchandisePrice;
	/**
	 * 商品销量
	 */
	private String merchandiseSold;
	/**
	 * 商品折扣
	 */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="merchandiseid",unique=true)
	private MerDiscount merDiscount;
	/**
	 * 商品是否包邮 1不包邮 ，0包邮
	 */
	private Integer merchandiseFreeDeliver;
	/**
	 * 商品编码
	 */
	private Integer merchandiseCode;
	
	/**
	 * 商品转态 上架，下架
	 */
	private String merchandiseStatus;
	/**
	 * 商品图片集合
	 */
	private String merchandiseIMGS;
	/**
	 * 商品类别
	 */
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="mercategoryid")
	private MerCategory merCategory;
	
	
	public Merchandise() {
		super();
	}


	public Merchandise(Integer merchandiseid, String merchandiseName,
			Integer merchandiseStock, String merchandiseOldPrice,
			String merchandisePrice, String merchandiseSold,
			MerDiscount merDiscount, Integer merchandiseFreeDeliver,
			Integer merchandiseCode, String merchandiseStatus,
			String merchandiseIMGS, MerCategory merCategory) {
		super();
		this.merchandiseid = merchandiseid;
		this.merchandiseName = merchandiseName;
		this.merchandiseStock = merchandiseStock;
		this.merchandiseOldPrice = merchandiseOldPrice;
		this.merchandisePrice = merchandisePrice;
		this.merchandiseSold = merchandiseSold;
		this.merDiscount = merDiscount;
		this.merchandiseFreeDeliver = merchandiseFreeDeliver;
		this.merchandiseCode = merchandiseCode;
		this.merchandiseStatus = merchandiseStatus;
		this.merchandiseIMGS = merchandiseIMGS;
		this.merCategory = merCategory;
	}


	public Integer getMerchandiseid() {
		return merchandiseid;
	}


	public void setMerchandiseid(Integer merchandiseid) {
		this.merchandiseid = merchandiseid;
	}


	public String getMerchandiseName() {
		return merchandiseName;
	}


	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}


	public Integer getMerchandiseStock() {
		return merchandiseStock;
	}


	public void setMerchandiseStock(Integer merchandiseStock) {
		this.merchandiseStock = merchandiseStock;
	}


	public String getMerchandiseOldPrice() {
		return merchandiseOldPrice;
	}


	public void setMerchandiseOldPrice(String merchandiseOldPrice) {
		this.merchandiseOldPrice = merchandiseOldPrice;
	}


	public String getMerchandisePrice() {
		return merchandisePrice;
	}


	public void setMerchandisePrice(String merchandisePrice) {
		this.merchandisePrice = merchandisePrice;
	}


	public String getMerchandiseSold() {
		return merchandiseSold;
	}


	public void setMerchandiseSold(String merchandiseSold) {
		this.merchandiseSold = merchandiseSold;
	}


	public MerDiscount getMerDiscount() {
		return merDiscount;
	}


	public void setMerDiscount(MerDiscount merDiscount) {
		this.merDiscount = merDiscount;
	}


	public Integer getMerchandiseFreeDeliver() {
		return merchandiseFreeDeliver;
	}


	public void setMerchandiseFreeDeliver(Integer merchandiseFreeDeliver) {
		this.merchandiseFreeDeliver = merchandiseFreeDeliver;
	}


	public Integer getMerchandiseCode() {
		return merchandiseCode;
	}


	public void setMerchandiseCode(Integer merchandiseCode) {
		this.merchandiseCode = merchandiseCode;
	}


	public String getMerchandiseStatus() {
		return merchandiseStatus;
	}


	public void setMerchandiseStatus(String merchandiseStatus) {
		this.merchandiseStatus = merchandiseStatus;
	}


	public String getMerchandiseIMGS() {
		return merchandiseIMGS;
	}


	public void setMerchandiseIMGS(String merchandiseIMGS) {
		this.merchandiseIMGS = merchandiseIMGS;
	}


	public MerCategory getMerCategory() {
		return merCategory;
	}


	public void setMerCategory(MerCategory merCategory) {
		this.merCategory = merCategory;
	}
	
	
}
