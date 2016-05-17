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
	public void addMer(Merchandise merchandise) {
		merchandiseDao.addMer(merchandise);
		
	}

	/** 删除指定的商品 */
	public void delMer(Integer sellerid,Integer merchandiseid) {
		merchandiseDao.delMer(sellerid,merchandiseid);
		
	}

	/** 更新商品 */	
	public void updateMer(Merchandise merchandise) {
		merchandiseDao.updateMer(merchandise);
		
	}

	/** 装载指定的商品 */
	public Merchandise loadMer(Integer merchandiseid) {
		Merchandise mer = merchandiseDao.loadMer(merchandiseid);
		return mer;
	}

	/** 浏览商品 */
	public List<Merchandise> browseMer(MerCategory merchandise,String orderName,String orderWay) {
		List<Merchandise> list = merchandiseDao.browseMer(merchandise, orderName,orderWay);
		return list;
	}

	/** 分页浏览商品 */
	public List<Merchandise> browseMer(int pageSize, int pageNo,MerCategory merchandise,String orderName,String orderWay) {
		List<Merchandise> list = merchandiseDao.browseMer(pageSize,pageNo,merchandise, orderName,orderWay);
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
