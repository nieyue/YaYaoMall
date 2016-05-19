package com.yayao.dao;

import java.util.List;

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
	public void delMer(Integer merchandiseid) ;	
	/** 更新商品 */	
	public void updateMer(Merchandise merchandise);
	/** 装载指定的商品 */	
	public Merchandise loadMer(Integer merchandiseid) ;	
	/** 浏览类别商品 */
	public List<Merchandise> browseMerByMerCate(Integer mercategoryid,String orderName,String orderWay) ;	
	/** 根据商家浏览商品 */
	public List<Merchandise> browseMerBySeller(Integer sellerid,String orderName,String orderWay) ;	
	
	/** 根据类别分页浏览商品 */
	public List<Merchandise> browseMerByMerCate(int pageSize,int pageNo,Integer mercategoryid,String orderName,String orderWay) ;
	/** 根据商家分页浏览商品 */
	public List<Merchandise> browseMerBySeller(int pageSize,int pageNo,Integer sellerid,String orderName,String orderWay) ;
	/** 后台检索商品（按商品模糊名称） */
	public List<Merchandise> searchMerchandise(Integer sellerid,String merName) ;	
	/** 统计记录条数 */
	public int countRecord(Integer sellerid,Integer mercategoryid);
	
}

