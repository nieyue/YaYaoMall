package com.yayao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yayao.bean.MerCategory;
import com.yayao.bean.Merchandise;
import com.yayao.bean.MerchandiseImg;
import com.yayao.dao.MerCategoryDao;
import com.yayao.dao.MerchandiseImgDao;
import com.yayao.service.MerCategoryService;
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
		merchandiseImgDao.addMerchandiseImg(merchandiseImg);
		
	}
	/** 删除指定的商品图片 */
	public void delMerchandiseImg(Integer id) {
		merchandiseImgDao.delMerchandiseImg(id);
		
	}
	/** 更新商品图片 */
	public void updateMerchandiseImg(MerchandiseImg merchandiseImg) {
		merchandiseImgDao.updateMerchandiseImg(merchandiseImg);
		
	}
	/** 装载指定的商品图片 */
	public MerchandiseImg loadMerchandiseImg(Integer id) {
		MerchandiseImg ml = merchandiseImgDao.loadMerchandiseImg(id);
		return ml;
	}
	/** 浏览商品图片 */
	public List<MerchandiseImg> browseMerchandiseImg(Merchandise merchandise,
			String orderName, String orderWay) {
		List<MerchandiseImg> l = merchandiseImgDao.browseMerchandiseImg(merchandise, orderName, orderWay);
		return l;
	}
}
