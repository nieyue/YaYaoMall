package com.yayao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
		merchandise.setMerchandiseStatus("上架");//初始化
		merchandise.setMerchandiseUpdateTime(new Date());
		merchandiseDao.addMer(merchandise);
		
	}

	/** 删除指定的商品 */
	public void delMer(Integer merchandiseid) {
		merchandiseDao.delMer(merchandiseid);
		
	}

	/** 更新商品 */	
	public void updateMer(Merchandise merchandise) {
		merchandiseDao.updateMer(merchandise);
		
	}

	/** 装载指定的商品 */
	@Cacheable(cacheNames="merCache")
	public Merchandise loadMer(Integer merchandiseid) {
		Merchandise mer = merchandiseDao.loadMer(merchandiseid);
		return mer;
	}

	/** 浏览类别商品 */
	@Cacheable(cacheNames="merCache")
	public List<Merchandise> browseMerByMerCate(Integer mercategoryid,
			String orderName, String orderWay) {
		List<Merchandise> list = merchandiseDao.browseMerByMerCate(mercategoryid, orderName,orderWay);
		return list;
	}

	/** 根据商家浏览商品 */
	@Cacheable(cacheNames="merCache")
	public List<Merchandise> browseMerBySeller(Integer sellerid,
			String orderName, String orderWay) {
		List<Merchandise> list = merchandiseDao.browseMerBySeller(sellerid, orderName,orderWay);
		return list;
	}

	/** 根据类别分页浏览商品 */
	@Cacheable(cacheNames="merCache")
	public List<Merchandise> browseMerByMerCate(int pageSize, int pageNo,
			Integer mercategoryid, String orderName, String orderWay) {
		List<Merchandise> merlist = merchandiseDao.browseMerByMerCate(pageSize, pageNo, mercategoryid, orderName, orderWay);
		return merlist;
	}

	/** 根据商家分页浏览商品 */
	@Cacheable(cacheNames="merCache")
	public List<Merchandise> browseMerBySeller(int pageSize, int pageNo,
			Integer sellerid, String orderName, String orderWay) {
		List<Merchandise> merlist = merchandiseDao.browseMerBySeller(pageSize, pageNo, sellerid, orderName, orderWay);
		return merlist;
	}

	/** 后台检索商品（按商品模糊名称） */
	@Cacheable(cacheNames="merCache")
	public List<Merchandise> searchMerchandise(Integer sellerid, String merName) {
		List<Merchandise> merlist = merchandiseDao.searchMerchandise(sellerid,merName);
		return merlist;
	}

	/** 统计记录条数 */
	@Cacheable(cacheNames="merCache")
	public int countRecord(Integer sellerid, Integer mercategoryid) {
		int cr = merchandiseDao.countRecord(sellerid, mercategoryid);
		return cr;
	}
	
	
}
