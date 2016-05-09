package com.yayao.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="merchandise_tb",catalog="YaYaoMall_db")
@JsonIgnoreProperties({"merchandiseimgs","merComments"})
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
	private Double merchandiseOldPrice;
	/**
	 * 商品真实价格
	 */
	private Double merchandisePrice;
	/**
	 * 商品销量
	 */
	private Integer merchandiseSold;
	/**
	 * 商品折扣
	 */
	private Double merDiscount;
	/**
	 * 商品邮费  0包邮 ,其他为价格
	 */
	private Double merchandisePostage;
	/**
	 * 商品编码
	 */
	private String merchandiseCode;
	
	/**
	 * 商品转态 上架，下架
	 */
	private String merchandiseStatus;
	/**
	 * 商品图片
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="merchandise")
	@JsonManagedReference
	private List<MerchandiseImg> merchandiseImgs;
	/**
	 * 商品评论
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="merchandise")
	@JsonManagedReference
	private Set<Comments> merComments;
	/**
	 * 商品更新时间
	 */
	private Date merchandiseUpdateTime;
	/**
	 * 卖家
	 */
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="mersellerid")
	@JsonBackReference
	private MerSeller merSeller;
	/**
	 * 商品类别
	 */
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="mercategoryid")
	@JsonBackReference
	private MerCategory merCategory;
	
	
	public Merchandise() {
		super();
	}


	public Merchandise(Integer merchandiseid, String merchandiseName,
			Integer merchandiseStock, Double merchandiseOldPrice,
			Double merchandisePrice, Integer merchandiseSold,
			Double merDiscount, Double merchandisePostage,
			String merchandiseCode, String merchandiseStatus,
			List<MerchandiseImg> merchandiseImgs, MerCategory merCategory,
			Date merchandiseUpdateTime,Set<Comments> merComments,
			MerSeller merSeller) {
		super();
		this.merchandiseid = merchandiseid;
		this.merchandiseName = merchandiseName;
		this.merchandiseStock = merchandiseStock;
		this.merchandiseOldPrice = merchandiseOldPrice;
		this.merchandisePrice = merchandisePrice;
		this.merchandiseSold = merchandiseSold;
		this.merDiscount = merDiscount;
		this.merchandisePostage = merchandisePostage;
		this.merchandiseCode = merchandiseCode;
		this.merchandiseStatus = merchandiseStatus;
		this.merchandiseImgs = merchandiseImgs;
		this.merCategory = merCategory;
		this.merchandiseUpdateTime=merchandiseUpdateTime;
		this.merComments=merComments;
		this.merSeller=merSeller;
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


	public Double getMerchandiseOldPrice() {
		return merchandiseOldPrice;
	}


	public void setMerchandiseOldPrice(Double merchandiseOldPrice) {
		this.merchandiseOldPrice = merchandiseOldPrice;
	}


	public Double getMerchandisePrice() {
		return merchandisePrice;
	}


	public void setMerchandisePrice(Double merchandisePrice) {
		this.merchandisePrice = merchandisePrice;
	}


	public Integer getMerchandiseSold() {
		return merchandiseSold;
	}


	public void setMerchandiseSold(Integer merchandiseSold) {
		this.merchandiseSold = merchandiseSold;
	}


	public Double getMerDiscount() {
		return merDiscount;
	}


	public void setMerDiscount(Double merDiscount) {
		this.merDiscount = merDiscount;
	}


	public Double getMerchandisePostage() {
		return merchandisePostage;
	}


	public void setMerchandisePostage(Double merchandisePostage) {
		this.merchandisePostage = merchandisePostage;
	}


	public String getMerchandiseCode() {
		return merchandiseCode;
	}


	public void setMerchandiseCode(String merchandiseCode) {
		this.merchandiseCode = merchandiseCode;
	}


	public String getMerchandiseStatus() {
		return merchandiseStatus;
	}


	public void setMerchandiseStatus(String merchandiseStatus) {
		this.merchandiseStatus = merchandiseStatus;
	}


	public MerCategory getMerCategory() {
		return merCategory;
	}


	public void setMerCategory(MerCategory merCategory) {
		this.merCategory = merCategory;
	}


	public Date getMerchandiseUpdateTime() {
		return merchandiseUpdateTime;
	}


	public void setMerchandiseUpdateTime(Date merchandiseUpdateTime) {
		this.merchandiseUpdateTime = merchandiseUpdateTime;
	}


	public Set<Comments> getMerComments() {
		return merComments;
	}


	public void setMerComments(Set<Comments> merComments) {
		this.merComments = merComments;
	}


	public List<MerchandiseImg> getMerchandiseImgs() {
		return merchandiseImgs;
	}


	public void setMerchandiseImgs(List<MerchandiseImg> merchandiseImgs) {
		this.merchandiseImgs = merchandiseImgs;
	}


	public MerSeller getMerSeller() {
		return merSeller;
	}


	public void setMerSeller(MerSeller merSeller) {
		this.merSeller = merSeller;
	}
	
	
}
