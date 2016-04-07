package com.yayao.service;

import java.util.*;

import com.yayao.bean.*;

public interface ConsigneeService {
	
	/** 新增收货人 */	
	public void addConsignee(Consignee consignee) ;
	/** 修改收货人信息 */	
	public void updateConsignee(Consignee consignee) ;
	
	/** 管理员浏览收货人信息*/
	public List adminBrowseConsignee(Member member) ;
	/** 浏览收货人信息*/
	public List browseConsignee(Member member) ;
	/** 删除收货人信息*/	
	public void delConsignee(Integer id) ;
	/**装载收货人信息 */	
	public Consignee loadConsignee(Integer id) ;	
	
}
