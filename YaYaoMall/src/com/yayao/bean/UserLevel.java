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

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * 账户等级
 * @author yy
 *
 */
@Entity
@Table(name="userlevel_tb",catalog="YaYaoMall_db")
public class UserLevel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 账户等级id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userlevelid;
	/**
	 * 账户等级名称
	 */
	private String levelName;
	/**
	 * 账户利率
	 */
	private Integer favourable;
	
	/**
	 * 账户
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="userLevel")
	/*@JoinColumn(name="userlevelid")*/
	@JsonManagedReference
	private Set<User> users;
	
	
	public UserLevel() {
		super();
	}
	
	

	public UserLevel(Integer userlevelid, String levelName, Integer favourable,
			Set<User> users) {
		super();
		this.userlevelid = userlevelid;
		this.levelName = levelName;
		this.favourable = favourable;
		this.users = users;
	}



	public Integer getUserlevelid() {
		return userlevelid;
	}


	public void setUserlevelid(Integer userlevelid) {
		this.userlevelid = userlevelid;
	}


	public String getLevelName() {
		return levelName;
	}


	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}


	public Integer getFavourable() {
		return favourable;
	}


	public void setFavourable(Integer favourable) {
		this.favourable = favourable;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}


	
}
