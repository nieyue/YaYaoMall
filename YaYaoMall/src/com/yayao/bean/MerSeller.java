package com.yayao.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 卖家类
 * @author yy
 *
 */
@Entity
@Table(name="merseller_tb",catalog="YaYaoMall_db")
public class MerSeller implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品分类id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mersellerid;
	/**
	 * 商品
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="merSeller")
	@JsonManagedReference
	private Set<Merchandise> merchandises;
	/**
	 * 商品分类
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="merSeller")
	@JsonManagedReference
	private Set<MerCategory> merCategory;
	/**
	 * 邮箱
	 */
	private String sellerEmail;
	/**
	 * 手机号
	 */
	private String sellerPhone;
	/**
	 * 登录密码
	 */
	private String sellerPassword;
	/**
	 * 店铺昵称
	 */
	private String sellerNiceName;
	/**
	 * 店铺轮播图片
	 */
	private String sellerIMGS;
	/**
	 * 店铺宣传信息
	 */
	private String sellerSignature;
	/**
	 * 店铺收藏数
	 */
	private Integer sellerNumber;
	
	
	
	public MerSeller() {
		super();
	}
	public MerSeller(Integer mersellerid, Set<Merchandise> merchandises,
			String sellerEmail, String sellerPhone, String sellerPassword,
			String sellerNiceName, String sellerIMGS, String sellerSignature,
			Integer sellerNumber,Set<MerCategory> merCategory) {
		super();
		this.mersellerid = mersellerid;
		this.merchandises = merchandises;
		this.sellerEmail = sellerEmail;
		this.sellerPhone = sellerPhone;
		this.sellerPassword = sellerPassword;
		this.sellerNiceName = sellerNiceName;
		this.sellerIMGS = sellerIMGS;
		this.sellerSignature = sellerSignature;
		this.sellerNumber = sellerNumber;
		this.merCategory=merCategory;
	}
	public Integer getMersellerid() {
		return mersellerid;
	}
	public void setMersellerid(Integer mersellerid) {
		this.mersellerid = mersellerid;
	}
	public Set<Merchandise> getMerchandises() {
		return merchandises;
	}
	public void setMerchandises(Set<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getSellerPassword() {
		return sellerPassword;
	}
	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}
	public String getSellerNiceName() {
		return sellerNiceName;
	}
	public void setSellerNiceName(String sellerNiceName) {
		this.sellerNiceName = sellerNiceName;
	}
	public String getSellerIMGS() {
		return sellerIMGS;
	}
	public void setSellerIMGS(String sellerIMGS) {
		this.sellerIMGS = sellerIMGS;
	}
	public String getSellerSignature() {
		return sellerSignature;
	}
	public void setSellerSignature(String sellerSignature) {
		this.sellerSignature = sellerSignature;
	}
	public Integer getSellerNumber() {
		return sellerNumber;
	}
	public void setSellerNumber(Integer sellerNumber) {
		this.sellerNumber = sellerNumber;
	}
	public Set<MerCategory> getMerCategory() {
		return merCategory;
	}
	public void setMerCategory(Set<MerCategory> merCategory) {
		this.merCategory = merCategory;
	}
	
}
