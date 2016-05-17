package com.yayao.service;

import java.util.List;

import com.yayao.bean.MerCategory;
/**
 * 商品分类业务逻辑接口
 * @author yy
 *
 */
public interface MerCategoryService {
	/** 新增商品分类 */	
	public void addMerCategory(MerCategory merCategory) ;
	/** 更新商品分类 */		
	public void updateMerCategory(MerCategory merCategory) ;
	/** 删除指定的商品分类 */	
	public void delMerCategory(Integer sellerid,Integer mercategoryid) ;	
	/** 浏览商户商品分类 */
	public List<MerCategory> browseMerCategory(Integer sellerid) ;
	/** 装载指定商户的商品分类 */
	public MerCategory loadMerCategory(Integer sellerid,Integer mercategoryid);
	/** 检查商户商品分类存在否 */
	public boolean chkMerCategory(Integer sellerid,String cateName) ;
}
