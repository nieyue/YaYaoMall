package com.yayao.bean;

import java.util.HashSet;
import java.util.Set;



/**
 *专属定制类
 * @author yy
 *
 */
public class ExclusiveCustom implements java.io.Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 专属定制类主键
	 */
	private Integer id;
	/**
	 * 所属会员
	 */
	private Member member;
	/**
	 * 定制类别
	 */
	private String customCategory;
	/**
	 * 定制者的姓名
	 */
	private String customName;
	/**
	 * 定制日期
	 */
	private String customDate;
	/**
	 * 定制者的电话
	 */
	private String customPhone;
	/**
	 * 上传的定制图片
	 */
	private String customPicture; 
	/**
	 * 详细要求
	 */
	private String customDetails;
	/**
	 * 定制订单编号
	 */
	private String customOrderNumber;
	/**
	 * 定制订单评论
	 */
	private Set comments=new HashSet();

	

	public ExclusiveCustom() {
		
	}




	public ExclusiveCustom(Integer id, Member member, String customCategory,
			String customName, String customDate, String customPhone,
			String customPicture, String customDetails, String customOrderNumber, 
			 Set comments) {
		super();
		this.id = id;
		this.member = member;
		this.customCategory = customCategory;
		this.customName = customName;
		this.customDate = customDate;
		this.customPhone = customPhone;
		this.customPicture = customPicture;
		this.customDetails = customDetails;
		this.customOrderNumber=customOrderNumber;
		this.setComments(comments);
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public Member getMember() {
		return member;
	}




	public void setMember(Member member) {
		this.member = member;
	}




	public String getCustomCategory() {
		return customCategory;
	}




	public void setCustomCategory(String customCategory) {
		this.customCategory = customCategory;
	}




	public String getCustomName() {
		return customName;
	}




	public void setCustomName(String customName) {
		this.customName = customName;
	}




	public String getCustomDate() {
		return customDate;
	}




	public void setCustomDate(String customDate) {
		this.customDate = customDate;
	}




	public String getCustomPhone() {
		return customPhone;
	}




	public void setCustomPhone(String customPhone) {
		this.customPhone = customPhone;
	}




	public String getCustomPicture() {
		return customPicture;
	}




	public void setCustomPicture(String customPicture) {
		this.customPicture = customPicture;
	}




	public String getCustomDetails() {
		return customDetails;
	}




	public void setCustomDetails(String customDetails) {
		this.customDetails = customDetails;
	}
	
	
	public String getCustomOrderNumber() {
		return customOrderNumber;
	}
	
	
	
	
	public void setCustomOrderNumber(String customOrderNumber) {
		this.customOrderNumber = customOrderNumber;
	}
	
	public Set getComments() {
		return comments;
	}




	public void setComments(Set comments) {
		this.comments = comments;
	}


	
}
