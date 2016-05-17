package com.yayao.dao;

import java.util.List;

import com.yayao.bean.Seller;


/**
 * 商家接口
 * @author yy
 *
 */
public interface SellerDao {
	/**商户登录 */
	public Seller merSellerLogin(String sellerName,String sellerPassword);	
	/** 检测登录商户是否有效 */	
	public boolean chkLoginName(String sellerName) ;	
	/** 找回商户 */	
	public Seller RetrieveAccount(String sellerName) ;	
	/** 新增注册商户 */	
	public void addSeller(Seller seller) ;
	/** 修改注册商户信息 */	
	public void updateSeller(Seller seller);
	/** 查询注册商户  */
	public List<Seller> searchSeller(String hql) ;
	/** 浏览注册商户*/
	public List<Seller> browseSeller();
	/** 删除注册商户 */	
	public void delSeller(Integer sellerid);
	/**装载注册商户 */	
	public Seller loadSeller(Integer sellerid);	
	
	
}

