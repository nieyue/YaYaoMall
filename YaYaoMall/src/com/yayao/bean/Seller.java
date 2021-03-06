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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 卖家类
 * @author yy
 *
 */
@Entity
@Table(name="seller_tb",catalog="yayaomall_db")
@JsonIgnoreProperties(value="sellerPassword")
public class Seller implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 店铺id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sellerId;
	/**
	 * 商品
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="seller")
	@JsonBackReference
	private Set<Merchandise> merchandises;
	/**
	 * 商品分类
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="seller")
	@JsonBackReference
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
	 * 店铺图片
	 */
	private String sellerImg;
	/**
	 * 店铺宣传信息
	 */
	private String sellerSignature;
	/**
	 * 店铺收藏数
	 */
	private Integer sellerNumber;
	/**
	 * 是否企业认证商户默认为0，未认证
	 */
	private Integer isAuthentication;
	/**
	 * 注册时间
	 */
	private Date registerDate;
	/**
	 * 认证时间
	 */
	private Date authenticationDate;
	/**
	 * sellermessage
	 */
	@Transient
	private String sellerMsg;
	/**
	 * selle TOKEN
	 */
	@Transient
	private String sellerToken;
	
	
	
	public Seller() {
		super();
	}
	public Seller(Integer sellerId, Set<Merchandise> merchandises,
			String sellerEmail, String sellerPhone, String sellerPassword,
			String sellerNiceName, String sellerImg, String sellerSignature,
			Integer sellerNumber,Set<MerCategory> merCategory, Integer isAuthentication,
			Date registerDate,Date authenticationDate,String sellerMsg,String sellerToken) {
		super();
		this.sellerId = sellerId;
		this.merchandises = merchandises;
		this.sellerEmail = sellerEmail;
		this.sellerPhone = sellerPhone;
		this.sellerPassword = sellerPassword;
		this.sellerNiceName = sellerNiceName;
		this.sellerImg = sellerImg;
		this.sellerSignature = sellerSignature;
		this.sellerNumber = sellerNumber;
		this.merCategory=merCategory;
		this.setIsAuthentication(isAuthentication);
		this.registerDate=registerDate;
		this.authenticationDate=authenticationDate;
		this.sellerMsg=sellerMsg;
		this.sellerToken=sellerToken;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
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
	public Integer getIsAuthentication() {
		return isAuthentication;
	}
	public void setIsAuthentication(Integer isAuthentication) {
		this.isAuthentication = isAuthentication;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getAuthenticationDate() {
		return authenticationDate;
	}
	public void setAuthenticationDate(Date authenticationDate) {
		this.authenticationDate = authenticationDate;
	}
	public String getSellerMsg() {
		return sellerMsg;
	}
	public void setSellerMsg(String sellerMsg) {
		this.sellerMsg = sellerMsg;
	}
	public String getSellerToken() {
		return sellerToken;
	}
	public void setSellerToken(String sellerToken) {
		this.sellerToken = sellerToken;
	}
	public String getSellerImg() {
		return sellerImg;
	}
	public void setSellerImg(String sellerImg) {
		this.sellerImg = sellerImg;
	}
	
}
