package com.yayao.dao;

import java.util.List;

import com.yayao.bean.MerCategory;

/**
 * 商品分类数据访问接口
 * @author yy
 *
 */
public interface MerCategoryDao {
	/** 新增商品分类 */	
	public void addMerCategory(MerCategory merCategory) ;
	/** 更新商品分类 */		
	public void updateMerCategory(MerCategory merCategory) ;
	/** 删除指定的商品分类 */	
	public void delMerCategory(Integer id) ;	
	/** 浏览商品分类 */
	public List<MerCategory> browseMerCategory() ;
	/** 装载指定的商品分类 */
	public MerCategory loadMerCategory(String cateName);
	/** 检查商品分类存在否 */
	public boolean chkMerCategory(String cateName) ;
	
}

