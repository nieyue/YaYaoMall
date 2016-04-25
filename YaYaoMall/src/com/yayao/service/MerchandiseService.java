package com.yayao.service;

import java.util.List;

import com.yayao.bean.MerCategory;
import com.yayao.bean.Merchandise;
/**
 * 商品业务逻辑接口
 * @author yy
 *
 */
public interface MerchandiseService {
	/** 新增商品 */	
	public void addMer(Merchandise mer) ;	
	/** 删除指定的商品 */	
	public void delMer(Integer id) ;	
	/** 更新商品 */	
	public void updateMer(Merchandise mer);
	/** 装载指定的商品 */	
	public Merchandise loadMer(Integer id) ;	
	/** 浏览商品 */
	public List<Merchandise> browseMer(MerCategory cate,String orderName,String orderWay) ;	
	
	/** 分页浏览商品 */
	public List<Merchandise> browseMer(int pageSize,int pageNo,MerCategory cate,String orderName,String orderWay) ;
	/** 后台检索商品（按商品模糊名称） */
	public List<Merchandise> searchMerchandise(MerCategory cate,String merName) ;	
	/** 统计记录条数 */
	public int countRecord(MerCategory cate);
}
