package com.yayao.dao;

import java.util.*;
import com.yayao.bean.*;

/** 商品分类、商品及特价商品业务逻辑处理接口 */
public interface MerDao {	
	/** 新增商品分类 */	
	public void addCategory(Category cate);	
	/** 删除指定的商品分类 */	
	public void delCategory(Integer id) ;	
	/** 更新商品分类 */	
	public void updateCategory(Category cate) ;
	/** 装载指定的商品分类 */	
	public Category loadCategory(Integer id) ;	
	/** 浏览商品分类 */
	public List browseCategory();	
	/** 检查商品分类存在否 */
	public boolean chkCategory(String cateName) ;	
	
	/** 新增商品 */	
	public void addMer(Merchandise mer) ;	
	/** 删除指定的商品 */	
	public void delMer(Integer id) ;	
	/** 更新商品 */	
	public void updateMer(Merchandise mer);
	/** 装载指定的商品 */	
	public Merchandise loadMer(Integer id) ;	
	/** 浏览商品 */
	public List browseMer(String hql) ;	
	
	/** 分页浏览商品 */
	public List browseMer(int pageSize,int pageNo,int cateId1,int cateId2,boolean isSpecial) ;
	/** 检索商品 */
	public List browseMer(int pageSize,int pageNo,String hql) ;	
	/** 后台检索商品（按商品模糊名称） */
	public List searchMerchandise(String merName) ;	
	/** 统计记录条数 */
	public int countRecord(String hql) ;	
}