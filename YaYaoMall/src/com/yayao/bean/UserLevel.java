package com.yayao.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 账户等级
 * @author yy
 *
 */
@Entity
@Table(name="userlevel_tb",catalog="YaYaoMall_db")
/*@JsonIgnoreProperties({"users"})*/
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
	 * 账户等级级别
	 */
	private Integer userGrade;
	/**
	 * 账户
	 */
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinColumn(name="userlevelid")
	private Set<User> users;
	
	
	public UserLevel() {
		super();
	}


	public UserLevel(Integer userlevelid, Integer userGrade,Set<User> users) {
		super();
		this.userlevelid = userlevelid;
		this.userGrade = userGrade;
		this.users=users;
	}


	public Integer getUserlevelid() {
		return userlevelid;
	}


	public void setUserlevelid(Integer userlevelid) {
		this.userlevelid = userlevelid;
	}


	public Integer getUserGrade() {
		return userGrade;
	}


	public void setUserGrade(Integer userGrade) {
		this.userGrade = userGrade;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
