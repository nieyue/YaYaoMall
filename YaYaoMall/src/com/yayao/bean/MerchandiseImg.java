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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 商品图片类
 * @author yy
 *
 */
@Entity
@Table(name="merchandiseimg_tb",catalog="YaYaoMall_db")
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
	private Integer merchandiseimgid;
	/**
	 * 商品id
	 */
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="merchandiseid")
	@JsonBackReference
	private Merchandise merchandise;
	/**
	 * 商品图片地址
	 */
	private String imgAddress;
	/**
	 * 商品缩略图片地址
	 */
	private String thumbImgAddress;
	
	public MerchandiseImg() {
		super();
	}
	public MerchandiseImg(Integer merchandiseimgid, Merchandise merchandise,
			String imgAddress, String thumbImgAddress) {
		super();
		this.merchandiseimgid = merchandiseimgid;
		this.merchandise = merchandise;
		this.imgAddress = imgAddress;
		this.thumbImgAddress=thumbImgAddress;
	}
	public Integer getMerchandiseimgid() {
		return merchandiseimgid;
	}
	public void setMerchandiseimgid(Integer merchandiseimgid) {
		this.merchandiseimgid = merchandiseimgid;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	public String getImgAddress() {
		return imgAddress;
	}
	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}
	public String getThumbImgAddress() {
		return thumbImgAddress;
	}
	public void setThumbImgAddress(String thumbImgAddress) {
		this.thumbImgAddress = thumbImgAddress;
	}
	
}
