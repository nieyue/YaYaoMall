package com.yayao.service;

import java.util.*;

import com.yayao.bean.*;

public interface ExclusiveCustomService {
	
	/** 新增定制 */	
	public void addExclusiveCustom(ExclusiveCustom exclusiveCustom) ;
	/** 修改定制信息 */	
	public void updateExclusiveCustom(ExclusiveCustom exclusiveCustom) ;
	
	/** 浏览所有定制信息*/
	public List browseAllExclusiveCustom() ;
	/** 浏览当前会员定制信息*/
	public List browseExclusiveCustom(Member member) ;
	/** 管理员浏览当前会员定制信息*/
	public List adminBrowseExclusiveCustom(Member member);
	/** 删除定制信息*/	
	public void delExclusiveCustom(Integer id);
	/**装载定制信息 */	
	public ExclusiveCustom loadExclusiveCustom(Integer id) ;	
	/**查询定制订单 */	
	public List searchExclusiveCustom(String hql) ;	
}
