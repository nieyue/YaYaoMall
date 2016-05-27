package com.yayao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yayao.bean.MerchandiseImg;
import com.yayao.dao.MerchandiseImgDao;
import com.yayao.service.MerchandiseImgService;


/**
 * 商品图片分类业务逻辑实现
 * @author yy
 *
 */
@Service("merchandiseImgService")
public class MerchandiseImgServiceImpl implements MerchandiseImgService {
	@Autowired
	@Qualifier("merchandiseImgDao")
	private MerchandiseImgDao merchandiseImgDao;

	/** 新增商品图片 */
	public void addMerchandiseImg(MerchandiseImg merchandiseImg) {
		merchandiseImg.setMerchandiseImgUpdateTime(new Date());
		merchandiseImgDao.addMerchandiseImg(merchandiseImg);
		
	}
	/** 删除指定的商品图片 */
	public void delMerchandiseImg(Integer merchandiseimgid) {
		merchandiseImgDao.delMerchandiseImg(merchandiseimgid);
		
	}
	/** 更新商品图片 */
	public void updateMerchandiseImg(MerchandiseImg merchandiseImg) {
		merchandiseImg.setMerchandiseImgUpdateTime(new Date());
		merchandiseImgDao.updateMerchandiseImg(merchandiseImg);
		
	}
	/** 装载指定的商品图片 */
	@Cacheable(cacheNames="merImgCache")
	public MerchandiseImg loadMerchandiseImg(Integer merchandiseimgid) {
		MerchandiseImg ml = merchandiseImgDao.loadMerchandiseImg(merchandiseimgid);
		return ml;
	}
	/** 浏览商品图片 */
	@Cacheable(cacheNames="merImgCache")
	public List<MerchandiseImg> browseMerchandiseImg(Integer merchandiseimgid,
			String orderName, String orderWay) {
		List<MerchandiseImg> l = merchandiseImgDao.browseMerchandiseImg(merchandiseimgid, orderName, orderWay);
		return l;
	}
	/** 图片地址查询商品图片 */
	@Cacheable(cacheNames="merImgCache")
	public MerchandiseImg imgAddressLoadMerchandiseImg(String imgAddress){
		MerchandiseImg ml = merchandiseImgDao.imgAddressLoadMerchandiseImg(imgAddress);
		return ml;
	}
}
