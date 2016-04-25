package com.yayao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yayao.bean.MerCategory;
import com.yayao.bean.Merchandise;
import com.yayao.dao.MerchandiseDao;
import com.yayao.service.MerchandiseService;


/**
 * 商品业务逻辑实现
 * @author yy
 *
 */
@Service("merchandiseService")
public class MerchandiseServiceImpl implements MerchandiseService {
	@Autowired
	@Qualifier("merchandiseDao")
	private MerchandiseDao merchandiseDao;

	/** 新增商品 */	
	public void addMer(Merchandise mer) {
		merchandiseDao.addMer(mer);
		
	}

	/** 删除指定的商品 */
	public void delMer(Integer id) {
		merchandiseDao.delMer(id);
		
	}

	/** 更新商品 */	
	public void updateMer(Merchandise mer) {
		merchandiseDao.updateMer(mer);
		
	}

	/** 装载指定的商品 */
	public Merchandise loadMer(Integer id) {
		Merchandise mer = merchandiseDao.loadMer(id);
		return mer;
	}

	/** 浏览商品 */
	public List<Merchandise> browseMer(MerCategory cate,String orderName,String orderWay) {
		List<Merchandise> list = merchandiseDao.browseMer(cate, orderName,orderWay);
		return list;
	}

	/** 分页浏览商品 */
	public List<Merchandise> browseMer(int pageSize, int pageNo,MerCategory cate,String orderName,String orderWay) {
		List<Merchandise> list = merchandiseDao.browseMer(pageSize,pageNo,cate, orderName,orderWay);
		return list;
	}

	/** 后台检索商品（按商品模糊名称） */
	public List<Merchandise> searchMerchandise(MerCategory cate,String merName) {
		List<Merchandise> l = merchandiseDao.searchMerchandise(cate, merName);
		return l;
	}

	/** 统计记录条数 */
	public int countRecord(MerCategory cate) {
		int num = merchandiseDao.countRecord(cate);
		return num;
	}
	
	
}
