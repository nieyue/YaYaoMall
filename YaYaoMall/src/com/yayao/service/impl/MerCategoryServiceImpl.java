package com.yayao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yayao.bean.MerCategory;
import com.yayao.dao.MerCategoryDao;
import com.yayao.service.MerCategoryService;


/**
 * 商品分类业务逻辑实现
 * @author yy
 *
 */
@Service("merCategoryService")
public class MerCategoryServiceImpl implements MerCategoryService {
	@Autowired
	@Qualifier("merCategoryDao")
	private MerCategoryDao merCategoryDao;
	
	
	/** 新增商品分类 */	
	public void addMerCategory(MerCategory merCategory) {
		merCategory.setCateDate(new Date());
		merCategoryDao.addMerCategory(merCategory);
	}
	/** 更新商品分类 */
	public void updateMerCategory(MerCategory merCategory) {
		merCategory.setCateDate(new Date());
		merCategoryDao.updateMerCategory(merCategory);
	}
	
	/** 删除指定的商品分类 */	
	public void delMerCategory( Integer mercategoryid) {
		
		merCategoryDao.delMerCategory(mercategoryid);

	}
	/** 浏览商品分类 */
	public List<MerCategory> browseMerCategory(Integer sellerid) {
		List<MerCategory> l = merCategoryDao.browseMerCategory(sellerid);
		return l;
	}
	/** 装载指定的商品分类 */
	public MerCategory loadMerCategory(Integer mercategoryid) {
		MerCategory ml = merCategoryDao.loadMerCategory(mercategoryid);
		return ml;
	}
	/** 检查商品分类存在否 */
	public boolean chkMerCategory(Integer sellerid,String cateName){
		boolean status = merCategoryDao.chkMerCategory(sellerid,cateName);
		return status;
	}
}
