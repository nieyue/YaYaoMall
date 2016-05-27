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

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 账户等级
 * @author yy
 *
 */
@Entity
@Table(name="user_level_tb",catalog="yayaomall_db")
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
	private Integer userLevelId;
	/**
	 * 账户等级名称
	 */
	private String userLevelName;
	/**
	 * 账户利率
	 */
	private Integer userLevelFavourable;
	
	/**
	 * 账户
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="userLevel")
	/*@JoinColumn(name="userlevelid")*/
	@JsonBackReference
	private Set<User> users;
	
	
	public UserLevel() {
		super();
	}

	public UserLevel(Integer userLevelId, String userLevelName,
			Integer userLevelFavourable, Set<User> users) {
		super();
		this.userLevelId = userLevelId;
		this.userLevelName = userLevelName;
		this.userLevelFavourable = userLevelFavourable;
		this.users = users;
	}

	public Integer getUserLevelId() {
		return userLevelId;
	}

	public void setUserLevelId(Integer userLevelId) {
		this.userLevelId = userLevelId;
	}

	public String getUserLevelName() {
		return userLevelName;
	}

	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}

	public Integer getUserLevelFavourable() {
		return userLevelFavourable;
	}

	public void setUserLevelFavourable(Integer userLevelFavourable) {
		this.userLevelFavourable = userLevelFavourable;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
