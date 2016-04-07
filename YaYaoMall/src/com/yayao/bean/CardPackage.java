package com.yayao.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 卡卷包
 * @author yy
 *
 */
@Entity
@Table(name="cardpackage_tb",catalog="YaYaoMall_db")
public class CardPackage implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 卡卷包id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cardpackageid;
	/**
	 * 类型（卡，卷，包）
	 */
	private String cpType;
	/**
	 * 有效时间
	 */
	private String effectiveTime;
	/**
	 * 抵消金额
	 */
	private String offsetAmount;
	/**
	 *账户
	 */
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private User user;
	
	
	public CardPackage() {
		super();
	}

	public CardPackage(Integer cardpackageid, String cpType,
			String effectiveTime, String offsetAmount, User user) {
		super();
		this.cardpackageid = cardpackageid;
		this.cpType = cpType;
		this.effectiveTime = effectiveTime;
		this.offsetAmount = offsetAmount;
		this.user=user;
	}

	public Integer getCardpackageid() {
		return cardpackageid;
	}

	public void setCardpackageid(Integer cardpackageid) {
		this.cardpackageid = cardpackageid;
	}

	public String getCpType() {
		return cpType;
	}

	public void setCpType(String cpType) {
		this.cpType = cpType;
	}

	public String getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(String effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public String getOffsetAmount() {
		return offsetAmount;
	}

	public void setOffsetAmount(String offsetAmount) {
		this.offsetAmount = offsetAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
