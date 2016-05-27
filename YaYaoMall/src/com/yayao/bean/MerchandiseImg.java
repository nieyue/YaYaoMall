package com.yayao.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 商品图片类
 * @author yy
 *
 */
@Entity
@Table(name="merchandise_img_tb",catalog="yayaomall_db")
public class MerchandiseImg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品图片id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer merchandiseImgId;
	/**
	 * 商品id
	 */
	@ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="merchandise_id")
	@JsonBackReference
	private Merchandise merchandise;
	/**
	 * 商品图片地址
	 */
	private String merchandiseImgAddress;
	/**
	 * 商品缩略图片地址
	 */
	private String merchandiseImgThumbAddress;
	/**
	 * 商品图片排序
	 */
	private Integer merchandiseImgOrder;
	/**
	 * 更新创建时间
	 */
	private Date merchandiseImgUpdateTime;
	/**
	 * 图片消息
	 */
	@Transient
	private String merchandiseImgMsg;
	public MerchandiseImg() {
		super();
	}
	public MerchandiseImg(Integer merchandiseImgId, Merchandise merchandise,
			String merchandiseImgAddress, String merchandiseImgThumbAddress,
			Integer merchandiseImgOrder, Date merchandiseImgUpdateTime,
			String merchandiseImgMsg) {
		super();
		this.merchandiseImgId = merchandiseImgId;
		this.merchandise = merchandise;
		this.merchandiseImgAddress = merchandiseImgAddress;
		this.merchandiseImgThumbAddress = merchandiseImgThumbAddress;
		this.merchandiseImgOrder = merchandiseImgOrder;
		this.merchandiseImgUpdateTime = merchandiseImgUpdateTime;
		this.merchandiseImgMsg = merchandiseImgMsg;
	}
	public Integer getMerchandiseImgId() {
		return merchandiseImgId;
	}
	public void setMerchandiseImgId(Integer merchandiseImgId) {
		this.merchandiseImgId = merchandiseImgId;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	public String getMerchandiseImgAddress() {
		return merchandiseImgAddress;
	}
	public void setMerchandiseImgAddress(String merchandiseImgAddress) {
		this.merchandiseImgAddress = merchandiseImgAddress;
	}
	public String getMerchandiseImgThumbAddress() {
		return merchandiseImgThumbAddress;
	}
	public void setMerchandiseImgThumbAddress(String merchandiseImgThumbAddress) {
		this.merchandiseImgThumbAddress = merchandiseImgThumbAddress;
	}
	public Integer getMerchandiseImgOrder() {
		return merchandiseImgOrder;
	}
	public void setMerchandiseImgOrder(Integer merchandiseImgOrder) {
		this.merchandiseImgOrder = merchandiseImgOrder;
	}
	public Date getMerchandiseImgUpdateTime() {
		return merchandiseImgUpdateTime;
	}
	public void setMerchandiseImgUpdateTime(Date merchandiseImgUpdateTime) {
		this.merchandiseImgUpdateTime = merchandiseImgUpdateTime;
	}
	public String getMerchandiseImgMsg() {
		return merchandiseImgMsg;
	}
	public void setMerchandiseImgMsg(String merchandiseImgMsg) {
		this.merchandiseImgMsg = merchandiseImgMsg;
	}
	
}
