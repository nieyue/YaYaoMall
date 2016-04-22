package com.yayao.service.impl;

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
		merCategoryDao.addMerCategory(merCategory);
	}
	/** 更新商品分类 */
	public void updateMerCategory(MerCategory merCategory) {
		merCategoryDao.updateMerCategory(merCategory);
	}
	
	/** 删除指定的商品分类 */	
	public void delMerCategory(Integer id) {
		merCategoryDao.delMerCategory(id);

	}
	/** 浏览商品分类 */
	public List<MerCategory> browseMerCategory() {
		List<MerCategory> l = merCategoryDao.browseMerCategory();
		return l;
	}
	/** 装载指定的商品分类 */
	public MerCategory loadMerCategory(Integer id) {
		MerCategory ml = merCategoryDao.loadMerCategory(id);
		return ml;
	}
	/** 检查商品分类存在否 */
	public boolean chkMerCategory(String cateName){
		boolean status = merCategoryDao.chkMerCategory(cateName);
		return status;
	}
}
