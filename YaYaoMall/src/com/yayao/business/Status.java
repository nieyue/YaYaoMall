package com.yayao.business;

import java.io.Serializable;
/**
 * 状态类
 * @author yy
 *
 */
public class Status implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 状态码
	 */
	private Integer status_code;
	/**
	 * 状态描述
	 */
	private String status_desc;
	
	
	public Status() {
		super();
	}


	public Status(Integer status_code, String status_desc) {
		super();
		this.status_code = status_code;
		this.status_desc = status_desc;
	}


	public Integer getStatus_code() {
		return status_code;
	}


	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}


	public String getStatus_desc() {
		return status_desc;
	}


	public void setStatus_desc(String status_desc) {
		this.status_desc = status_desc;
	}
	
}
