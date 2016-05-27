package com.yayao.bean;

import java.util.Date;
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





/**
 *账户类
 * @author yy
 *
 */
@Entity

@Table(name="user_tb",catalog="yayaomall_db")
@JsonIgnoreProperties({"userPassword"})
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 账户主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_id")
	//@GenericGenerator(name="user_id",strategy="native",parameters={})
	//@SequenceGenerator(name="user_id",initialValue=1000,allocationSize=1)
	private Integer userId;
	/**
	 * 邮箱
	 */
	private String userEmail;
	/**
	 * 用户图片
	 */
	private String userImg;
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
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="user")
	@JsonBackReference
	private Set<CardPackage> cardPackages;
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
	@ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="userlevel_id")
	@JsonManagedReference
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
	 * usermessage
	 */
	@Transient
	private String userMsg;
	/**
	 * user token
	 */
	@Transient
	private String userToken;
	/**
	 * 收货地址
	 */
	@Transient
	private Set<UserReceiptAddress> userReceiptAddresss;
	/**
	 * 好友
	 */
	@Transient
	private Set<Friend> friends;
	/**
	 * 订单
	 */
	@Transient
	private Set<Order> orders ;
	/**
	 * 商品收藏
	 */
	@Transient
	private Set<MerCollection> merCollections ;
	/**
	 * 评论
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="user")
	@JsonBackReference
	private Set<Comment> comments;
	
	
	
	public User() {
	}

	public User(Integer userId, String userEmail, String userImg,
			String userNiceName, String userPassword, String userSignature,
			String userPhone, String userIdentity,
			Set<CardPackage> cardPackages, Integer integral, Integer isLogin,
			UserLevel userLevel, Date regDate, Date lastLoginTime,
			String userMsg, String userToken,
			Set<UserReceiptAddress> userReceiptAddresss, Set<Friend> friends,
			Set<Order> orders, Set<MerCollection> merCollections,
			Set<Comment> comments) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userImg = userImg;
		this.userNiceName = userNiceName;
		this.userPassword = userPassword;
		this.userSignature = userSignature;
		this.userPhone = userPhone;
		this.userIdentity = userIdentity;
		this.cardPackages = cardPackages;
		this.integral = integral;
		this.isLogin = isLogin;
		this.userLevel = userLevel;
		this.regDate = regDate;
		this.lastLoginTime = lastLoginTime;
		this.userMsg = userMsg;
		this.userToken = userToken;
		this.userReceiptAddresss = userReceiptAddresss;
		this.friends = friends;
		this.orders = orders;
		this.merCollections = merCollections;
		this.comments = comments;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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

	public Set<CardPackage> getCardPackages() {
		return cardPackages;
	}

	public void setCardPackages(Set<CardPackage> cardPackages) {
		this.cardPackages = cardPackages;
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

	public UserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
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

	public String getUserMsg() {
		return userMsg;
	}

	public void setUserMsg(String userMsg) {
		this.userMsg = userMsg;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Set<UserReceiptAddress> getUserReceiptAddresss() {
		return userReceiptAddresss;
	}

	public void setUserReceiptAddresss(Set<UserReceiptAddress> userReceiptAddresss) {
		this.userReceiptAddresss = userReceiptAddresss;
	}

	public Set<Friend> getFriends() {
		return friends;
	}

	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<MerCollection> getMerCollections() {
		return merCollections;
	}

	public void setMerCollections(Set<MerCollection> merCollections) {
		this.merCollections = merCollections;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	
}