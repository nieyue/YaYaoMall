package com.yayao.dao;

import java.util.*;
import com.yayao.bean.*;

public interface ConsigneeDao {
	
	/** 新增收货人 */	
	public void addConsignee(Consignee consignee);
	/** 修改收货人信息 */	
	public void updateConsignee(Consignee consignee) ;
	
	/** 浏览收货人信息*/
	public List browseConsignee() ;
	/** 删除收货人信息*/	
	public void delConsignee(Integer id) ;
	/**装载注册会员 */	
	public Consignee loadConsignee(Integer id) ;	
	
}
