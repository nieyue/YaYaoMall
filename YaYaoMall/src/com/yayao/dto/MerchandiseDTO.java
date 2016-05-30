package com.yayao.dto;

import java.io.Serializable;
import java.util.Date;
/**
 * 商品数据传输类
 * @author yy
 *
 */
public class MerchandiseDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品分类id
	 */
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
	
	private Integer[] merchandiseImgIds;
	/**
	 * 商品评论
	 */
	private Integer[] commentIds;
	/**
	 * 商品更新时间
	 */
	private Date merchandiseUpdateTime;
	/**
	 * 卖家
	 */
	private Integer sellerId;
	/**
	 * 商品类别
	 */
	private Integer merCategoryId;
	/**
	 * 商品消息
	 */
	private String merchandiseMsg;
	
	
	public MerchandiseDTO() {
		super();
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


	public Integer[] getMerchandiseImgIds() {
		return merchandiseImgIds;
	}


	public void setMerchandiseImgIds(Integer[] merchandiseImgIds) {
		this.merchandiseImgIds = merchandiseImgIds;
	}


	public Integer[] getCommentIds() {
		return commentIds;
	}


	public void setCommentIds(Integer[] commentIds) {
		this.commentIds = commentIds;
	}


	public Date getMerchandiseUpdateTime() {
		return merchandiseUpdateTime;
	}


	public void setMerchandiseUpdateTime(Date merchandiseUpdateTime) {
		this.merchandiseUpdateTime = merchandiseUpdateTime;
	}


	public Integer getSellerId() {
		return sellerId;
	}


	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}


	public Integer getMerCategoryId() {
		return merCategoryId;
	}


	public void setMerCategoryId(Integer merCategoryId) {
		this.merCategoryId = merCategoryId;
	}


	public String getMerchandiseMsg() {
		return merchandiseMsg;
	}


	public void setMerchandiseMsg(String merchandiseMsg) {
		this.merchandiseMsg = merchandiseMsg;
	}


	public Double getMerchandiseDiscount() {
		return merchandiseDiscount;
	}


	public void setMerchandiseDiscount(Double merchandiseDiscount) {
		this.merchandiseDiscount = merchandiseDiscount;
	}
	
}
