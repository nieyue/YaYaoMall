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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="merchandise_tb",catalog="yayaomall_db")
@JsonIgnoreProperties({"comments"})
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
	private Integer merchandiseId;
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
	 * 商品销售价格
	 */
	private Double merchandisePrice;
	/**
	 * 商品销量
	 */
	private Integer merchandiseSold;
	/**
	 * 商品折扣
	 */
	private Double merchandiseDiscount;
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
	 * 商品图片 商品管理图片
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="merchandise")
	@JsonManagedReference
	private List<MerchandiseImg> merchandiseImgs;
	/**
	 * 商品评论
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="merchandise")
	@JsonBackReference
	private Set<Comment> comments;
	/**
	 * 商品更新时间
	 */
	private Date merchandiseUpdateTime;
	/**
	 * 卖家
	 */
	@ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="seller_id")
	@JsonManagedReference
	private Seller seller;
	/**
	 * 商品类别
	 */
	@ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="mer_category_id")
	@JsonManagedReference
	private MerCategory merCategory;
	/**
	 * 商品消息
	 */
	@Transient
	private String merchandiseMsg;
	
	public Merchandise() {
		super();
	}

	public Merchandise(Integer merchandiseId, String merchandiseName,
			Integer merchandiseStock, Double merchandiseOldPrice,
			Double merchandisePrice, Integer merchandiseSold,
			Double merchandiseDiscount, Double merchandisePostage,
			String merchandiseCode, String merchandiseStatus,
			List<MerchandiseImg> merchandiseImgs, Set<Comment> comments,
			Date merchandiseUpdateTime, Seller seller, MerCategory merCategory,
			String merchandiseMsg) {
		super();
		this.merchandiseId = merchandiseId;
		this.merchandiseName = merchandiseName;
		this.merchandiseStock = merchandiseStock;
		this.merchandiseOldPrice = merchandiseOldPrice;
		this.merchandisePrice = merchandisePrice;
		this.merchandiseSold = merchandiseSold;
		this.merchandiseDiscount = merchandiseDiscount;
		this.merchandisePostage = merchandisePostage;
		this.merchandiseCode = merchandiseCode;
		this.merchandiseStatus = merchandiseStatus;
		this.merchandiseImgs = merchandiseImgs;
		this.comments = comments;
		this.merchandiseUpdateTime = merchandiseUpdateTime;
		this.seller = seller;
		this.merCategory = merCategory;
		this.merchandiseMsg = merchandiseMsg;
	}

	public Integer getMerchandiseId() {
		return merchandiseId;
	}

	public void setMerchandiseId(Integer merchandiseId) {
		this.merchandiseId = merchandiseId;
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

	public Double getMerchandiseDiscount() {
		return merchandiseDiscount;
	}

	public void setMerchandiseDiscount(Double merchandiseDiscount) {
		this.merchandiseDiscount = merchandiseDiscount;
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

	public List<MerchandiseImg> getMerchandiseImgs() {
		return merchandiseImgs;
	}

	public void setMerchandiseImgs(List<MerchandiseImg> merchandiseImgs) {
		this.merchandiseImgs = merchandiseImgs;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Date getMerchandiseUpdateTime() {
		return merchandiseUpdateTime;
	}

	public void setMerchandiseUpdateTime(Date merchandiseUpdateTime) {
		this.merchandiseUpdateTime = merchandiseUpdateTime;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public MerCategory getMerCategory() {
		return merCategory;
	}

	public void setMerCategory(MerCategory merCategory) {
		this.merCategory = merCategory;
	}

	public String getMerchandiseMsg() {
		return merchandiseMsg;
	}

	public void setMerchandiseMsg(String merchandiseMsg) {
		this.merchandiseMsg = merchandiseMsg;
	}

}
