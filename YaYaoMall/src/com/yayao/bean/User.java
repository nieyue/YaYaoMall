package com.yayao.bean;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;





/**
 *账户类
 * @author yy
 *
 */
@Entity
@Table(name="user_tb",catalog="YaYaoMall_db")
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 账户主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.AUTO,generator="id")
	//@GenericGenerator(name="id",strategy="assigned")
	private Integer id;
	/**
	 * 账户名
	 */
	private String userName;
	/**
	 * 登录昵称
	 */
	private String userNiceName;
	/**
	 * 登录密码
	 */
	private String userPassword;
	/**
	 * 个性签名
	 */
	private String userSignature;
	/**
	 * 邮箱
	 */
	private String userEmail;
	/**
	 * 手机号
	 */
	private String userPhone;
	/**
	 * 身份证
	 */
	private String userIdentity;
	/**
	 * 卡卷包
	 */
	@Embedded
	private CardPackage cardPackage;
	/**
	 * 积分
	 */
	private Integer integral;
	/**
	 * 是否登录1为登录
	 */
	private Integer isLogin;
	/**
	 * 账户等级
	 */
	@Embedded
	private UserLevel userLevel;
	/**
	 * 注册日期
	 */
	private Date regDate;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	/**
	 * 收货地址
	 */
	@Transient
	private Set<UserReceiptAddress> userReceiptAddress=new HashSet<UserReceiptAddress>();
	/**
	 * 好友
	 */
	@Transient
	private Set<Friends> friends=new HashSet<Friends>();
	/**
	 * 订单
	 */
	@Transient
	private Set<Orders> orders = new HashSet<Orders>();
	/**
	 * 商品收藏
	 */
	@Transient
	private Set<MerCollections> merCollections = new HashSet<MerCollections>();
	/**
	 * 评论
	 */
	@Transient
	private Set<Comments> comments=new HashSet<Comments>();
	
	
	
	public User() {
	}
	
	public User(Integer id, String userName, String userNiceName,
			String userPassword, String userSignature, String userEmail,
			String userPhone, String userIdentity, CardPackage cardPackage,
			Integer integral, Integer isLogin, Date regDate,
			Date lastLoginTime,UserLevel userLevel, Set<UserReceiptAddress> userReceiptAddress,
			Set<Friends> friends, Set<Orders> orders,
			Set<MerCollections> merCollections, Set<Comments> comments) {
		super();
		this.id = id;
		this.userName = userName;
		this.userNiceName = userNiceName;
		this.userPassword = userPassword;
		this.userSignature = userSignature;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userIdentity = userIdentity;
		this.cardPackage = cardPackage;
		this.integral = integral;
		this.isLogin = isLogin;
		this.regDate = regDate;
		this.lastLoginTime = lastLoginTime;
		this.userLevel=userLevel;
		this.userReceiptAddress = userReceiptAddress;
		this.friends = friends;
		this.orders = orders;
		this.merCollections = merCollections;
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNiceName() {
		return userNiceName;
	}

	public void setUserNiceName(String userNiceName) {
		this.userNiceName = userNiceName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	public CardPackage getCardPackage() {
		return cardPackage;
	}

	public void setCardPackage(CardPackage cardPackage) {
		this.cardPackage = cardPackage;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Integer isLogin) {
		this.isLogin = isLogin;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Set<UserReceiptAddress> getUserReceiptAddress() {
		return userReceiptAddress;
	}

	public void setUserReceiptAddress(Set<UserReceiptAddress> userReceiptAddress) {
		this.userReceiptAddress = userReceiptAddress;
	}

	public Set<Friends> getFriends() {
		return friends;
	}

	public void setFriends(Set<Friends> friends) {
		this.friends = friends;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<MerCollections> getMerCollections() {
		return merCollections;
	}

	public void setMerCollections(Set<MerCollections> merCollections) {
		this.merCollections = merCollections;
	}

	public Set<Comments> getComments() {
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}

	public UserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}
	
}