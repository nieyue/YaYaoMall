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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 商品评论类
 * @author yy
 *
 */
@Entity
@Table(name="comments_tb",catalog="YaYaoMall_db")
//@JsonIgnoreProperties({""})
public class Comments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 评论id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer commentsid;
	/**
	 * 评论账户
	 */
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	private User user;
	/**
	 * 评论商品
	 */
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="merchandiseid")
	private Merchandise merchandise;
	
	
	
	public Comments() {
		super();
	}
	public Comments(Integer commentsid, User user, Merchandise merchandise) {
		super();
		this.commentsid = commentsid;
		this.user = user;
		this.merchandise = merchandise;
	}
	public Integer getCommentsid() {
		return commentsid;
	}
	public void setCommentsid(Integer commentsid) {
		this.commentsid = commentsid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Merchandise getMerchandise() {
		return merchandise;
	}
	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	
	
	
}
