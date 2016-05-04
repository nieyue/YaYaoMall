package com.yayao.dao;

import java.util.List;

import com.yayao.bean.MerSeller;


/**
 * 商家接口
 * @author yy
 *
 */
public interface MerSellerDao {
	/**商户登录 */
	public MerSeller merSellerLogin(String sellerName,String sellerPassword);	
	/** 检测登录商户是否有效 */	
	public boolean chkLoginName(String sellerName) ;	
	/** 找回商户 */	
	public MerSeller RetrieveAccount(String sellerName) ;	
	/** 新增注册商户 */	
	public void addMerSeller(MerSeller merSeller) ;
	/** 修改注册商户信息 */	
	public void updateMerSeller(MerSeller merSeller) ;
	/** 查询注册商户  */
	public List<MerSeller> searchMerSeller(String hql) ;
	/** 浏览注册商户*/
	public List<MerSeller> browseMerSeller() ;
	/** 删除注册商户 */	
	public void delMerSeller(Integer id) ;
	/**装载注册商户 */	
	public MerSeller loadMerSeller(Integer id);	
	
	
}

