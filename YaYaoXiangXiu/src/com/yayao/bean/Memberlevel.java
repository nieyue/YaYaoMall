package com.yayao.bean;

/**
 * 会员等级
 * @author yy
 *
 */

public class Memberlevel implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**
	 * 等级名称
	 */
	private String levelName;
	/**
	 * 会员利率
	 */
	private Integer favourable;

	
	public Memberlevel() {
	}

	
	public Memberlevel(String levelName, Integer favourable) {
		this.levelName = levelName;
		this.favourable = favourable;
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Integer getFavourable() {
		return this.favourable;
	}

	public void setFavourable(Integer favourable) {
		this.favourable = favourable;
	}

}