package com.yayao.bean;

/**
 * 商品分类类
 * @author yy
 *
 */

public class Category implements java.io.Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 类别名
	 */
	private String cateName;
	/**
	 * 类别描述
	 */
	private String cateDesc;

	
	public Category() {
	}

	
	public Category(String cateName, String cateDesc) {
		this.cateName = cateName;
		this.cateDesc = cateDesc;
	}

	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCateName() {
		return this.cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateDesc() {
		return this.cateDesc;
	}

	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}

}