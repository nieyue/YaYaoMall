package com.yayao.bean;

import java.util.Date;
/**
 * 留言评论
 * @author yy
 *
 */

public class Comment implements java.io.Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 评论的会员
	 */
	private Member member;
	/**
	 * 评论的管理员
	 */
	private Admin admin;
	/**
	 * 评论的标题
	 */
	private String title;
	/**
	 * 评论的内容
	 */
	private String content;
	/**
	 * 评论的日期
	 */
	private String commentDate;
	/**
	 * 回复的内容
	 */
	private String answerContent;
	/**
	 * 回复的日期
	 */
	private String answerDate;
	/**
	 * 所评论的商品
	 */
	private Merchandise merchandise;
	/**
	 * 所评论的定制
	 */
	private ExclusiveCustom exclusiveCustom;
	
	
	
	public Comment() {
	}

	
	public Comment(Member member) {
		this.member = member;
	}

	
	


	public Comment(Integer id, Member member, Admin admin, String title,
			String content, String commentDate, String answerContent,
			String answerDate, Merchandise merchandise, ExclusiveCustom exclusiveCustom) {
		super();
		this.id = id;
		this.member = member;
		this.admin = admin;
		this.title = title;
		this.content = content;
		this.commentDate = commentDate;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
		this.merchandise = merchandise;
		this.exclusiveCustom=exclusiveCustom;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommentDate() {
		return this.commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getAnswerContent() {
		return this.answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getAnswerDate() {
		return this.answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}


	public Merchandise getMerchandise() {
		return merchandise;
	}


	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}
	
	public ExclusiveCustom getExclusiveCustom() {
		return exclusiveCustom;
	}
	
	
	public void setExclusiveCustom(ExclusiveCustom exclusiveCustom) {
		this.exclusiveCustom = exclusiveCustom;
	}
	

}