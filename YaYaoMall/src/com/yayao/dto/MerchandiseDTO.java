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
	 * 商品图片 商品管理图片
	 */
	
	private Integer[] merchandiseImgsid;
	/**
	 * 商品评论
	 */
	private Integer[] merCommentsid;
	/**
	 * 商品更新时间
	 */
	private Date merchandiseUpdateTime;
	/**
	 * 卖家
	 */
	private Integer sellerid;
	/**
	 * 商品类别
	 */
	private Integer merCategoryid;
	/**
	 * 商品消息
	 */
	private String merchandiseMsg;
	
	
	public MerchandiseDTO() {
		super();
	}
	public MerchandiseDTO(Integer merchandiseid, String merchandiseName,
			Integer merchandiseStock, Double merchandiseOldPrice,
			Double merchandisePrice, Integer merchandiseSold,
			Double merDiscount, Double merchandisePostage,
			String merchandiseCode, String merchandiseStatus,
			Integer[] merchandiseImgsid, Integer[] merCommentsid,
			Date merchandiseUpdateTime, Integer sellerid, Integer merCategoryid,
			String merchandiseMsg) {
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
		this.merchandiseImgsid = merchandiseImgsid;
		this.merCommentsid = merCommentsid;
		this.merchandiseUpdateTime = merchandiseUpdateTime;
		this.sellerid = sellerid;
		this.merCategoryid = merCategoryid;
		this.merchandiseMsg = merchandiseMsg;
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
	public Integer[] getMerchandiseImgsid() {
		return merchandiseImgsid;
	}
	public void setMerchandiseImgsid(Integer[] merchandiseImgsid) {
		this.merchandiseImgsid = merchandiseImgsid;
	}
	public Integer[] getMerCommentsid() {
		return merCommentsid;
	}
	public void setMerCommentsid(Integer[] merCommentsid) {
		this.merCommentsid = merCommentsid;
	}
	public Date getMerchandiseUpdateTime() {
		return merchandiseUpdateTime;
	}
	public void setMerchandiseUpdateTime(Date merchandiseUpdateTime) {
		this.merchandiseUpdateTime = merchandiseUpdateTime;
	}
	public Integer getSellerid() {
		return sellerid;
	}
	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}
	public Integer getMerCategoryid() {
		return merCategoryid;
	}
	public void setMerCategoryid(Integer merCategoryid) {
		this.merCategoryid = merCategoryid;
	}
	public String getMerchandiseMsg() {
		return merchandiseMsg;
	}
	public void setMerchandiseMsg(String merchandiseMsg) {
		this.merchandiseMsg = merchandiseMsg;
	}
}
