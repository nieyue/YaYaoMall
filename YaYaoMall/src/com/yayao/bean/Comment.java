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

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 商品评论类
 * @author yy
 *
 */
@Entity
@Table(name="comment_tb",catalog="yayaomall_db")
public class Comment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 评论id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer commentId;
	/**
	 * 评论账户
	 */
	@ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="userid")
	@JsonManagedReference
	private User user;
	/**
	 * 评论商品
	 */
	@ManyToOne(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinColumn(name="merchandiseid")
	@JsonManagedReference
	private Merchandise merchandise;
	/**
	 * 评论时间
	 */
	private Date commentTime;
	
	
	
	public Comment() {
		super();
	}
	public Comment(Integer commentId, User user, Merchandise merchandise
			,Date commentTime) {
		super();
		this.commentId = commentId;
		this.user = user;
		this.merchandise = merchandise;
		this.commentTime=commentTime;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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
	public Date getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	
	
	
}
