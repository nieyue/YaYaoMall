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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





/**
 *账户类
 * @author yy
 *
 */
@Entity

@Table(name="user_tb",catalog="YaYaoMall_db")
@JsonIgnoreProperties({"userPassword","cardPackages","userComments"})
public class User implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 账户主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.AUTO,generator="userid")
	//@GenericGenerator(name="userid",strategy="assigned")
	private Integer userid;
	/**
	 * 邮箱
	 */
	private String userEmail;
	/**
	 * 用户图片
	 */
	private String userIMG;
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
	/*@JoinColumn(name="userid")*/
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
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="userlevelid")
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
	 * message
	 */
	@Transient
	private String userMsg;
	/**
	 * 收货地址
	 */
	@Transient
	private Set<UserReceiptAddress> userReceiptAddress;
	/**
	 * 好友
	 */
	@Transient
	private Set<Friends> friends;
	/**
	 * 订单
	 */
	@Transient
	private Set<Orders> orders ;
	/**
	 * 商品收藏
	 */
	@Transient
	private Set<MerCollections> merCollections ;
	/**
	 * 评论
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="user")
	private Set<Comments> userComments;
	
	
	
	public User() {
	}

	public User(Integer userid, String userEmail,String userIMG, String userNiceName,
			String userPassword, String userSignature, String userPhone,
			String userIdentity, Set<CardPackage> cardPackages,
			Integer integral, Integer isLogin, UserLevel userLevel,
			Date regDate, Date lastLoginTime, String userMsg,
			Set<UserReceiptAddress> userReceiptAddress, Set<Friends> friends,
			Set<Orders> orders, Set<MerCollections> merCollections,
			Set<Comments> userComments) {
		super();
		this.userid = userid;
		this.userEmail = userEmail;
		this.userIMG=userIMG;
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
		this.userReceiptAddress = userReceiptAddress;
		this.friends = friends;
		this.orders = orders;
		this.merCollections = merCollections;
		this.userComments = userComments;
	}








	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	public Set<Comments> getUserComments() {
		return userComments;
	}

	public void setUserComments(Set<Comments> userComments) {
		this.userComments = userComments;
	}

	public UserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}


	public String getUserMsg() {
		return userMsg;
	}


	public void setUserMsg(String userMsg) {
		this.userMsg = userMsg;
	}

	public String getUserIMG() {
		return userIMG;
	}

	public void setUserIMG(String userIMG) {
		this.userIMG = userIMG;
	}

	

	
}