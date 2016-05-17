package com.yayao.dao;

import java.util.List;

import com.yayao.bean.MerCategory;
import com.yayao.bean.Merchandise;

/**
 * 商品数据访问接口
 * @author yy
 *
 */
public interface MerchandiseDao {
	/** 新增商品 */	
	public void addMer(Merchandise merchandise) ;	
	/** 删除指定的商品 */	
	public void delMer(Integer sellerid,Integer merchandiseid) ;	
	/** 更新商品 */	
	public void updateMer(Merchandise merchandise);
	/** 装载指定的商品 */	
	public Merchandise loadMer(Integer merchandiseid) ;	
	/** 浏览商品 */
	public List<Merchandise> browseMer(MerCategory merCategory,String orderName,String orderWay) ;	
	
	/** 分页浏览商品 */
	public List<Merchandise> browseMer(int pageSize,int pageNo,MerCategory merCategory,String orderName,String orderWay) ;
	/** 后台检索商品（按商品模糊名称） */
	public List<Merchandise> searchMerchandise(MerCategory merCategory,String merName) ;	
	/** 统计记录条数 */
	public int countRecord(MerCategory merCategory);
	
}

