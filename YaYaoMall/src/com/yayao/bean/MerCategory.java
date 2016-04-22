package com.yayao.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 商品分类
 * @author yy
 *
 */
@Entity
@Table(name="mercategory_tb",catalog="YaYaoMall_db")
@JsonIgnoreProperties({"merchandises"})
public class MerCategory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 商品分类id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mercategoryid;
	/**
	 * 商品分类名称
	 */
	private String cateName;
	/**
	 * 商品分类描述
	 */
	private String cateDesc;
	
	/**
	 * 商品
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="merCategory")
	private Set<Merchandise> merchandises;
	
	
	public MerCategory() {
		super();
	}


	public MerCategory(Integer mercategoryid, String cateName, String cateDesc,
			Set<Merchandise> merchandises) {
		super();
		this.mercategoryid = mercategoryid;
		this.cateName = cateName;
		this.cateDesc = cateDesc;
		this.merchandises = merchandises;
	}


	public Integer getMercategoryid() {
		return mercategoryid;
	}


	public void setMercategoryid(Integer mercategoryid) {
		this.mercategoryid = mercategoryid;
	}


	public String getCateName() {
		return cateName;
	}


	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	public String getCateDesc() {
		return cateDesc;
	}


	public void setCateDesc(String cateDesc) {
		this.cateDesc = cateDesc;
	}


	public Set<Merchandise> getMerchandises() {
		return merchandises;
	}


	public void setMerchandises(Set<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}
	
	
}
